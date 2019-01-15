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
public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context mContext;
    private List<DataBean> mBeans;

    public GridAdapter(Context context, List<DataBean> beans) {
        this.mContext = context;
        this.mBeans = beans;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //当viewholder创建时的回调
        return new GridViewHolder(View.inflate(mContext, R.layout.item_grid, null));
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        //当viewholder和数据绑定时的回调
        holder.setData(mBeans.get(position));
    }

    @Override
    public int getItemCount() {
        return mBeans == null ? 0 : mBeans.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivIcon;
        private TextView tvName;

        private GridViewHolder(View itemView) {
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
