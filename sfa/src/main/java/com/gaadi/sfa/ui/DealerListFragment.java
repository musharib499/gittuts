package com.gaadi.sfa.ui;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gaadi.sfa.R;
import com.gaadi.sfa.adapter.DealerListAdapter;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kanishroshan on 11/2/16.
 */
public class DealerListFragment extends Fragment implements DealerItemCallback{

    public static final String EXTRA_DEALER_MODEL_LIST = "extra_dealer_model_list";
    private static final String TAG = "DealerListFragment";
    private static final int REQUEST_DEALER_PIN = 101;
    private List<DealerModel> dealerData;
    private RecyclerView recyclerView;
    private DealerListAdapter mAdapter;
    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.dealerlist_fragment,container,false);

        recyclerView=(RecyclerView)view.findViewById(R.id.dealerlist);

        dealerData = (ArrayList<DealerModel>)getArguments().getSerializable(EXTRA_DEALER_MODEL_LIST);

        Logger.e(TAG, "Dealer data is null " + (dealerData == null));

        mAdapter= new DealerListAdapter(dealerData);

        mAdapter.setDealerItemClickListener(this);

        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(context);

        recyclerView.setLayoutManager(mLayoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator() {
        });

        recyclerView.setAdapter(mAdapter);

        return view;
    }

    @Override
    public void onCall(int dealerItemPosition) {

    }

    @Override
    public void onCheckIn(int dealerItemPosition) {
        startActivity(new Intent(getContext(),CheckedInDealerActivity.class));
    }

    @Override
    public void onPinUpdate(int dealerItemPosition) {
        Intent intent=new Intent(getContext(),DealerPinActivity.class);
        intent.putExtra(DealerPinActivity.EXTRA_DEALER_MODEL,dealerData.get(dealerItemPosition));
        startActivityForResult(intent, REQUEST_DEALER_PIN);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case REQUEST_DEALER_PIN:
                if(resultCode== Activity.RESULT_OK){
                    //update model
                }
                break;
        }
    }
}
