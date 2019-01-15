package com.wata.recyclerviewdemo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.wata.recyclerviewdemo.DataBean;
import com.wata.recyclerviewdemo.R;

import java.util.List;

/**
 * Created by admin on 2016/3/17.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private Context mContext;
    private List<DataBean> mBeans;

    public ListAdapter(Context context, List<DataBean> beans) {
        this.mContext = context;
        this.mBeans = beans;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListViewHolder(View.inflate(mContext, R.layout.item_list, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        holder.setData(mBeans.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeans == null ? 0 : mBeans.size();
    }

    @Override
    public void setHasStableIds(boolean hasStableIds) {
        super.setHasStableIds(hasStableIds);
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvName;

        private ListViewHolder(View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_photo);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void setData(DataBean bean) {
            ivIcon.setImageResource(bean.icon);
            tvName.setText(bean.name);
        }
    }
}
