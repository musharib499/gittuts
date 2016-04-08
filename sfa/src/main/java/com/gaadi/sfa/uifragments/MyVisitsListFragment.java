package com.gaadi.sfa.uifragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.swipe.SwipeLayout;
import com.gaadi.sfa.R;
import com.gaadi.sfa.adapter.MyVisitsListAdapter;
import com.gaadi.sfa.model.DealerModel;

import java.util.ArrayList;

/**
 * Created by kanishroshan on 17/2/16.
 */
public class MyVisitsListFragment extends Fragment {

    MyVisitsListAdapter myVisitsListAdapter;
    SwipeLayout swipeLayout;
    private RecyclerView recyclerView;
    private ArrayList<DealerModel> dealerList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myvists, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.myvisitsfragment_recycler);
        dealerList = new ArrayList<>();
        dealerList.add(new DealerModel());
        swipeLayout = (SwipeLayout) view.findViewById(R.id.swipelayout);
        myVisitsListAdapter = new MyVisitsListAdapter(dealerList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(myVisitsListAdapter);
        return view;
    }
}
