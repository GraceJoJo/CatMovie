package com.atguigu.catmovie.cinema.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.cinema.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *  影院的适配器
 */
public class CinemaAdapter extends BaseAdapter {
    private Context context;
    private List<ItemBean> datas;

    public CinemaAdapter(Context context) {
        this.context = context;
        datas = new ArrayList<>();
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
            convertView = View.inflate(context, R.layout.item_cinema, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        ItemBean itemBean = datas.get(position);
        if(itemBean.getAddr().length()>20) {
            holder.tvAddr.setText(itemBean.getAddr().substring(0,20)+"...");
        }else {
            holder.tvAddr.setText(itemBean.getAddr());
        }
        holder.tvCinemaName.setText(itemBean.getNm());
        holder.tvSellprice.setText(itemBean.getSellPrice());
        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_cinema_name)
        TextView tvCinemaName;
        @Bind(R.id.tv_sellprice)
        TextView tvSellprice;
        @Bind(R.id.tv_addr)
        TextView tvAddr;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void refresh(List<ItemBean> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
        notifyDataSetChanged();
    }

}
