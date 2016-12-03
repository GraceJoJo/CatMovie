package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.TagBean;
import com.atguigu.catmovie.movie.utils.DrawUtils;
import com.atguigu.catmovie.utils.DensityUtil;

import java.util.List;

/**
 * 标签页的通用适配器
 */
public class HorizontalListViewAdapter extends BaseAdapter {
    private Context context;
    List<TagBean.DataBean.TagListBean> datas;
    private String type;

    public HorizontalListViewAdapter(Context con, List<TagBean.DataBean.TagListBean> tagList, String type) {
        this.context = con;
        datas = tagList;
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
        if(convertView==null) {
            convertView = View.inflate(context,R.layout.horizontallistview_item, null);
            holder.textview = (TextView) convertView.findViewById(R.id.textview);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        Log.e("TAG", "标签position===" + position);

        //设置第一个位置 显示标题
        if (position == 0) {
            if ("cat".equals(type)) {
                holder.textview.setText("类型");
            } else if ("sourse".equals(type)) {

            } else if ("year".equals(type)) {
                holder.textview.setText("年代");
            }
            holder.textview.setBackgroundColor(Color.WHITE);
            holder.textview.setTextColor(Color.parseColor("#8C8C8C"));
        } else {
            holder.textview.setText(datas.get(position).getTagName());
            holder.textview.setBackgroundResource(R.drawable.text_shape);
        }
//        holder.textview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, datas.get(position).getTagName(), Toast.LENGTH_SHORT).show();
//                Log.e("TAG", "position///对集合数据取余"+position%datas.size());
//            }
//        });
        //处理每一个item的点击事件。并设置按下去的颜色
        holder.textview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    //更改为按下时的图片
                    Log.e("TAG", "ACTION_DOWN----position///对集合数据取余"+position%datas.size());
                    holder.textview.setBackground(DrawUtils.getDrawable(Color.parseColor("#ffff6622"), DensityUtil.dip2px(10)));
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    //更改为抬起时的图片
                    Log.e("TAG", "ACTION_UP-----position///对集合数据取余"+position%datas.size());
                    holder.textview.setBackground(DrawUtils.getDrawable(Color.parseColor("#FFFFFF"), DensityUtil.dip2px(10)));
                    Toast.makeText(context, datas.get(position).getTagName(), Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });
        return convertView;
    }
}
