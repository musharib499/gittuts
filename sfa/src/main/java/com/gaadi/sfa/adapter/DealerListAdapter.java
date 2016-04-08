package com.gaadi.sfa.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaadi.sfa.R;
import com.gaadi.sfa.model.DealerModel;
import com.gaadi.sfa.ui.DealerItemCallback;
import com.gaadi.sfa.utils.DateTimeUtils;
import com.gaadi.sfa.utils.Logger;
import com.gaadi.sfa.utils.Utils;

import java.util.List;

/**
 * Created by kanishroshan on 11/2/16.
 */
public class DealerListAdapter extends RecyclerView.Adapter<DealerListAdapter.ViewHolder> {
    private static final String TAG = "DealerListAdapter";
    private List<DealerModel> dealerModels;
    private DealerItemCallback dealerItemClickListener;

    public DealerListAdapter(List<DealerModel> dealers) {
        this.dealerModels = dealers;
    }

    public void setDealerItemClickListener(DealerItemCallback dealerItemClickListener) {
        this.dealerItemClickListener = dealerItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dealerlist_item, parent, false);

        final ViewHolder viewHolder = new ViewHolder(itemView);

        viewHolder.checkin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dealerItemClickListener != null)
                            dealerItemClickListener.onCheckIn(viewHolder.getAdapterPosition());
                    }
                }
        );

        viewHolder.call_icon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (dealerItemClickListener != null)
                            dealerItemClickListener.onPinUpdate(viewHolder.getAdapterPosition());
                    }
                }
        );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Logger.e(TAG, "Get dealer item " + position);

        DealerModel dealerModel = dealerModels.get(position);

        holder.dealer_name.setText(dealerModel.getDealerName());
        holder.tv_trim_string.setText(Utils.getStringTwoWordInCap(dealerModel.getDealerName()));
        holder.dealer_add.setText(dealerModel.getArea());
        holder.last_visit.setText(dealerModel.getLastVisitModel().get(0).getComments());
        holder.lv_date.setText(DateTimeUtils.getFormattedDate(dealerModel.getLastVisitModel().get(0).getDate()));
        holder.lv_time.setText(DateTimeUtils.getFormattedTime(dealerModel.getLastVisitModel().get(0).getDate()));
        holder.follow_up.setText(dealerModel.getFollowUpModel().get(0).getComments());
        holder.fu_date.setText(DateTimeUtils.getFormattedDate(dealerModel.getFollowUpModel().get(0).getDate()));
        holder.fu_time.setText(DateTimeUtils.getFormattedTime(dealerModel.getFollowUpModel().get(0).getDate()));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return dealerModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView dealer_name, dealer_add, last_visit, lv_date, lv_time, follow_up, fu_date, fu_time, tv_trim_string;
        ImageView dealer_logo, call_icon;
        Button checkin;

        public ViewHolder(View itemView) {

            super(itemView);

            dealer_name = (TextView) itemView.findViewById(R.id.dealername);
            dealer_add = (TextView) itemView.findViewById(R.id.dealeradress);
            last_visit = (TextView) itemView.findViewById(R.id.lastvist);
            lv_date = (TextView) itemView.findViewById(R.id.date);
            lv_time = (TextView) itemView.findViewById(R.id.time);
            follow_up = (TextView) itemView.findViewById(R.id.follow_up);
            fu_date = (TextView) itemView.findViewById(R.id.date_followup);
            fu_time = (TextView) itemView.findViewById(R.id.time_followup);
            tv_trim_string = (TextView) itemView.findViewById(R.id.tv_trim_string);
            call_icon = (ImageView) itemView.findViewById(R.id.callimage);
            checkin = (Button) itemView.findViewById(R.id.dealerlist_checkin);

        }
    }

    }

