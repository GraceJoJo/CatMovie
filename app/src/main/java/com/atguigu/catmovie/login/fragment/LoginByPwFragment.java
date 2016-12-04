package com.atguigu.catmovie.login.fragment;

import android.view.View;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;

/**
 * 登陆页面----账号密码登陆
 */
public class LoginByPwFragment extends BaseFragment {
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_login_by_pw, null);
        return view;
    }
    @Override
    public void initData() {
    }
}
