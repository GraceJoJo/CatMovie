package com.atguigu.catmovie.find;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 发现页面--头部分--GirdView的适配器
 */
public class HeadGridViewAdapter extends BaseAdapter {
    private final Context context;
    private List<HeadBean.DataBean> datas = new ArrayList<>();

    public HeadGridViewAdapter(Context context) {
        this.context = context;
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

        ViewHolder holdler;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_gridview, null);
            holdler = new ViewHolder(convertView);
            convertView.setTag(holdler);
        } else {
            holdler = (ViewHolder) convertView.getTag();
        }
        HeadBean.DataBean dataBean = datas.get(position);
        holdler.headTvTitle.setText(dataBean.getTitle());
        String url = dataBean.getImage().getUrl();
        if(!TextUtils.isEmpty(url)) {
            Picasso.with(context).load(url).into(holdler.headIvIcon);
            Log.e("TAG", "dataBean.getUrl();"+dataBean.getUrl());
        }
        return convertView;
    }

    public void refresh(List<HeadBean.DataBean> datas) {
        if (datas != null && datas.size() > 0) {
            this.datas.clear();
            this.datas.addAll(datas);
            notifyDataSetChanged();
            Log.e("TTT", "datas.size=="+datas.size());
        }
    }

    static class ViewHolder {
        @Bind(R.id.head_iv_icon)
        ImageView headIvIcon;
        @Bind(R.id.head_tv_name)
        TextView headTvTitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
