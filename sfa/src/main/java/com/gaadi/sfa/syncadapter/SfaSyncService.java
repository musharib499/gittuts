package com.gaadi.sfa.syncadapter;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.gaadi.sfa.utils.Logger;


/**
 * Created by vinodtakhar on 2015/01/03.
 */
public class SfaSyncService extends Service {
    private static final Object sSyncAdapterLock = new Object();
    private static final String TAG = "SfaSyncService";
    private static SfaSyncAdapter sSyncAdapter = null;

    /**
     * Thread-safe constructor, creates static {@link Service} instance.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.e(TAG + "Service created");
        synchronized (sSyncAdapterLock) {
            if (sSyncAdapter == null) {
                sSyncAdapter = new SfaSyncAdapter(getApplicationContext(), true);
            }
        }
    }

    @Override
    /**
     * Logging-only destructor.
     */
    public void onDestroy() {
        super.onDestroy();
        Logger.e(TAG + "Service destroyed");
    }

    /**
     * Return Binder handle for IPC communication with {@link Intent}.
     * <p/>
     * <p>New sync requests will be sent directly to the SyncAdapter using this channel.
     *
     * @param intent Calling intent
     * @return Binder handle for {@link IBinder}
     */
    @Override
    public IBinder onBind(Intent intent) {
        return sSyncAdapter.getSyncAdapterBinder();
    }
}
