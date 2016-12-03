package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.PrizeBean;
import com.atguigu.catmovie.movie.utils.StringUitls;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *找片---奖项--的GridView的适配器
 */
public class PrizeAdapter extends BaseAdapter{
    private  Context context;
    private  List<PrizeBean.DataBean> prizeList;

    public PrizeAdapter(PrizeBean prizeBean, Context context) {
        this.context = context;
        this.prizeList = prizeBean.getData();
    }


    @Override
    public int getCount() {
        return prizeList.size();
    }

    @Override
    public Object getItem(int position) {
        return prizeList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item_movie_prize, null);
        TextView tv_reying = (TextView) convertView.findViewById(R.id.tv_reying);
        TextView tv_movie_name = (TextView) convertView.findViewById(R.id.tv_movie_name);
        ImageView iv_title_icon = (ImageView) convertView.findViewById(R.id.iv_title_icon);
        ImageView iv_title_icon2 = (ImageView) convertView.findViewById(R.id.iv_title_icon2);
        PrizeBean.DataBean dataBean = prizeList.get(position);
        tv_reying.setText(dataBean.getBoardName());
        tv_movie_name.setText(dataBean.getMovieName());

        Picasso.with(context).load(StringUitls.parseImageUrl(dataBean.getMovieImgs().get(0))).into(iv_title_icon);
        Picasso.with(context).load(StringUitls.parseImageUrl(dataBean.getMovieImgs().get(1))).into(iv_title_icon2);
        //处理字体颜色
      switch (position) {
          case 0 :
              tv_reying.setTextColor(Color.parseColor("#48B8F2"));
              break;
          case 1:
              tv_reying.setTextColor(Color.parseColor("#F56D5E"));
              break;
          case 2:
              tv_reying.setTextColor(Color.parseColor("#F7893F"));
              break;
          case 3:
              tv_reying.setTextColor(Color.parseColor("#79C335"));
              break;
      }

        return convertView;
    }
}
