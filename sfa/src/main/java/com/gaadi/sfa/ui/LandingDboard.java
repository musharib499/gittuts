package com.gaadi.sfa.ui;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.gaadi.sfa.R;
import com.gaadi.sfa.adapter.FabAdapter;
import com.gaadi.sfa.customview.BadgeDrawable;
import com.gaadi.sfa.utils.Utils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStates;
import com.google.android.gms.location.LocationSettingsStatusCodes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanishroshan on 3/2/16.
 */
public class LandingDboard extends BaseNavigationViewActivity implements SfaItemClickListener, View.OnClickListener {
    private static final String TAG = "LandingDashboard";
    private static final int REQUEST_CHECK_SETTINGS = 1003;
    MenuItem menuItem;
    LayerDrawable icon;
    private Boolean isFabOpen = false;
    private List<TitleData> titleList = new ArrayList<>();
    private FabAdapter mAdapter;
    private RecyclerView recyclerView;
    private LinearLayout layoutRecycle;
    private GoogleApiClient googleApiClient;
    private LinearLayout lay_visited;
    private int actionPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.landingdboard, frameLayout);
       /* getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);*/
        fab.setVisibility(View.VISIBLE);
        fab_text.setVisibility(View.VISIBLE);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        lay_visited = (LinearLayout) findViewById(R.id.lay_visited);

        layoutRecycle = (LinearLayout) findViewById(R.id.layoutRecycle);

        lay_visited.setOnClickListener(this);
        mAdapter=new FabAdapter(titleList);
        navigationView.setNavigationItemSelectedListener(this);

        final LinearLayoutManager layoutManager = new org.solovyev.android.views.llm.LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAdapter.setOnItemClickListener(this);

        recyclerView.setAdapter(mAdapter);
        prepareData();


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFabOpen) {


                    fab.setImageDrawable(getBaseContext().getResources().getDrawable(R.drawable.close));
                    layoutRecycle.setVisibility(View.VISIBLE);

                    fab_text.setVisibility(View.INVISIBLE);
                    isFabOpen = true;
                } else {

                    fab.setImageDrawable(getBaseContext().getResources().getDrawable(R.drawable.ic_checkin_solo));
                    if (layoutRecycle.getVisibility() == View.VISIBLE) {
                        layoutRecycle.setVisibility(View.GONE);
                    }

                    fab_text.setVisibility(View.VISIBLE);
                    isFabOpen = false;
                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_landingboard, menu);

        MenuItem itemCart = menu.findItem(R.id.action_notification);
        LayerDrawable icon = (LayerDrawable) itemCart.getIcon();
        BadgeDrawable.setBadgeCount(this, icon, "100", R.id.action_notification);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        menuItem = item;
        switch (item.getItemId()) {
            case R.id.action_search:
                Toast.makeText(this, "search is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_notification:
                Toast.makeText(this, "notification is Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_profile:
                Toast.makeText(this, "Profile is Selected", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }


    }

    @Override
    public void onBackPressed() {
        if (isFabOpen){
            closeFabMenu();
        }
        else
        super.onBackPressed();
    }

    public void onGcloud(View view){
        try {
            Utils.fireGCloudInstallOrLaunchIntent(this,"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onMyDealers(View view){
        startActivity(new Intent(this, DealerListActivity.class));
    }

    private void closeFabMenu() {
        fab.setImageDrawable(getBaseContext().getResources().getDrawable(R.drawable.ic_checkin_solo));
        if (layoutRecycle.getVisibility() == View.VISIBLE) {
            layoutRecycle.setVisibility(View.GONE);
        }

        fab_text.setVisibility(View.VISIBLE);
        isFabOpen = false;
    }

    private void openFabMenu() {
        Log.e("kanish", "inopen");
        findViewById(R.id.layout).setAlpha(.1f);
        toolbar.setAlpha(.1f);
        layoutRecycle.setVisibility(View.VISIBLE);

        isFabOpen = true;
    }
    private void prepareData() {

        TitleData data = new TitleData("New Used Car Dealer", R.drawable.ic_new_dealer);
        titleList.add(data);
        data = new TitleData("Office", R.drawable.ic_office);
        titleList.add(data);
        data = new TitleData("Bank", R.drawable.ic_bank);
        titleList.add(data);
        data = new TitleData("customer", R.drawable.ic_customer);
        titleList.add(data);
        data = new TitleData("Dealer", R.drawable.ic_dealer);
        titleList.add(data);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lay_visited:
                Intent intent = new Intent(LandingDboard.this, CheckedInDealerActivity.class);
                startActivity(intent);
        }

    }

    public void launchRespectiveActivity(){
        switch (actionPosition){
            case 4:
                startActivity(new Intent(this,NearByDealerMapActivity.class));
                break;
            default:
                break;
        }

        closeFabMenu();
    }

    @Override
    public void onPermissionGranted(String grantedPermission) {

        googleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle bundle) {
                        requestToEnableGps();
                    }
                    @Override
                    public void onConnectionSuspended(int i) {
                    }
                })
                .build();

        googleApiClient.connect();
    }

    @Override
    public void onClick(View view, int position) {
        actionPosition=position;
        requestPermission(Manifest.permission.ACCESS_FINE_LOCATION);
    }


    @Override
    protected void onPause() {
        super.onPause();

        if(googleApiClient!=null && googleApiClient.isConnected())
            googleApiClient.disconnect();
    }

    //code to get gps enabled

    public void requestToEnableGps()
    {
        LocationRequest locationRequest = DealerPinActivity.getLocationRequest();

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true); //this is the key ingredient

        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(googleApiClient, builder.build());

        Log.e("Home.java", "Start resolution request");

        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();

                Log.e("Home.java", "Status:" + status.getStatus());

                final LocationSettingsStates state = result.getLocationSettingsStates();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        launchRespectiveActivity();
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        // Location settings are not satisfied. But could be fixed by showing the user
                        // a dialog.
                        try {
                            // Show the dialog by calling startResolutionForResult(),
                            // and check the result in onActivityResult().
                            status.startResolutionForResult(LandingDboard.this, REQUEST_CHECK_SETTINGS);
                        } catch (IntentSender.SendIntentException e) {
                            // Ignore the error.
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        // Location settings are not satisfied. However, we have no way to fix the
                        // settings so we won't show the dialog.
                        break;
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode, Intent data) {
        if(requestCode== REQUEST_CHECK_SETTINGS) {
            Log.e(TAG, "OnActivityResult:" + resultCode);
            switch (resultCode) {
                case Activity.RESULT_CANCELED:
                    break;
                case Activity.RESULT_OK:
                    launchRespectiveActivity();
                    break;
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        if (menuItem.isChecked()) menuItem.setChecked(false);
        else menuItem.setChecked(true);
        mDrawerLayout.closeDrawers();
        switch (menuItem.getItemId()) {
            case R.id.nav_profile:
                Toast.makeText(getApplicationContext(), "Inbox Selected", Toast.LENGTH_SHORT).show();
              /*  ContentFragment fragment = new ContentFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();*/
                mDrawerLayout.closeDrawers();
                return true;

            case R.id.nav_attendence:
                Toast.makeText(getApplicationContext(), "nav_checkin Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_pending:
                Toast.makeText(getApplicationContext(), "nav_dealer Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_report:
                Toast.makeText(getApplicationContext(), "report Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_report1:
                Toast.makeText(getApplicationContext(), "report1 Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_report2:
                Toast.makeText(getApplicationContext(), "report2 Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_report3:
                Toast.makeText(getApplicationContext(), "report3 Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_call_support:
                Toast.makeText(getApplicationContext(), "Call support Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_warranty:
                Toast.makeText(getApplicationContext(), "warranty Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_classified:
                Toast.makeText(getApplicationContext(), "classified Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_insurance:
                Toast.makeText(getApplicationContext(), "indurance Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            case R.id.nav_logout:
                Toast.makeText(getApplicationContext(), "logout Selected", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawers();
                return true;
        }
    }
}
