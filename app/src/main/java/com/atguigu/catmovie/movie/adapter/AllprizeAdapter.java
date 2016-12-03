package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.AllPrizeBean;
import com.atguigu.catmovie.movie.utils.StringUitls;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/12/3.
 */
public class AllprizeAdapter extends BaseAdapter {
    private Context context;
    List<AllPrizeBean.DataBean> datas;
    private String type;

    public AllprizeAdapter(Context context, AllPrizeBean allPrizeBean) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        this.datas = allPrizeBean.getData();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    private LayoutInflater mInflater;

    @Override
    public Object getItem(int position) {
        return position;
    }

    private ViewHolder holder = new ViewHolder();

    private static class ViewHolder {
        private TextView tv_prize;
        private TextView tv_time;
        private TextView tv_prize_movie_name;
        private ImageView iv_prize_movie_icon;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_movie_find_allprize, null);
        holder.tv_prize = (TextView) convertView.findViewById(R.id.tv_prize);
        holder.tv_time = (TextView) convertView.findViewById(R.id.tv_time);
        holder.iv_prize_movie_icon = (ImageView) convertView.findViewById(R.id.iv_prize_movie_icon);
        holder.tv_prize_movie_name = (TextView) convertView.findViewById(R.id.tv_prize_movie_name);

        AllPrizeBean.DataBean dataBean = datas.get(position);
        String festivalName = dataBean.getFestivalName();//奖项名称
        String heldDate = dataBean.getHeldDate();//更新时间
        String date = heldDate.substring(5, 10);
        String img = dataBean.getImg();//图片路径
        String imageUrl = StringUitls.parseImageUrl(img);//处理图片失效
        String movieName = dataBean.getMovieName();
        holder.tv_prize.setText(festivalName);
        holder.tv_prize_movie_name.setText(movieName);
        holder.tv_time.setText(date);
        Picasso.with(context).load(imageUrl).into(holder.iv_prize_movie_icon);
        return convertView;
    }
}
