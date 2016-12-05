package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.TagBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 标签页的通用适配器
 */
public class HorizontalListViewAdapter1 extends BaseAdapter {
    private Context context;
    List<TagBean.DataBean.TagListBean> datas = new ArrayList<>();
    private String type;
    private int mPosition=-1;

    public HorizontalListViewAdapter1(Context con, String type) {
        this.context = con;
        this.type = type;
    }
    @Override
    public int getCount() {
        return datas.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }


    public void setPosition(int position) {
        this.mPosition = position;
        notifyDataSetChanged();
    }




    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {;
            convertView = View.inflate(context, R.layout.horizontallistview_item_tag, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        //设置第一个位置 显示标题
        if (position == 0) {
            if ("cat".equals(type)) {
                holder.textview.setText("类型");
            } else if ("sourse".equals(type)) {

            } else if ("year".equals(type)) {
                holder.textview.setText("年代");
            }
            holder.textview.setBackgroundColor(Color.WHITE);
        } else {
            holder.textview.setText(datas.get(position).getTagName());
            holder.textview.setBackgroundResource(R.drawable.text_selector);
        }
        if (mPosition == position) {
            holder.textview.setPressed(true);
        } else {
            holder.textview.setPressed(false);
        }
        Log.e("TAG", "标签position===" + position);
        return convertView;
    }

    class ViewHolder {
        @Bind(R.id.textview)
        TextView textview;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    public void refresh(List<TagBean.DataBean.TagListBean> datas){
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }
}
