package com.gaadi.sfa.ui;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.gaadi.sfa.utils.AppDialog;
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.Utils;


/**
 * Created by vinodtakhar on 11/2/16.
 */
public class SfaBaseActivity extends AppCompatActivity {

    private static final int PERMISSIONS_REQUEST_CODE = 100;
    private String permissionBeingAsked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void requestPermission(String permission) {

        permissionBeingAsked = permission;

        if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission) || !AppPrefrences.getBooleanSharedPreference(this, permission, false)) {
                AppPrefrences.setBooleanSharedPreference(this, permission, true); /*set  that we have already asked the permission to handle rational*/

                ActivityCompat.requestPermissions(this,
                        new String[]{permission},
                        PERMISSIONS_REQUEST_CODE);
            } else
                AppDialog.showPermissionRequiredDialog(this, "Permission Required", "Kindly grant required permissions in Application Settings under Permissions", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Utils.openAppSettings(SfaBaseActivity.this);
                    }
                });
        } else {
            onPermissionGranted(permissionBeingAsked);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSIONS_REQUEST_CODE:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) //remove this line to make recursive
                    onPermissionGranted(permissionBeingAsked);
                else
                    onPermissionDenied(permissionBeingAsked);
                break;
        }
    }

    public void onPermissionGranted(String grantedPermission) {
    }

    public void onPermissionDenied(String deniedPermission) {
    }
}
