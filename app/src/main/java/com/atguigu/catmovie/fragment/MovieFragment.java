package com.atguigu.catmovie.fragment;

import android.view.View;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;

/**
 * 电影页面
 */
public class MovieFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.loading_layout, null);
        return view;
    }
    @Override
    public void initData() {

    }
}
