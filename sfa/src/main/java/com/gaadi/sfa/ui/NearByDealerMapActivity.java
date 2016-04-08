package com.gaadi.sfa.ui;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.gaadi.sfa.R;
import com.gaadi.sfa.model.BaseResponseModel;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.provider.dealertable.DealertableColumns;
import com.gaadi.sfa.provider.dealertable.DealertableCursor;
import com.gaadi.sfa.provider.dealertable.DealertableSelection;
import com.gaadi.sfa.retrofit.RetrofitRequest;
import com.gaadi.sfa.utils.AppConstants;
import com.gaadi.sfa.utils.AppPrefrences;
import com.gaadi.sfa.utils.HttpConnection;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.PathJSONParser;
import com.gaadi.sfa.utils.Utils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class NearByDealerMapActivity extends FragmentActivity implements
		LocationListener, GoogleApiClient.ConnectionCallbacks,
		GoogleApiClient.OnConnectionFailedListener,AdapterView.OnItemClickListener,GoogleMap.OnMarkerClickListener{


	private ProgressDialog progressDialog;

	ArrayList<DealerModel> dealerModels =new ArrayList<>();

	int lineColors[]={android.R.color.holo_red_dark,android.R.color.holo_blue_dark,android.R.color.holo_green_dark};

	private GoogleMap googleMap;

	private HashMap<String,Marker> markers=new HashMap<>();

	final String TAG = "NearByDealerMapActivity";

	private LocationRequest mLocationRequest;
	private GoogleApiClient mGoogleApiClient;

	private FloatingActionButton btnDealerList;
	private AutoCompleteTextView dealerSearchView;

	private TextView tvTitle;
	private ImageView ivBack;

	private LinearLayout dealerInfo;
	private Marker lastClickedMarker;
	private ImageView btnCloseDealerInfo;

	//related to delaerinfo
	private TextView dealerIcon;
	private TextView dealerName;
	private ImageView dealerCallIcon;
	private TextView dealerImage;
	private TextView dealerAddress;
	private TextView lastVisitDate,lastVisitTime;
	private TextView folloUpDate,folloUpTime;
	private Button btnCheckIn;


	private FilterQueryProvider dealerFilterQueryProvider = new FilterQueryProvider() {
		@Override
		public Cursor runQuery(CharSequence constraint) {
			return getDealerNames(constraint);
		}
	};
	private LatLng homeLocation;

	private int colorIndex=0;
	private LatLng center;
	private LatLng lastCenter;

	public Cursor getDealerNames(CharSequence constraint) {
		String selection = DealertableColumns.DEALERNAME + " LIKE ? ";
		String[] selectionArgs = new String [] {
				constraint + "%",
		};
		Cursor cursor = getContentResolver()
				.query(DealertableColumns.CONTENT_URI, null, selection, selectionArgs, null);

		if (cursor != null) {
			cursor.moveToFirst();
		}

		return cursor;
	}

	public void makeDealerInfoVisible(LatLng position){
		dealerInfo.setVisibility(View.VISIBLE);
		btnDealerList.setVisibility(View.GONE);

		for(DealerModel dealerModel:dealerModels){
			if(dealerModel.equalsLocation(position)){
				updateDealerInfo(dealerModel);
				break;
			}
		}
	}

	private void updateDealerInfo(final DealerModel dealerModel) {

		Logger.e(TAG, "UpdateDealerInfo:" + dealerModel.getDealerName());

		dealerIcon.setVisibility(View.GONE);
		dealerName.setText(dealerModel.getDealerName());
		dealerAddress.setText(dealerModel.getArea());

//		if(!dealerModel.isAssigned())
//			btnCheckIn.setVisibility(View.GONE);
//		else
//			btnCheckIn.setVisibility(View.VISIBLE);

		dealerImage.setText(Utils.getStringTwoWordInCap(dealerModel.getDealerName()));

		btnCheckIn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkInCustomer(dealerModel);
			}
		});

		dealerCallIcon.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Utils.callPhone(NearByDealerMapActivity.this, dealerModel.getMobile());
			}
		});
	}

	public void hideDealerInfoVisible(){
		dealerInfo.setVisibility(View.GONE);
		btnDealerList.setVisibility(View.VISIBLE);
	}

	private void checkInCustomer(final DealerModel model){

		progressDialog=ProgressDialog.show(this,"","Please wait check-in in progress...",true,false);

		RetrofitRequest.requestCheckIn(AppPrefrences.getLoginResponseModel(this).getLoginData().getEmail(),
				AppPrefrences.getLoginResponseModel(this).getLoginData().getPassword(),
				AppConstants.CHECKIN_DEALER,
				model.getDealerId(),
				model.getLatitude(),
				model.getLongitude(),
				new Callback<BaseResponseModel>() {

					@Override
					public void success(BaseResponseModel responseModel, Response response) {
						progressDialog.dismiss();

						if (responseModel.isResultSuccess()) {
							Intent intent = new Intent(NearByDealerMapActivity.this, CheckedInDealerActivity.class);
							intent.putExtra(CheckedInDealerActivity.EXTRA_DEALER_MODEL, model);
							intent.putExtra(CheckedInDealerActivity.EXTRA_VISIT_ID, responseModel.getLoginData().getVisitId());
							startActivity(intent);
						} else
							Toast.makeText(NearByDealerMapActivity.this, responseModel.getErrors().get(0), Toast.LENGTH_SHORT).show();
					}

					@Override
					public void failure(RetrofitError error) {
						error.printStackTrace();
						Logger.e(TAG, "error: " + error.getMessage());
						progressDialog.dismiss();
						Toast.makeText(NearByDealerMapActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
					}
				});
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_dealer_map);

		SupportMapFragment fm = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);

		btnDealerList=(FloatingActionButton)findViewById(R.id.btnDealerList);
		dealerSearchView = (AutoCompleteTextView)findViewById(R.id.dealerSearch);

		dealerInfo = (LinearLayout)findViewById(R.id.layoutDealerInfo);
		btnCloseDealerInfo = (ImageView)findViewById(R.id.btnCloseDealerInfo);


		btnCheckIn = (Button)findViewById(R.id.dealerlist_checkin);
		dealerIcon = (TextView)findViewById(R.id.tv_trim_string);
		dealerImage = (TextView)findViewById(R.id.dealerImage);

		ivBack = (ImageView)findViewById(R.id.iconBack);
		tvTitle = (TextView)findViewById(R.id.tvTitle);

		dealerName = (TextView)findViewById(R.id.dealername);
		dealerCallIcon = (ImageView)findViewById(R.id.callimage);
		dealerAddress = (TextView)findViewById(R.id.dealeradress);
		lastVisitDate = (TextView)findViewById(R.id.date);
		lastVisitTime = (TextView)findViewById(R.id.time);
		folloUpDate = (TextView)findViewById(R.id.date_followup);
		folloUpTime = (TextView)findViewById(R.id.time_followup);

		ivBack.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				NearByDealerMapActivity.this.finish();
			}
		});

		btnCloseDealerInfo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				hideDealerInfoVisible();
			}
		});

		dealerSearchView.setOnItemClickListener(this);
		dealerSearchView.setThreshold(1);

		btnDealerList.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(NearByDealerMapActivity.this, DealerListActivity.class));
			}
		});

		Cursor cursor = getContentResolver()
				.query(DealertableColumns.CONTENT_URI, null, null, null, null);

		DealerSearchAdapter mAdapter=new DealerSearchAdapter(this,cursor);

		dealerSearchView.setAdapter(mAdapter);
		mAdapter.setFilterQueryProvider(dealerFilterQueryProvider);

		googleMap = fm.getMap();

		int status = GooglePlayServicesUtil
				.isGooglePlayServicesAvailable(getBaseContext());
		

		if (status != ConnectionResult.SUCCESS) {

			int requestCode = 10;
			Dialog dialog = GooglePlayServicesUtil.getErrorDialog(status, this,
					requestCode);
			dialog.show();

		} else {
			mLocationRequest = DealerPinActivity.getLocationRequest();

			mGoogleApiClient = new GoogleApiClient.Builder(this)
					.addApi(LocationServices.API).addConnectionCallbacks(this)
					.addOnConnectionFailedListener(this).build();

			mGoogleApiClient.connect();
		}
	}


	private void setupMap() {

		Logger.e(TAG, "setupMap()");

		try {

			googleMap.setMyLocationEnabled(true);
			googleMap.getUiSettings().setMyLocationButtonEnabled(true);
			PendingResult<Status> result = LocationServices.FusedLocationApi
					.requestLocationUpdates(mGoogleApiClient, mLocationRequest,
							this);

			Toast.makeText(NearByDealerMapActivity.this, R.string.waiting_for_current_location, Toast.LENGTH_LONG).show();

//			googleMap.getUiSettings().setZoomControlsEnabled(false);
//			googleMap.getUiSettings().setCompassEnabled(true);
			googleMap.getUiSettings().setRotateGesturesEnabled(true);
			googleMap.getUiSettings().setZoomGesturesEnabled(true);

			googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {

				@Override
				public void onCameraChange(CameraPosition arg0) {

					Logger.e(TAG, "setOnCameraChangeListener");

					if (homeLocation == null) return; //ignore and wait for location

					center = googleMap.getCameraPosition().target;

					Circle circle = googleMap.addCircle(new CircleOptions()
							.center(homeLocation)
							.radius(DealerPinActivity.RADIUS)
							.strokeColor(Color.RED)
							.fillColor(Color.TRANSPARENT));

					Double diff = DealerPinActivity.differenceBetweenLatLng(homeLocation, center);

					if (diff < circle.getRadius()) {
						lastCenter = center;
					} else {
//						Toast.makeText(NearByDealerMapActivity.this, R.string.map_outside_circle_alert, Toast.LENGTH_SHORT).show();

						if (lastCenter != null) {
							CameraPosition cameraPosition = new CameraPosition.Builder()
									.target(lastCenter).zoom(googleMap.getCameraPosition().zoom).build();

							googleMap.animateCamera(CameraUpdateFactory
									.newCameraPosition(cameraPosition));
						}
					}
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void moveToLocation(LatLng currentLocation){

		CameraPosition cameraPosition = new CameraPosition.Builder()
				.target(currentLocation).zoom(DealerPinActivity.getZoomLevel()).build();

		googleMap.setMyLocationEnabled(true);
		googleMap.animateCamera(CameraUpdateFactory
				.newCameraPosition(cameraPosition));
		googleMap.clear();

		updatePaths();
	}

	private LatLng getLocationToLatLng(Location location){
		LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
		return loc;
	}

	@Override
	public void onConnected(Bundle bundle) {
		setupMap();
	}

	@Override
	public void onConnectionSuspended(int i) {

	}

	@Override
	public void onLocationChanged(Location location) {
		if(homeLocation==null) {
			homeLocation = getLocationToLatLng(location);
			moveToLocation(homeLocation);
			LocationServices.FusedLocationApi
					.removeLocationUpdates(mGoogleApiClient,
							this);
		}
	}

	private void updatePaths(){

		DealertableCursor dealertableCursor = new DealertableSelection().query(getContentResolver());

		if(dealertableCursor!=null && dealertableCursor.moveToFirst())
			while(!dealertableCursor.isAfterLast()){
				dealerModels.add((DealerModel)new DealerModel()
						.setDealerId(dealertableCursor.getDealerid())
						.setAssigned(dealertableCursor.getAssigned() == 1 ? true : false)
						.setDealerName(dealertableCursor.getDealername())
						.setLoginToken(dealertableCursor.getLogintoken())
						.setMobile(dealertableCursor.getMobile())
						.setLatitude(dealertableCursor.getLatitude())
						.setLongitude(dealertableCursor.getLongitude())
						.setArea(dealertableCursor.getArea()));

				dealertableCursor.moveToNext();
			}

		tvTitle.setText("Found "+dealerModels.size()+" Dealerships near by. Are you here?");

		for(DealerModel position: dealerModels){
			Marker marker=googleMap.addMarker(new MarkerOptions()
					.position(position.getLatLng())
					.title(position.getDealerName())
					.snippet(position.isAssigned()?"Assigned":"Unassigned")
					.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_selected_icon)));

			markers.put(position.getDealerName(),marker);
		}

		googleMap.addMarker(new MarkerOptions()
				.position(homeLocation)
				.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_my_location)));

		googleMap.setOnMarkerClickListener(this);

		PathDrawTask downloadTask = new PathDrawTask();
		downloadTask.execute();
	}

	@Override
	public void onConnectionFailed(ConnectionResult connectionResult) {
	}

	//related to having way points

	private String getMapsApiDirectionsUrl(LatLng Office, LatLng home) {
		String waypoints = "waypoints=optimize:true|"
				+ Office.latitude + "," + Office.longitude
				+ "|" + "|" +  home.latitude + ","
				+ home.longitude;
		String OriDest = "origin="+Office.latitude+","+Office.longitude+"&destination="+home.latitude+","+home.longitude;

		String sensor = "sensor=false";
		String params = OriDest+"&%20"+waypoints + "&" + sensor;
		String output = "json";
		String url = "https://maps.googleapis.com/maps/api/directions/"
				+ output + "?" + params;
		return url;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		if (parent.getAdapter() != null) {
			Cursor cursor = (Cursor) parent.getAdapter().getItem(position);

			dealerSearchView.setText(cursor.getString(cursor.getColumnIndex(DealertableColumns.DEALERNAME)));
			dealerSearchView.setSelection(dealerSearchView.getText().toString().length());

			//update map from here
			for(DealerModel model:dealerModels)
				if(model.getDealerId().equals(cursor.getString(cursor.getColumnIndex(DealertableColumns.DEALERID)))) {
					updateDealerInfo(model);

					onMarkerClick(markers.get(model.getDealerName()));
				}

//			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

		}
	}

	@Override
	public boolean onMarkerClick(Marker marker) {

		marker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_unselected_icon));

		if(lastClickedMarker!=null)
			lastClickedMarker.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.ic_marker_selected_icon));

		lastClickedMarker=marker;

		makeDealerInfoVisible(marker.getPosition()); //better check on position

		return false;
	}

	private class PathDrawTask extends AsyncTask<Void, Void, ArrayList<PolylineOptions>> {
		@Override
		protected ArrayList<PolylineOptions> doInBackground(Void... params) {
			try {

				ArrayList<PolylineOptions> lines=new ArrayList<>();

				for(DealerModel location: dealerModels) {
					//pull data
					HttpConnection http = new HttpConnection();
					String data = http.readUrl(getMapsApiDirectionsUrl(homeLocation,location.getLatLng()));

					//now parse data
					JSONObject jObject = new JSONObject(data);

					PathJSONParser parser = new PathJSONParser();

					List<List<HashMap<String, String>>> routes = parser.parse(jObject);

					lines.add(getPolylineOptions(routes));

					Logger.e(TAG,"Adding line");
				}

				return lines;
			} catch (Exception e) {
				Logger.e("Background Task", e.toString());
			}
			return null;
		}

		@Override
		protected void onPostExecute(ArrayList<PolylineOptions> result) {
			super.onPostExecute(result);

			if(result!=null)
			for(PolylineOptions line:result)
				googleMap.addPolyline(line);
		}
	}

	private PolylineOptions getPolylineOptions(List<List<HashMap<String, String>>> routes) {

		ArrayList<LatLng> points = null;
		PolylineOptions polyLineOptions = null;

		// traversing through routes
		for (int i = 0; i < routes.size(); i++) {
			points = new ArrayList<LatLng>();
			polyLineOptions = new PolylineOptions();
			List<HashMap<String, String>> path = routes.get(i);

			for (int j = 0; j < path.size(); j++) {
				HashMap<String, String> point = path.get(j);

				double lat = Double.parseDouble(point.get("lat"));
				double lng = Double.parseDouble(point.get("lng"));
				LatLng position = new LatLng(lat, lng);

				points.add(position);
			}

			polyLineOptions.addAll(points);
			polyLineOptions.width(10);
			polyLineOptions.color(getResources().getColor(lineColors[colorIndex++%lineColors.length]));
		}

		return polyLineOptions;
	}

	///adapter for dealers
	public class DealerSearchAdapter extends CursorAdapter {

		private Context mContext;
		private LayoutInflater mInflater;
		private Cursor mCursor;
		private TextViewHolder mHolder;

		public DealerSearchAdapter(Context context, Cursor cursor) {
			super(context, cursor, false);
			mContext = context;
			mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mCursor = cursor;
		}

		@Override
		public View newView(Context context, Cursor cursor, ViewGroup parent) {
			View view = mInflater.inflate(R.layout.autocomplete_list_item, parent, false);
			mHolder = new TextViewHolder();
			mHolder.textView = (TextView) view.findViewById(R.id.textView);
			view.setTag(mHolder);
			return view;
		}

		@Override
		public void bindView(View view, Context context, Cursor cursor) {
			mHolder = (TextViewHolder) view.getTag();

			String name = cursor.getString(cursor.getColumnIndex(DealertableColumns.DEALERNAME));

			mHolder.textView.setText(name);
		}

		public class TextViewHolder {
			public TextView textView;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public int getCount() {
			return super.getCount();
		}
	}

}
