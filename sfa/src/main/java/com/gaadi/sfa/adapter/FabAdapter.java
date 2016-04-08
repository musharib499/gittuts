package com.gaadi.sfa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaadi.sfa.R;
import com.gaadi.sfa.ui.SfaItemClickListener;
import com.gaadi.sfa.ui.TitleData;

import java.util.List;

/**
 * Created by kanishroshan on 10/2/16.
 */
public class FabAdapter extends RecyclerView.Adapter<FabAdapter.ViewHolder> {

    public Context context;
    private List<TitleData>titlelist;
    private int lastPosition = -1;
    private SfaItemClickListener onItemClickListener;

    public FabAdapter(List<TitleData> titlelist) {
        this.titlelist = titlelist;
    }

    public void setOnItemClickListener(SfaItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);

        final ViewHolder viewHolder = new ViewHolder(itemview);

        viewHolder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (onItemClickListener != null)
                            onItemClickListener.onClick(v, viewHolder.getAdapterPosition());
                    }
                }
        );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        TitleData titleData=titlelist.get(position);
        holder.title_item.setText(titleData.getTitle());
        holder.fabicon.setImageResource(titleData.getIconid());

//        setAnimation(holder.itemView, position);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    /**
     method to apply the animation
     */
    /*private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.slide);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }*/



    @Override
    public int getItemCount() {
        return titlelist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title_item;
        public ImageView fabicon;

        public ViewHolder(View itemView) {
            super(itemView);
            title_item = (TextView) itemView.findViewById(R.id.title_text);
            fabicon = (ImageView) itemView.findViewById(R.id.fab_item);
        }
    }



}
