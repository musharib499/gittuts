package com.gaadi.sfa.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaadi.sfa.R;
import com.gaadi.sfa.utils.Utils;

/**
 * Created by vinodtakhar on 15/11/15.
 */
public class NavigationActivity extends AppCompatActivity implements DrawerLayout.DrawerListener {

    private static final int PERMISSIONS_REQUEST_CODE = 100;
    public FrameLayout frameLayout;
    public ImageView ivLogo, ivNavigation;
    private Toolbar toolbar;
    private TextView tvTitle;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    private String screenName = "";

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_bar);
        frameLayout = (FrameLayout) findViewById(R.id.container);
        tvTitle = (TextView) findViewById(R.id.tvTitleText);
        ivNavigation = (ImageView) findViewById(R.id.ivNavigation);
        ivLogo = (ImageView) findViewById(R.id.ivLogo);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        toolbar.setContentInsetsAbsolute(0, 0);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(false);

        View.OnClickListener onClickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawers();
                else
                    drawerLayout.openDrawer(GravityCompat.START);
            }
        };

        ivNavigation.setOnClickListener(onClickListener);
        ivLogo.setOnClickListener(onClickListener);

        //to change width
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        int width = getResources().getDisplayMetrics().widthPixels / 2;
        DrawerLayout.LayoutParams params = (DrawerLayout.LayoutParams) navigationView.getLayoutParams();
        params.width = width + width / 4;
        navigationView.setLayoutParams(params);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                return onNavMenuItemClicked(menuItem);
            }
        });

        disableNavigationViewScrollbars();

        updateIfOpenedWithNotification();

        drawerLayout.setDrawerListener(this);

    }

    public void hideToolbarAndNavigation(){
        navigationView.setVisibility(View.GONE);
        toolbar.setVisibility(View.GONE);
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
    public void hideToolbar(){
        toolbar.setVisibility(View.GONE);
    }

    private void disableNavigationViewScrollbars() {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    protected void disableMenuClick(int menuItemId) {
        navigationView.getMenu().findItem(menuItemId).setEnabled(false);
    }


    private void updateIfOpenedWithNotification() {

        if(getIntent()!=null) {

//            if (getIntent().hasExtra(AppConstants.N_SEEN)) {
//                NotificationtableSelection selection = new NotificationtableSelection();
//                selection.id(getIntent().getLongExtra(AppConstants.N_SEEN,0));
//
//                NotificationtableContentValues values = new NotificationtableContentValues();
//                values.putNotificationStatus(NotificationModel.NOTIFICATION_STATUS_READ);
//
//                getContentResolver().update(NotificationtableColumns.CONTENT_URI, values.values(), selection.sel(), selection.args());
//             }
//
//            if(getIntent().hasExtra(AppConstants.EXTRA_NOTIFICATION_INTENT)) {
//
//                Logger.e("Track app open with Push");
//                ParseAnalytics.trackAppOpenedInBackground((Intent) getIntent().getParcelableExtra(AppConstants.EXTRA_NOTIFICATION_INTENT));
//            }
//
//            //clear all notifications if app is opened by notification click (if any notification in status bar, one is default cleared but in case there are multiple)
//            NotificationManager notificationManager =
//                    (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
//            notificationManager.cancelAll();

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                Utils.animateActivity(this, "back");
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    public void setMenuItemVisibility(int menuId,int viewState){
        navigationView.getMenu().findItem(menuId).setVisible(viewState == View.VISIBLE ? true : false);
    }

    public boolean onNavMenuItemClicked(MenuItem menuItem) {
        Intent intent = null;

//        Answers.getInstance().logContentView(new ContentViewEvent()
//                .putContentName(screenName));

//        Toast.makeText(this,menuItem.getTitle()+"clicked",Toast.LENGTH_SHORT).show();

        menuItem.setChecked(false); //to prevent selection as it moves to another activity


        switch (menuItem.getItemId()) {

            case R.id.nav_profile:

                intent = new Intent(NavigationActivity.this, HomePageActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                break;


            default:
                return false;
        }

        drawerLayout.closeDrawers();

        if (intent != null) {
            startActivity(intent);
            Utils.animateActivity(this, "next");
            if (!(this instanceof HomePageActivity)) {
                finish();
            }
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }

    public void setTopTitle(String title) {
        tvTitle.setText(title);
    }

    protected void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    protected void sendEvent(String category, String action, String label) {
//        AnalyticsDataDispatcher.sendEvent(screenName, category, action, label);
    }

    protected void closeDrawer() {
            drawerLayout.closeDrawers();
    }

    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {}

    @Override
    public void onDrawerOpened(View drawerView) {
        InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public void onDrawerClosed(View drawerView) {}

    @Override
    public void onDrawerStateChanged(int newState) {}
}
