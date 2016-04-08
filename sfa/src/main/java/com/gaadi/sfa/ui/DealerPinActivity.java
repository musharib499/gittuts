package com.gaadi.sfa.ui;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gaadi.sfa.R;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.utils.Logger;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.SphericalUtil;

public class DealerPinActivity extends AppCompatActivity implements
        LocationListener, GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    public static final int MILLISECONDS_PER_SECOND = 700;
    public static final int UPDATE_INTERVAL_IN_SECONDS = 1;
    public static final int FAST_CEILING_IN_SECONDS = 1;

    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = MILLISECONDS_PER_SECOND
            * UPDATE_INTERVAL_IN_SECONDS;

    public static final long FAST_INTERVAL_CEILING_IN_MILLISECONDS = MILLISECONDS_PER_SECOND
            * FAST_CEILING_IN_SECONDS;

    private static final String TAG = "DealerPinActivity.java";
    public static final String EXTRA_DEALER_MODEL = "extra_dealer_model";

    private LocationRequest mLocationRequest;

    private GoogleMap mGoogleMap;

    private GoogleApiClient mGoogleApiClient;

    boolean mUpdatesRequested = false;

    private TextView tvDealerName;
    private LatLng center,lastCenter;
    private Location myLocation;
    private LinearLayout markerLayout;
    private TextView tvDealerAddress;
    private Button setLocation;

    public static final int RADIUS=1000;

//    LatLngBounds circularBounds;

    private DealerModel dealerModel;

    public static LocationRequest getLocationRequest() {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setFastestInterval(FAST_INTERVAL_CEILING_IN_MILLISECONDS);

        return mLocationRequest;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dealer_pin);

        tvDealerName = (TextView) findViewById(R.id.dealerName);
        tvDealerAddress = (TextView) findViewById(R.id.dealerAddress);

        setLocation = (Button) findViewById(R.id.btnSetLocation);

        setLocation.setEnabled(false);

        setLocation.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  result=new Intent();

                dealerModel.setLatitude(String.valueOf(center.latitude));
                dealerModel.setLongitude(String.valueOf(center.longitude));

                result.putExtra(EXTRA_DEALER_MODEL, dealerModel);

                setResult(RESULT_OK, result);

                DealerPinActivity.this.finish();
            }
        });

        markerLayout = (LinearLayout) findViewById(R.id.locationMarker);

        int status = GooglePlayServicesUtil
                .isGooglePlayServicesAvailable(getBaseContext());

        dealerModel = (DealerModel)getIntent().getSerializableExtra(EXTRA_DEALER_MODEL);

        if(dealerModel!=null){
            //get current location
//            double lat=Double.parseDouble(dealerModel.getLatitude());
//            double lon=Double.parseDouble(dealerModel.getLongitude());
//
//            currentLocation = new LatLng(lat,lon);

            tvDealerName.setText(dealerModel.getDealerName());
            tvDealerAddress.setText(dealerModel.getArea());
        }

        if (status != ConnectionResult.SUCCESS) {

            int requestCode = 10;
            Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
                    requestCode);
            dialog.show();

        } else {
            mLocationRequest = getLocationRequest();

            mUpdatesRequested = false;

            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API).addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this).build();

            mGoogleApiClient.connect();
        }
    }

    public static float getZoomLevel() {
        float zoomLevel=14f;

        double radius = RADIUS;
        double scale = radius / 500;
        zoomLevel =(int) (16 - Math.log(scale) / Math.log(2));

        return zoomLevel;
    }

    private void setupMap() {

        Logger.e(TAG, "setupMap()");

        try {

            mGoogleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(
                    R.id.map)).getMap();

            mGoogleMap.setMyLocationEnabled(true);
            mGoogleMap.getUiSettings().setMyLocationButtonEnabled(true);
            PendingResult<Status> result = LocationServices.FusedLocationApi
                    .requestLocationUpdates(mGoogleApiClient, mLocationRequest,
                            this);

            Toast.makeText(DealerPinActivity.this,R.string.waiting_for_current_location,Toast.LENGTH_LONG).show();

//            mGoogleMap.getUiSettings().setZoomControlsEnabled(false);
//            mGoogleMap.getUiSettings().setCompassEnabled(true);
            mGoogleMap.getUiSettings().setRotateGesturesEnabled(true);
            mGoogleMap.getUiSettings().setZoomGesturesEnabled(true);


            mGoogleMap.setOnCameraChangeListener(new OnCameraChangeListener() {

                @Override
                public void onCameraChange(CameraPosition arg0) {

                    Logger.e(TAG,"setOnCameraChangeListener");

                    if(myLocation==null)return; //ignore and wait for location

                    center = mGoogleMap.getCameraPosition().target;

                    mGoogleMap.clear();
                    markerLayout.setVisibility(View.VISIBLE);

                    Circle circle = mGoogleMap.addCircle(new CircleOptions()
                            .center(getLocationToLatLng(myLocation))
                            .radius(RADIUS)
                            .strokeColor(Color.RED)
                            .fillColor(Color.TRANSPARENT));

                    Double diff = differenceBetweenLatLng(getLocationToLatLng(myLocation), center);

                    if(diff < circle.getRadius()){
                        lastCenter =center;
                        setLocation.setEnabled(true);
                    }else{
                        Toast.makeText(DealerPinActivity.this,R.string.map_outside_circle_alert,Toast.LENGTH_SHORT).show();
                        setLocation.setEnabled(false);

                        if(lastCenter!=null) {
                            CameraPosition cameraPosition = new CameraPosition.Builder()
                                    .target(lastCenter).zoom(mGoogleMap.getCameraPosition().zoom).build();

                            mGoogleMap.animateCamera(CameraUpdateFactory
                                    .newCameraPosition(cameraPosition));
                        }
                    }
                }
            });

//            markerLayout.setOnClickListener(new OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//
//                    Logger.e(TAG,"markerLayout.setOnClickListener");
//
//                    try {
//
//                        LatLng latLng1 = new LatLng(center.latitude,
//                                center.longitude);
//
//                        Marker m = mGoogleMap.addMarker(new MarkerOptions()
//                                .position(latLng1)
////                                .title(" Set your Location ")
////                                .snippet("")
//                                .icon(BitmapDescriptorFactory
//                                        .fromResource(R.drawable.marker)));
//                        m.setDraggable(true);
//
//                        markerLayout.setVisibility(View.GONE);
//                    } catch (Exception e) {
//                    }
//
//                }
//            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveToLocation(LatLng currentLocation){

//        circularBounds = convertCenterAndRadiusToBounds(currentLocation,RADIUS);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(currentLocation).zoom(getZoomLevel()).build();

        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));
        // Clears all the existing markers
        mGoogleMap.clear();
    }

    @Override
    public void onLocationChanged(Location location) {

        if(myLocation==null) {
            myLocation = location;

            lastCenter = getLocationToLatLng(location);

            moveToLocation(lastCenter);

            LocationServices.FusedLocationApi
                    .removeLocationUpdates(mGoogleApiClient,
                            this);
        }
    }

    private LatLng getLocationToLatLng(Location location){
        LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
        return loc;
    }

    @Override
    public void onConnectionFailed(ConnectionResult arg0) {
    }

    @Override
    public void onConnected(Bundle arg0) {
        setupMap();

    }

    public LatLngBounds convertCenterAndRadiusToBounds(LatLng center, double radius) {
        LatLng southwest = SphericalUtil.computeOffset(center, radius * Math.sqrt(2.0), 225);
        LatLng northeast = SphericalUtil.computeOffset(center, radius * Math.sqrt(2.0), 45);
        return new LatLngBounds(southwest, northeast);
    }

    public static Double differenceBetweenLatLng(LatLng center,LatLng boundary){
        Double diff = SphericalUtil.computeDistanceBetween(center,boundary);
        return diff;
    }

    @Override
    public void onConnectionSuspended(int arg0) {
    }

}