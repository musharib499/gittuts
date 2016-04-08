package com.gaadi.sfa.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import com.gaadi.sfa.ApplicationController;
import com.gaadi.sfa.BuildConfig;
import com.gaadi.sfa.R;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import retrofit.RetrofitError;

/**
 * Created by vinodtakhar on 7/1/16.
 */
public class Utils {
    //for gcloud launch
    private static final String GCLOUD_APP_PACKAGE = BuildConfig.GAADI_PACKAGE;
    private static final String ACTION_GCLOUD_LOGIN = "com.gcloud.gaadi.ACTION_SFA_LOGIN";
    private static final String EXTRA_LOGIN_TOKEN = "login_token";

    public static void animateActivity(Activity activity, String action) {


        if (action.equalsIgnoreCase("next")) {

            activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

        }
        else if (action.equalsIgnoreCase("back")) {
            activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
        else if (action.equalsIgnoreCase("up")) {
            activity.overridePendingTransition(R.anim.push_up_in,
                    R.anim.push_up_out);
        }
        else if (action.equalsIgnoreCase("down")) {
            activity.overridePendingTransition(R.anim.push_down_in,
                    R.anim.push_down_out);
        }

        else if (action.equalsIgnoreCase("fadein")) {
            activity.overridePendingTransition(R.anim.fade_in,
                    R.anim.fade_out);
        }
        else if (action.equalsIgnoreCase("zero")) {
            activity.overridePendingTransition(R.anim.zero_duration,
                    R.anim.zero_duration);
        }

    }

    public static void fireGCloudInstallOrLaunchIntent(Context context,String loginToken) throws UnsupportedEncodingException {
        if(isGcloudAppExisted(context)){
            //create login intent and fire
            Intent intent=new Intent(ACTION_GCLOUD_LOGIN);
            Bundle bundle=new Bundle();
            bundle.putString(EXTRA_LOGIN_TOKEN, "f-12121212");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        }else{
            //create referral intent and fire
            launchGCloudPlayStoreLink(context,getReferrerString(loginToken));
        }
    }

    private static String getReferrerString(String loginToken) throws UnsupportedEncodingException {
        StringBuilder stringBuilder=new StringBuilder();

        stringBuilder.append("utm_campaign=gcloudaccess&");
        stringBuilder.append("utm_source=sfa&");
        stringBuilder.append("utm_medium=playstore&");
        stringBuilder.append("utm_content=" + loginToken);

        return URLEncoder.encode(stringBuilder.toString(), "UTF-8");
    }

    public static boolean isGcloudAppExisted(Context context){
        return isPackageExisted(context, GCLOUD_APP_PACKAGE);
    }

    private static boolean isPackageExisted(Context context,String targetPackage){
        PackageManager pm=context.getPackageManager();
        try {
            PackageInfo info=pm.getPackageInfo(targetPackage, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
        return true;
    }

    private static void launchGCloudPlayStoreLink(Context context,String referrerString){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id="+GCLOUD_APP_PACKAGE+"&referrer="+referrerString));
        context.startActivity(intent);
    }

    public static String getNetworkClass(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if(info==null || !info.isConnected())
            return "-"; //not connected
        if(info.getType() == ConnectivityManager.TYPE_WIFI)
            return "WIFI";
        if(info.getType() == ConnectivityManager.TYPE_MOBILE){
            int networkType = info.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN: //api<8 : replace by 11
                    return "2G";
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B: //api<9 : replace by 14
                case TelephonyManager.NETWORK_TYPE_EHRPD:  //api<11 : replace by 12
                case TelephonyManager.NETWORK_TYPE_HSPAP:  //api<13 : replace by 15
                    return "3G";
                case TelephonyManager.NETWORK_TYPE_LTE:    //api<11 : replace by 13
                    return "4G";
                default:
                    return "?";
            }
        }
        return "?";
    }

    public static void handleErrorToast(RetrofitError error) {
        switch (error.getKind()) {
            case NETWORK:
                Toast.makeText(ApplicationController.getInstance(),
                        ApplicationController.getInstance().getString(R.string.network_error),
                        Toast.LENGTH_SHORT).show();
                break;

            case UNEXPECTED:

                Toast.makeText(ApplicationController.getInstance(),
                        ApplicationController.getInstance().getString(R.string.server_error),
                        Toast.LENGTH_SHORT).show();
                break;

            case CONVERSION:
                Toast.makeText(ApplicationController.getInstance(),
                        ApplicationController.getInstance().getString(R.string.application_error),
                        Toast.LENGTH_SHORT).show();
                break;

            case HTTP:
                Toast.makeText(ApplicationController.getInstance(),
                        ApplicationController.getInstance().getString(R.string.server_error),
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }


    public static String getStringTwoWordInCap(String st) {
        String s = "";
        if (!st.isEmpty()) {
            int i = 0;
            int spaceCount = 0;

            s += st.charAt(0);
            while (i < st.length()) {
                if (st.charAt(i) == ' ') {
                    spaceCount++;
                    if (spaceCount == 1) {
                        s += st.charAt(i + 1);
                    }

                }
                i++;
            }
        }

        return s;
    }
    public static void openAppSettings(Context context) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", context.getPackageName(), null);
        intent.setData(uri);
        context.startActivity(intent);
    }

    public static void callPhone(Context context,String phone) {
        try {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
            context.startActivity(intent);
        } catch (SecurityException e) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phone));
            context.startActivity(intent);
        }
    }
}
