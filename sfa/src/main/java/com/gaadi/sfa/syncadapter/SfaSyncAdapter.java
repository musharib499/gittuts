package com.gaadi.sfa.syncadapter;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;

import com.gaadi.sfa.utils.Logger;


/**
 * Created by vinodtakhar on 2015/01/03.
 */
public class SfaSyncAdapter extends AbstractThreadedSyncAdapter {

    private static final String TAG = "SfaSyncAdapter";
    private Context context;

    public SfaSyncAdapter(Context context, boolean autoInitialize) {
        super(context, autoInitialize,false);
        this.context = context;
    }

    public SfaSyncAdapter(Context context, boolean autoInitialize, boolean allowParallelSyncs) {
        super(context, autoInitialize, allowParallelSyncs);
        this.context = context;
    }

    @Override
    public void onPerformSync(Account account,
                              Bundle extras,
                              String authority,
                              ContentProviderClient provider,
                              SyncResult syncResult) {
        try {
            SfaSyncManager.startSynchronized(context,extras);
        } catch (Exception e) {
            Logger.e(TAG, "exception: " + e.getMessage());
        }
    }
}
