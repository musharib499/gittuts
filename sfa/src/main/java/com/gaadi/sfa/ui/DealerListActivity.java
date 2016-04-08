package com.gaadi.sfa.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.gaadi.sfa.R;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.model.FollowUpModel;
import com.gaadi.sfa.model.PreviousVisitModel;
import com.gaadi.sfa.provider.dealertable.DealertableCursor;
import com.gaadi.sfa.provider.dealertable.DealertableSelection;
import com.gaadi.sfa.provider.followuptable.FollowuptableCursor;
import com.gaadi.sfa.provider.followuptable.FollowuptableSelection;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableCursor;
import com.gaadi.sfa.provider.previousvisittable.PreviousvisittableSelection;
import com.gaadi.sfa.utils.Logger;

import java.util.ArrayList;

/**
 * Created by kanishroshan on 11/2/16.
 */
public class DealerListActivity extends BaseActivity{
    private final String TAG = "DealerListActivity.java";
    private TabLayout tabLayout;
    private ViewPager  viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.dealer_list_activity_layout, frameLayout);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        tabLayout.setVisibility(View.VISIBLE);
        viewPager.setVisibility(View.VISIBLE);
        setupViewPager();
        tabLayout.setupWithViewPager(viewPager);

    }

    public void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
       viewPager.setAdapter(adapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private String titles[]={"Near by","Assigned","Unassigned"};
        private ArrayList<FollowUpModel> followUps;

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {

            DealerListFragment fragment = new DealerListFragment();
            Bundle bundle=new Bundle();

            ArrayList<DealerModel> dealerModels=null;


            DealertableSelection dealertableSelection=new DealertableSelection();

            switch (position){
                case 0:
                    dealerModels = getDealers(dealertableSelection);
                    break;
                case 1:
                    dealertableSelection.assigned(1);
                    dealerModels = getDealers(dealertableSelection);
                    break;
                case 2:
                    dealertableSelection.assigned(0);
                    dealerModels = getDealers(dealertableSelection);
                    break;
            }


            bundle.putSerializable(DealerListFragment.EXTRA_DEALER_MODEL_LIST,dealerModels);
            fragment.setArguments(bundle);

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }

        private ArrayList<DealerModel> getDealers(DealertableSelection dealertableSelection){
            DealertableCursor cursor=dealertableSelection.query(getContentResolver());

            ArrayList<DealerModel> dealerModels=new ArrayList<>();
            DealerModel dealerModel;

            if(cursor!=null && cursor.moveToFirst())
                while(!cursor.isAfterLast()){
                    dealerModel = new DealerModel();
                    dealerModel.setDealerName(cursor.getDealername());
                    dealerModel.setDealerId(cursor.getDealerid());
                    dealerModel.setAssigned(cursor.getAssigned() == 1 ? true : false);
                    dealerModel.setMobile(cursor.getMobile());
                    dealerModel.setArea("");

                    dealerModel.setFollowUpModel(getFollowUps(cursor.getDealerid()));
                    dealerModel.setLastVisitModel(getPreviousVisits(cursor.getDealerid()));

                    dealerModels.add(dealerModel);

                    Logger.e(TAG, "Adding dealer in list");

                    cursor.moveToNext();
                }

            if(cursor!=null)cursor.close();

            return  dealerModels;
        }

        public ArrayList<FollowUpModel> getFollowUps(String dealerid) {
            ArrayList<FollowUpModel> followUps=new ArrayList<>();
            FollowUpModel model;

            FollowuptableSelection selection=new FollowuptableSelection();
            selection.dealerid(dealerid);

            FollowuptableCursor cursor=selection.query(getContentResolver());

            if(cursor!=null && cursor.moveToFirst())
                while(!cursor.isAfterLast()){
                    model=new FollowUpModel();

                    model.setComments(cursor.getComments());
                    model.setOverdue(cursor.getOverdue() == 1 ? true : false);
                    model.setDate(cursor.getDate());

                    cursor.moveToNext();

                    followUps.add(model);
                }

            if(cursor!=null)cursor.close();

            return followUps;
        }

        public ArrayList<PreviousVisitModel> getPreviousVisits(String dealerid) {
            ArrayList<PreviousVisitModel> previousVisits=new ArrayList<>();
            PreviousVisitModel model;

            PreviousvisittableSelection selection=new PreviousvisittableSelection();
            selection.dealerid(dealerid);

            PreviousvisittableCursor cursor=selection.query(getContentResolver());

            if(cursor!=null && cursor.moveToFirst())
                while(!cursor.isAfterLast()){
                    model=new PreviousVisitModel();

                    model.setComments(cursor.getComments());
                    model.setDate(cursor.getDate());
                    model.setCheckin(cursor.getCheckin());
                    model.setCheckout(cursor.getCheckout());

                    cursor.moveToNext();

                    previousVisits.add(model);
                }

            if(cursor!=null)cursor.close();

            return previousVisits;
        }
    }
}
