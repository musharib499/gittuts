package com.gaadi.sfa.retrofit;

import android.content.Context;

import com.gaadi.sfa.ApplicationController;
import com.gaadi.sfa.utils.AppConstants;
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.Utils;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import com.gaadi.sfa.BuildConfig;

/**
 * Created by vinodtakhar
 */
public class RetrofitFieldMap {

    //private Response.Listener<UpgradeCheckModel> mListener;
    //private Response.ErrorListener mErrorErrorListener;
    private Context mContext;
    private HashMap<String, String> mParams;
    private JSONObject jsonObject;

    public RetrofitFieldMap(Context context,
                            HashMap<String, String> params) {
        mContext = context;
        if (params == null) {
            mParams = new HashMap<>();
        } else {
            mParams = params;
        }

    }

    public RetrofitFieldMap(Context context, JSONObject jsonObject) {
        mContext = context;

        if (jsonObject == null) {
            this.jsonObject = new JSONObject();
        } else {
            this.jsonObject = jsonObject;
        }
    }

    public String getJsonParams() {
        try {
            jsonObject.put(AppConstants.APP_PACKAGE_NAME, BuildConfig.APPLICATION_ID);
            jsonObject.put(AppConstants.MODEL_ID, BuildConfig.MODEL_ID);
            jsonObject.put(AppConstants.API_KEY_LABEL, BuildConfig.API_KEY);
            jsonObject.put(AppConstants.APP_VERSION_CODE, AppPrefrences.getSharedPreference(ApplicationController.getInstance(), AppConstants.APP_VERSION_CODE));
            jsonObject.put(AppConstants.API_RESPONSE_FORMAT_LABEL, BuildConfig.API_RESPONSE_FORMAT);
            jsonObject.put(AppConstants.PLATFORM_SOURCE, "AndroidApp");
            jsonObject.put(AppConstants.FAST_NETWORK, String.valueOf(!Utils.getNetworkClass(mContext).equalsIgnoreCase("2G")));

            Logger.e("Params ", jsonObject.toString());

        } catch (Exception e) {

        }

        return jsonObject.toString();
    }



}
