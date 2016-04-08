package com.gaadi.sfa;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Created by ankitgarg on 10/11/15.
 */
public class ApplicationController extends Application {


    private static final String TAG = "ApplicationController.java";


    private static ApplicationController mInstance;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        mInstance = this;
    }

    public static Application getInstance() {
        return mInstance;
    }
}
