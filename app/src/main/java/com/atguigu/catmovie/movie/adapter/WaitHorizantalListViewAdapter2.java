package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.RecentRespectBean;
import com.atguigu.catmovie.movie.utils.StringUitls;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * 待映页面前面两个类型的适配器
 */
public class WaitHorizantalListViewAdapter2 extends BaseAdapter {
    private Context context;
    List<RecentRespectBean.DataBean.ComingBean> datas;
    private String type;

    public WaitHorizantalListViewAdapter2(Context context, RecentRespectBean recentRespectBean) {
        this.context = context;
        this.datas = recentRespectBean.getData().getComing();
    }

    //    public WaitHorizantalListViewAdapter1(Context con, List<RecentRespectBean.DataBean.ComingBean> datas, String type) {
//        this.context = con;
//        this.datas = datas;
//        this.type = type;
//    }
//
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
        private TextView tv_play_time;
        private ImageView iv_movie_icon;
        private TextView tv_movie;
        private TextView tv_wish;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.horizontallistview_item_type2, null);
        holder.tv_play_time = (TextView) convertView.findViewById(R.id.tv_play_time);
        holder.iv_movie_icon = (ImageView) convertView.findViewById(R.id.iv_movie_icon);
        holder.tv_movie = (TextView) convertView.findViewById(R.id.tv_movie);
        holder.tv_wish = (TextView) convertView.findViewById(R.id.tv_wish);
        RecentRespectBean.DataBean.ComingBean comingBean = datas.get(position);
        holder.tv_play_time.setText(comingBean.getRt());
        holder.tv_movie.setText(comingBean.getNm());
        holder.tv_wish.setText(comingBean.getWish());
        Picasso.with(context).load(StringUitls.parseImageUrl(comingBean.getImg())).into(holder.iv_movie_icon);
        return convertView;
    }
}
