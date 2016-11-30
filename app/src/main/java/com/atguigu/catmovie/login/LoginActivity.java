package com.atguigu.catmovie.login;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.login.fragment.LoginByPhoneFragment;
import com.atguigu.catmovie.login.fragment.LoginByPwFragment;
import com.viewpagerindicator.TabPageIndicator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends FragmentActivity {

    @Bind(R.id.login)
    TextView login;
    @Bind(R.id.register)
    TextView register;
    @Bind(R.id.viewapger_loging)
    ViewPager viewapgerLoging;
    @Bind(R.id.tabpager_indicator)
    TabPageIndicator tabpagerIndicator;
    private List<BaseFragment> fragments = new ArrayList<>();
    private String[] titles = new String[]{"账号密码登录","手机号快捷登录"};
    private LoginByPwFragment loginByPwFragment;
    private LoginByPhoneFragment loginByPhoneFragment;
    private LoginPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        initData();

        setViewPagerAdapter();
    }

    private void setViewPagerAdapter() {
        adapter = new LoginPagerAdapter(getSupportFragmentManager());
        viewapgerLoging.setAdapter(adapter);
        tabpagerIndicator.setViewPager(viewapgerLoging);
    }

    private void initData() {
        initFragment();
    }

    private void initFragment() {
        loginByPwFragment = new LoginByPwFragment();
        loginByPhoneFragment = new LoginByPhoneFragment();
        fragments.add(loginByPwFragment);
        fragments.add(loginByPhoneFragment);
    }

    class LoginPagerAdapter extends FragmentPagerAdapter {

        public LoginPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}