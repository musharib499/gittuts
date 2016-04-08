package com.gaadi.sfa.ui;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gaadi.sfa.R;
import com.gaadi.sfa.uifragments.MyVisitsListFragment;

public class MyVisitsListActivity extends BaseActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_my_visits_list, frameLayout);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyVisitsListFragment(), "Incomplete");
        adapter.addFragment(new MyVisitsListFragment(), "Done");
        adapter.addFragment(new MyVisitsListFragment(), "Follow Ups");
        adapter.addFragment(new MyVisitsListFragment(), "Overdue");
        viewPager.setAdapter(adapter);
    }
}

