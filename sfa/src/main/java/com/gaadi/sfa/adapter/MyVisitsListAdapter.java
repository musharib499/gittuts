package com.gaadi.sfa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daimajia.swipe.adapters.RecyclerSwipeAdapter;
import com.gaadi.sfa.R;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.ui.DealerItemCallback;

import java.util.List;

/**
 * Created by kanishroshan on 11/2/16.
 */
public class MyVisitsListAdapter extends RecyclerSwipeAdapter<MyVisitsListAdapter.ViewHolder> {

    List<DealerModel> dealerModelsl;

    public MyVisitsListAdapter(List<DealerModel> dealers) {
        dealerModelsl = dealers;
    }

    public void setDealerItemClickListener(DealerItemCallback dealerItemClickListener) {

    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipelayout;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.myvisitsrecycler, parent, false);

        final ViewHolder viewHolder = new ViewHolder(itemView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {



        /*DealerModel dealerModel= dealerModels.get(position);

        holder.dealer_name.setText(dealerModel.getDealerName());
        holder.dealer_add.setText(dealerModel.getArea());
        holder.last_visit.setText(dealerModel.getLastVisitModel().get(0).getComments());
        holder.lv_date.setText(DateTimeUtils.getFormattedDate(dealerModel.getLastVisitModel().get(0).getDate()));
        holder.lv_time.setText(DateTimeUtils.getFormattedTime(dealerModel.getLastVisitModel().get(0).getDate()));
        holder.follow_up.setText(dealerModel.getFollowUpModel().get(0).getComments());
        holder.fu_date.setText(DateTimeUtils.getFormattedDate(dealerModel.getFollowUpModel().get(0).getDate()));
        holder.fu_time.setText(DateTimeUtils.getFormattedTime(dealerModel.getFollowUpModel().get(0).getDate()));*/
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView dealer_name, dealer_add, checkin_time, checkout_time, work_left;
        LinearLayout swipe_iconlayout;
        ImageView dealer_logo;


        public ViewHolder(View itemView) {

            super(itemView);

            dealer_name = (TextView) itemView.findViewById(R.id.dealername);
            dealer_add = (TextView) itemView.findViewById(R.id.dealeradress);
            checkin_time = (TextView) itemView.findViewById(R.id.checkin_time);
            checkout_time = (TextView) itemView.findViewById(R.id.checkout_time);
            work_left = (TextView) itemView.findViewById(R.id.work_left);
            dealer_logo = (ImageView) itemView.findViewById(R.id.dealer_image);
            swipe_iconlayout = (LinearLayout) itemView.findViewById(R.id.swipe_icon_layout);

        }
    }

}

