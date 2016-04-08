package com.gaadi.sfa.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.gaadi.sfa.model.BaseResponseModel;
import com.google.gson.Gson;

/**
 * Created by ashish123 on 27/6/15.
 */
public class AppPrefrences {

    private static Context ctx;

    public static void setSharedPreference(Context ctx, String Key, String Value) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Key, Value);
        editor.apply();
    }


    public static void setBooleanSharedPreference(Context ctx, String key, boolean value) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static void setIntSharedPreference(Context ctx, String key, int value) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }


    public static String getSharedPreference(Context ctx, String Key) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);

        if (pref.contains(Key)) {

            return pref.getString(Key, "");
        } else
            return null;
    }

    public static void DeleteSharedPreference(Context ctx, String Key) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        if (pref.contains(Key)) {
            editor.remove(Key);
            editor.commit();
        }
    }


    public static boolean getBooleanSharedPreference(Context ctx, String Key, Boolean defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        Logger.i("key", ":" + Key);
        if (pref.contains(Key)) {
            Logger.i("Print id  s", ":" + pref.getBoolean(Key, defaultValue));
            return pref.getBoolean(Key, defaultValue);
        } else
            return defaultValue;
    }

    public static int getIntSharedPreference(Context ctx, String Key, int defaultValue) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        Logger.i("key", ":" + Key);
        if (pref.contains(Key)) {
            Logger.i("Print id  s", ":" + pref.getInt(Key, defaultValue));
            return pref.getInt(Key, defaultValue);
        } else
            return defaultValue;
    }


    public static void setLongSharedPreference(Context ctx, String key, long value) {
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLongSharedPreference(Context ctx, String Key) {
        if(null == ctx){
            return 0;
        }
        SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return pref.getLong(Key, 0l);
    }

    public static boolean saveLoginResult(Context ctx,BaseResponseModel loginResponseModel) {

        try {
            SharedPreferences mPrefs = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();
            Gson gson = new Gson();
            String json = gson.toJson(loginResponseModel);

            Logger.e("Saved String ", json);

            prefsEditor.putString(AppConstants.LOGIN_OBJECT, json);
            prefsEditor.commit();


            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public static void resetLoginResult(Context ctx) {

        try {
            SharedPreferences mPrefs = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            SharedPreferences.Editor prefsEditor = mPrefs.edit();

            prefsEditor.putString(AppConstants.LOGIN_OBJECT, "");
            prefsEditor.commit();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    @Nullable
    public static BaseResponseModel getLoginResponseModel(Context ctx) {

        try {
            SharedPreferences pref = ctx.getSharedPreferences(AppConstants.APP_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            Gson gson = new Gson();
            String json = pref.getString(AppConstants.LOGIN_OBJECT, "");

            Logger.e("Login result",""+json);

            BaseResponseModel obj = gson.fromJson(json, BaseResponseModel.class);
            return (obj != null) ? obj : new BaseResponseModel();
        }
        catch (Exception e)
        {
            Logger.e("Error ", e.toString());
            return  new BaseResponseModel();
        }
    }
}
