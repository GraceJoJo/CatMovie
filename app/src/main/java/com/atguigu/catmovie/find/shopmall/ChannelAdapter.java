package com.atguigu.catmovie.find.shopmall;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/7.
 */
public class ChannelAdapter extends BaseAdapter {
    private final Context mContext;
    private final int[] shoop_tupian;//图片
    private final String[] shoop_type;

    public ChannelAdapter(Context mContext, String[] shoop_type, int[] shoop_tupian) {
        this.mContext = mContext;
        this.shoop_type = shoop_type;
        this.shoop_tupian = shoop_tupian;
    }

    @Override
    public int getCount() {
        return shoop_type.length;
    }

    @Override
    public Object getItem(int position) {
        return shoop_type[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_grid, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvChannel.setText(shoop_type[position]);
        holder.ivChannel.setBackgroundResource(shoop_tupian[position]);
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.iv_channel)
        ImageView ivChannel;
        @Bind(R.id.tv_channel)
        TextView tvChannel;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}



