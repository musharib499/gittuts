package com.gaadi.sfa.syncadapter;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;

import com.gaadi.sfa.model.DealerApiModel;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.model.DealerRootModel;
import com.gaadi.sfa.model.FollowUpModel;
import com.gaadi.sfa.model.PreviousVisitModel;
import com.gaadi.sfa.provider.dealertable.DealertableColumns;
import com.gaadi.sfa.provider.dealertable.DealertableContentValues;
import com.gaadi.sfa.provider.dealertable.DealertableCursor;
import com.gaadi.sfa.provider.dealertable.DealertableSelection;
import com.gaadi.sfa.provider.followuptable.FollowuptableColumns;
import com.gaadi.sfa.provider.followuptable.FollowuptableContentValues;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableColumns;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableContentValues;
import com.gaadi.sfa.retrofit.RetrofitRequest;
import com.gaadi.sfa.utils.AppConstants;
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.SyncUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by vinodtakhar on 9/2/16.
 */
public class SfaSyncManager {
    private static final String TAG = "SfaSyncManager";

    public static final int SYNC_SCOPE_DEALER =1;
    public static final int SYNC_SCOPE_OTHER =2;

    public static final int SYNC_SCOPE_ALL = SYNC_SCOPE_DEALER | SYNC_SCOPE_OTHER;

    public static final String EXTRA_SYNC_SCOPE ="extra_sync_scope";


    public static final int SYNC_MODE_ASSETS=1;
    public static final int SYNC_MODE_LIVE=2;

    public static final String EXTRA_SYNC_MODE="extra_sync_mode";


    private Context context;
    private Bundle extras;

    private SfaSyncManager(Context context,Bundle bundle){
        this.context=context;
        this.extras=bundle;
    }

    public static void startAsynchronous(Context context,Bundle bundle){

        if(Build.VERSION.SDK_INT<=Build.VERSION_CODES.LOLLIPOP) {

            if (!SyncUtils.createSyncAccountIfNotExistOrDisabled(context, bundle))
                SyncUtils.startSync(bundle);
        }else{
            SfaJobService.scheduleJob(context);
        }
    }

    public static void startSynchronized(Context context,Bundle bundle) throws JSONException {
        new SfaSyncManager(context,bundle).syncNow();
    }

    public static boolean hasOfflineData(Context context){
        boolean hasData=true;

        DealertableCursor cursor=new DealertableSelection().query(context.getContentResolver());

        if(cursor==null || cursor.getCount()==0)
            hasData=false;
        else
            hasData=true;

        if(cursor!=null)cursor.close();

        return hasData;
    }

    private void syncNow() throws JSONException {
        int syncMode=extras!=null?extras.getInt(EXTRA_SYNC_MODE,SYNC_MODE_LIVE):SYNC_MODE_LIVE;

        if(syncMode==SYNC_MODE_ASSETS){
            syncFromAssets();
        }else if(syncMode==SYNC_MODE_LIVE) {
            syncFromServer();
        }
    }

    private void syncFromAssets(){
        Logger.e("Sync databases from assets");

        int syncType=extras!=null?extras.getInt(EXTRA_SYNC_SCOPE, SYNC_SCOPE_ALL): SYNC_SCOPE_ALL;

        if((syncType & SYNC_SCOPE_DEALER)== SYNC_SCOPE_DEALER) {
            String dealerJson = readAsset(context.getAssets(), "dealer_list.json");
            updateDealers(new Gson().fromJson(dealerJson, DealerApiModel.class).getDealers());
        }
    }

    private void syncFromServer() throws JSONException {
        Logger.e("Sync databases from server");

        int syncType=extras!=null?extras.getInt(EXTRA_SYNC_SCOPE, SYNC_SCOPE_ALL): SYNC_SCOPE_ALL;

        if((syncType & SYNC_SCOPE_DEALER)== SYNC_SCOPE_DEALER)
            performAgentRequest();
    }

    private void performAgentRequest() throws JSONException {

        Logger.e(TAG + " performing agent/dealer request");

        RetrofitRequest.getDealershipsInCity(AppPrefrences.getLoginResponseModel(context).getLoginData().getEmail(), AppPrefrences.getLoginResponseModel(context).getLoginData().getPassword(), new Callback<DealerRootModel>() {

            @Override
            public void success(DealerRootModel dealershipModel, Response response) {

                Logger.e(TAG, "dealerships: " + dealershipModel);

                updateDealers(dealershipModel.getDealerApiModel().getDealers());
            }

            @Override
            public void failure(RetrofitError error) {
                error.printStackTrace();
                Logger.e(TAG, "error: " + error.getMessage());
            }
        });
    }

    private void updateDealers(ArrayList<DealerModel> dealers) {

        if (dealers != null && dealers.size()>0) {

            context.getContentResolver().delete(DealertableColumns.CONTENT_URI,null,null);
            context.getContentResolver().delete(FollowuptableColumns.CONTENT_URI,null,null);
            context.getContentResolver().delete(PreviousvisittableColumns.CONTENT_URI,null,null);

            ArrayList<ContentValues> dealerList = new ArrayList<>();
            ArrayList<ContentValues> followUpList = new ArrayList<>();
            ArrayList<ContentValues> lastVisitList = new ArrayList<>();

            DealertableContentValues dealertableContentValues;
            FollowuptableContentValues followuptableContentValues;
            PreviousvisittableContentValues lastvisittableContentValues;

            for (DealerModel dealer : dealers) {
                dealertableContentValues = new DealertableContentValues();

                dealertableContentValues.putDealerid(dealer.getDealerId());
                dealertableContentValues.putDealername(dealer.getDealerName());
                dealertableContentValues.putAssigned(dealer.isAssigned() ? 1 : 0);
                dealertableContentValues.putMobile(dealer.getMobile());
                dealertableContentValues.putLatitude(dealer.getLatitude());
                dealertableContentValues.putLongitude(dealer.getLongitude());
                dealertableContentValues.putArea(dealer.getArea());
                dealertableContentValues.putLogintoken(dealer.getLoginToken());


                dealerList.add(dealertableContentValues.values());

                for(FollowUpModel followUpModel: dealer.getFollowUpModel()){
                    followuptableContentValues = new FollowuptableContentValues();

                    followuptableContentValues.putComments(followUpModel.getComments());
                    followuptableContentValues.putDealerid(dealer.getDealerId());
                    followuptableContentValues.putDate(followUpModel.getDate());
                    followuptableContentValues.putOverdue(followUpModel.isOverdue()?1:0);

                    followUpList.add(followuptableContentValues.values());
                }

                for(PreviousVisitModel lastVisitModel: dealer.getLastVisitModel()){
                    lastvisittableContentValues = new PreviousvisittableContentValues();

                    lastvisittableContentValues.putComments(lastVisitModel.getComments());
                    lastvisittableContentValues.putDealerid(dealer.getDealerId());
                    lastvisittableContentValues.putDate(lastVisitModel.getDate());
                    lastvisittableContentValues.putCheckin(lastVisitModel.getCheckin());
                    lastvisittableContentValues.putCheckout(lastVisitModel.getCheckout());

                    lastVisitList.add(lastvisittableContentValues.values());
                }
            }

            int r = context.getContentResolver().bulkInsert(DealertableColumns.CONTENT_URI, dealerList.toArray(new ContentValues[0]));
            Logger.e(TAG,"Dealer add count : " + r);

            r = context.getContentResolver().bulkInsert(FollowuptableColumns.CONTENT_URI, followUpList.toArray(new ContentValues[0]));
            Logger.e(TAG,"followup add count : " + r);

             r = context.getContentResolver().bulkInsert(PreviousvisittableColumns.CONTENT_URI, lastVisitList.toArray(new ContentValues[0]));
            Logger.e(TAG,"lastvisit add count : " + r);
        }
    }

    private String readAsset(AssetManager mgr, String path) {
        String contents = "";
        InputStream is = null;
        BufferedReader reader = null;
        try {
            is = mgr.open(path);
            reader = new BufferedReader(new InputStreamReader(is));
            contents = reader.readLine();
            String line = null;
            while ((line = reader.readLine()) != null) {
                contents += '\n' + line;
            }
        } catch (final Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException ignored) {
                }
            }
        }
        return contents;
    }
}
