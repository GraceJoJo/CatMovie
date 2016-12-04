package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.YugaoBean;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 待映页面前面两个类型的适配器
 */
public class WaitHorizantalListViewAdapter1 extends BaseAdapter {
    private Context context;
    List<YugaoBean.DataBean> datas;

    public WaitHorizantalListViewAdapter1(Context context, YugaoBean yugaoBean) {
        this.context = context;
        this.datas = yugaoBean.getData();
    }

    @Override
    public int getCount() {
        return datas.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    private ViewHolder holder = new ViewHolder();

    private static class ViewHolder {
        private TextView tv_moviename;
        private ImageView iv_icon;
        private TextView tv_video_name;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.horizontallistview_item, null);
        holder.tv_moviename = (TextView) convertView.findViewById(R.id.tv_movie_name);
        holder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_icon);
        holder.tv_video_name = (TextView) convertView.findViewById(R.id.tv_video_name);
        YugaoBean.DataBean dataBean = datas.get(position);
        holder.tv_moviename.setText(dataBean.getMovieName());
        holder.tv_video_name.setText(dataBean.getOriginName());
        if(!TextUtils.isEmpty(dataBean.getImg())) {
            Picasso.with(context).load(dataBean.getImg()).into(holder.iv_icon);
        }
        return convertView;
    }
}
