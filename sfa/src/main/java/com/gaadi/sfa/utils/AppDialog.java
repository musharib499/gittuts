package com.gaadi.sfa.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.provider.Settings;

import com.gaadi.sfa.R;


/**
 * Created by ashish123 on 28/6/15.
 */
public class AppDialog {

    public static void showNoConnectionDialog(final Activity activity) {

        AlertDialog.Builder builder;// = new AlertDialog.Builder(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }

        builder.setCancelable(true);
        builder.setMessage(R.string.no_connection);
        builder.setTitle(R.string.no_connection_title);
        builder.setPositiveButton(R.string.settings_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                activity.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
            }
        });

        builder.setNegativeButton(R.string.cancel_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                return;
            }
        });

        builder.show();
    }

    public static void showPermissionRequiredDialog(final Context activity, String title, String msg, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder;// = new AlertDialog.Builder(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }

        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton(R.string.go_to_app_settings, onClickListener);

        builder.show();
    }

    public static void showErrorDialog(final Activity activity, String title, String msg) {

        AlertDialog.Builder builder;// = new AlertDialog.Builder(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }

        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.setTitle(title);
        builder.setPositiveButton(R.string.cancel_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

                activity.finish();
            }
        });

       /* builder.setNegativeButton(R.string.cancel_button_text, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                return;
            }
        });*/

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                return;
            }
        });

        builder.show();
    }

    public static void showLoginErrorDialog(final Activity activity, String msg) {

        AlertDialog.Builder builder;// = new AlertDialog.Builder(activity);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(activity, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(activity);
        }

        builder.setCancelable(true);
        builder.setMessage(msg);
        builder.setTitle(R.string.error_title);
        builder.setPositiveButton(R.string.cancel_button_text, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //  activity.finish();
            }
        });

       /* builder.setNegativeButton(R.string.cancel_button_text, new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                return;
            }
        });*/

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {

                return;
            }
        });

        builder.show();
    }

    public void showNetworkErrorDialog(Activity activity) {

    }


}
