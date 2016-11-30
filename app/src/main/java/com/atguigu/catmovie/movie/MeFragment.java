package com.atguigu.catmovie.movie;

import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.utils.DensityUtil;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MeFragment  extends BaseFragment{
    private TextView textView;
    @Override
    public View initView() {
//        View.inflate(mContext, R.layout.fragment_me,null);
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(DensityUtil.dip2px(mContext, 40));
        return textView;
    }
    @Override
    public void initData() {
        textView.setText("我的");
    }
}
