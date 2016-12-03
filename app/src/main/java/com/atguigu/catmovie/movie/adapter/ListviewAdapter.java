package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.catmovie.MyApplication;
import com.atguigu.catmovie.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */
public class ListviewAdapter extends BaseAdapter {
    private List<String> datas = new ArrayList<>();

    public ListviewAdapter() {
        datas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            datas.add("item----" + i);
        }
    }

    private Context mContext;

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
            holder = new ViewHolder();
            convertView = LayoutInflater.from(MyApplication.getmContext()).inflate(
                    R.layout.item_horizontal_list, null);
            holder.textView = (TextView) convertView
                    .findViewById(R.id.textview);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView textView;
    }
}
