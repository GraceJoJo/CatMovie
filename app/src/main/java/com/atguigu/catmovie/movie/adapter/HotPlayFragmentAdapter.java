package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.HotPlayBean;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 热映-页面--ListView的适配器
 */
public class HotPlayFragmentAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<HotPlayBean.DataBean.MoviesBean> datas;

    public HotPlayFragmentAdapter(Context context, List<HotPlayBean.DataBean.MoviesBean> movieList) {
        this.mContext = context;
        this.datas = movieList;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_hot_layout, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        HotPlayBean.DataBean.MoviesBean moviesBean = datas.get(position);
        Picasso.with(mContext).load(moviesBean.getImg()).into(holder.ivMovieIcon);
        holder.movieName.setText(moviesBean.getNm());
        holder.movieDesc.setText(moviesBean.getScm());
        holder.moviePlayInfo.setText(moviesBean.getShowInfo());
        //判断是预售还是购票
        isPreSale(holder, moviesBean);
        //判断是否是3D
        is3D(holder, moviesBean);
        return convertView;
    }

    private void is3D(ViewHolder holder, HotPlayBean.DataBean.MoviesBean moviesBean) {
        boolean is3D = moviesBean.isValue3d();
        if(is3D) {
            holder.movie_type_3d.setVisibility(View.VISIBLE);
            holder.movie_type_2d.setVisibility(View.GONE);
        }else {
            holder.movie_type_3d.setVisibility(View.GONE);
            holder.movie_type_2d.setVisibility(View.VISIBLE);
        }
    }

    private void isPreSale(ViewHolder holder, HotPlayBean.DataBean.MoviesBean moviesBean) {
        int preSale = moviesBean.getPreSale();//0-购票  1--预售
        if(preSale==0) {
            holder.yushou.setVisibility(View.GONE);
            holder.buyTicket.setVisibility(View.VISIBLE);
        }else {
            holder.yushou.setVisibility(View.VISIBLE);
            holder.buyTicket.setVisibility(View.GONE);
        }
    }

    static class ViewHolder {
        @Bind(R.id.iv_movie_icon)
        ImageView ivMovieIcon;
        @Bind(R.id.movie_name)
        TextView movieName;
        @Bind(R.id.movie_type_3d)
        TextView movie_type_3d;
        @Bind(R.id.movie_type_2d)
        TextView movie_type_2d;
        @Bind(R.id.movie_desc)
        TextView movieDesc;
        @Bind(R.id.movie_play_info)
        TextView moviePlayInfo;
        @Bind(R.id.buy_ticket)
        TextView buyTicket;
        @Bind(R.id.yushou)
        TextView yushou;
        @Bind(R.id.rl_item)
        RelativeLayout rlItem;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
