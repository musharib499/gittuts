package com.gaadi.sfa.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.gaadi.sfa.R;
import com.gaadi.sfa.materialedittext.MaterialEditText;
import com.gaadi.sfa.ui.CheckedInDealerActivity;

import java.util.ArrayList;

/**
 * Created by musharebali on 18/2/16.
 */
public class DealerAddItemAdapter extends RecyclerView.Adapter<DealerAddItemAdapter.ViewHolder> {
    OnItemClickListener mItemClickListener;
    private Context context;
    private ArrayList<String> itemList;
    private SparseBooleanArray selectedItems = new SparseBooleanArray();


    public DealerAddItemAdapter(Context mcontext, ArrayList<String> stringArrayList) {
        this.itemList = stringArrayList;
        this.context = mcontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater mInflater = LayoutInflater.from(parent.getContext());
        final View view = mInflater.inflate(R.layout.dealer_purpose_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // holder.tv_visited.setText(itemList.get(position).toString());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void addItem(String data) {
        itemList.add(data);

        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        MaterialEditText mtv_name;
        EditText et_role;


        public ViewHolder(View view) {
            super(view);
            mtv_name = (MaterialEditText) view.findViewById(R.id.mtv_name);
            et_role = (EditText) view.findViewById(R.id.et_role);
            mtv_name.setOnClickListener(this);
            et_role.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            CheckedInDealerActivity checkedInDealerActivity = new CheckedInDealerActivity();

            switch (v.getId()) {

                case R.id.mtv_name:


                    break;
                case R.id.et_role:
                    Toast.makeText(context, "Check on Role", Toast.LENGTH_SHORT).show();
                    /*checkedInDealerActivity.ListPopupWindowList();
                    checkedInDealerActivity.listPopupWindow.show();*/

                    break;

            }
           /* if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getLayoutPosition());
                if (selectedItems.get(getAdapterPosition(), false)) {
                    selectedItems.delete(getAdapterPosition());
                    mtv_name.setSelected(false);
                    mtv_name.setBackgroundResource(R.drawable.text_circular_view_unselect);
                } else {
                    selectedItems.put(getAdapterPosition(), true);
                    tv_visited.setSelected(true);
                    tv_visited.setBackgroundResource(R.drawable.text_circular_view_select);
                }

            }*/
        }

    }

}
