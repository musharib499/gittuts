package com.gaadi.sfa.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gaadi.sfa.R;


/**
 * Created by kanishroshan on 3/2/16.
 */
public class BaseActivity extends SfaBaseActivity {
    protected FrameLayout frameLayout;
    protected Toolbar toolbar;
    protected TabLayout tabLayout;
    protected LinearLayout lay_sub_tital, lay_coll_sub_title;
    protected TextView sub_tital, coll_title, coll_sub_title;
    protected ImageView make_logo;
    protected TextView fab_text;

    protected FloatingActionButton fab;
    protected ViewPager viewPager;
    LinearLayout parentLayout;
    String[] modelsList = {"HTC Desire 526GPLUS dual sim"};

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public static boolean hasSoftKeys(WindowManager windowManager) {
        Display d = windowManager.getDefaultDisplay();

        DisplayMetrics realDisplayMetrics = new DisplayMetrics();
        d.getRealMetrics(realDisplayMetrics);

        int realHeight = realDisplayMetrics.heightPixels;
        int realWidth = realDisplayMetrics.widthPixels;

        DisplayMetrics displayMetrics = new DisplayMetrics();
        d.getMetrics(displayMetrics);

        int displayHeight = displayMetrics.heightPixels;
        int displayWidth = displayMetrics.widthPixels;

        return (realWidth - displayWidth) > 0 || (realHeight - displayHeight) > 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // requestWindowFeature(Window.FEATURE_ACTION_BAR_OVERLAY);
        setContentView(R.layout.base_activity);
        frameLayout = (FrameLayout) findViewById(R.id.content_frame);
        parentLayout = (LinearLayout) findViewById(R.id.parent_layout);
        //  setFabButton();
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab_text = (TextView) findViewById(R.id.fab_text);
        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    public void setFabButton() {
        CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        p.setAnchorId(View.NO_ID);
        fab.setLayoutParams(p);
        fab.setVisibility(View.GONE);
    }

    /*  protected void setFabCounter(int count) {
          if (count > 0) {
              if (fab_counter.getVisibility() == View.GONE) {
                  fab_counter.setVisibility(View.VISIBLE);
              }
          } else {
              if (fab_counter.getVisibility() == View.VISIBLE) {
                  fab_counter.setVisibility(View.GONE);
              }
          }
          fab_counter.setText(String.valueOf(count));
      }
  */
    protected void setTitleMsg(String msg) {
        toolbar.setTitle(msg);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    protected void setSubTittle(String tittle, String subtittle) {
        lay_coll_sub_title.setVisibility(View.VISIBLE);
        coll_title.setText(tittle);
        coll_sub_title.setText(subtittle);
        //collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

       /* if (!ApplicationController.checkInternetConnectivity()) {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.parent_layout),
                    "No Connection",
                    Snackbar.LENGTH_LONG)
                    .setAction("Switch ON", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS));
                        }
                    })
                    .setActionTextColor(getResources().getColor(R.color.switch_on_internet_button));
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.black_semi_transparent));
            snackbar.show();
        }*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }
  /*  public void onTooggle(View v)
    {
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_FULLSCREEN |View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION);
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}