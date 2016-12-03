package com.atguigu.catmovie.movie.fragment;

import android.view.View;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;

/**
 * 找片--页面--Fragment
 */
public class FindPlayFragment extends BaseFragment {


    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_movie_find, null);
        return view;
    }
    @Override
    public void initData() {
    }
}
