package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.TagBean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/3.
 */
public class HorizontalListViewAdapter extends BaseAdapter {
    private Context context;
    List<TagBean.DataBean.TagListBean> datas;
    private String type;
    public HorizontalListViewAdapter(Context con, List<TagBean.DataBean.TagListBean> tagList,String type) {
        this.context = con;
        mInflater = LayoutInflater.from(con);
        datas = tagList;
        this.type = type;
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
        private TextView textview;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.horizontallistview_item, null);
        holder.textview = (TextView) convertView.findViewById(R.id.textview);


        //设置第一个位置 显示标题
        if (position == 0) {
            if ("cat".equals(type)) {
                holder.textview.setText("类型");
            } else if ("sourse".equals(type)) {

            } else if ("year".equals(type)) {
                holder.textview.setText("年代");
            }
            holder.textview.setBackgroundColor(Color.WHITE);
            holder.textview.setTextColor(Color.parseColor("#FF8B8686"));
        } else {
            holder.textview.setText(datas.get(position).getTagName());
            holder.textview.setBackgroundResource(R.drawable.text_shape);
        }
        //给每一个item设置点击事件。并设置按下去的颜色
        holder.textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, datas.get(position).getTagName(), Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }
}
