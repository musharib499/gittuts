package com.gaadi.sfa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaadi.sfa.R;

import java.util.ArrayList;

/**
 * Created by musharebali on 11/2/16.
 */
public class DealerVisitedAdapter extends RecyclerView.Adapter<DealerVisitedAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;
    private Context context;
    private ArrayList<String> itemList;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();


    public DealerVisitedAdapter(Context mcontext, ArrayList<String> stringArrayList) {
        this.itemList = stringArrayList;
        this.context = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View view = mInflater.inflate(R.layout.dealer_visiter_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_visited.setText(itemList.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tv_visited;

        public ViewHolder(View view) {
            super(view);
            tv_visited = (TextView) view.findViewById(R.id.tv_visited);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
                if (selectedItems.get(getAdapterPosition(), false)) {
                    selectedItems.delete(getAdapterPosition());
                    tv_visited.setSelected(false);
                    tv_visited.setBackgroundResource(R.drawable.text_circular_view_unselect);
                } else {
                    selectedItems.put(getAdapterPosition(), true);
                    tv_visited.setSelected(true);
                    tv_visited.setBackgroundResource(R.drawable.text_circular_view_select);
                }

            }
        }

    }


}
