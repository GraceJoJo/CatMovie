package com.atguigu.catmovie.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.ViewFindUtils;
import com.atguigu.catmovie.movie.fragment.FindPlayFragment;
import com.atguigu.catmovie.movie.fragment.HotPlayFragment;
import com.atguigu.catmovie.movie.fragment.WaitPlayFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * 电影页面
 */
public class MovieFragment extends BaseFragment  implements OnTabSelectListener {
    private Context mContext;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热映", "待映", "找片"

    };
    private MyPagerAdapter mAdapter;
    private HotPlayFragment hotPlayFragment;
    private WaitPlayFragment waitPlayFragment;
    private FindPlayFragment findPlayFragment;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_movie, null);
        mContext = getActivity();
        initFragment();
        return view;
    }
    @Override
    public void initData() {
        //设置集成FlocoLayout
        setStyle();

    }

    private void initFragment() {
        hotPlayFragment = new HotPlayFragment();
        waitPlayFragment = new WaitPlayFragment();
        findPlayFragment = new FindPlayFragment();
        mFragments.add(hotPlayFragment);
        mFragments.add(waitPlayFragment);
        mFragments.add(findPlayFragment);
    }

    private void setStyle() {

//        for (String title : mTitles) {
//            mFragments.add(SimpleCardFragment.getInstance(title));
//        }


        View decorView = getActivity().getWindow().getDecorView();
        ViewPager vp = ViewFindUtils.find(decorView, R.id.vp);
        mAdapter = new MyPagerAdapter(getActivity().getSupportFragmentManager());
        vp.setAdapter(mAdapter);


        /** indicator圆角色块 */
        SlidingTabLayout tabLayout_10 = ViewFindUtils.find(decorView, R.id.tl_10);

        tabLayout_10.setViewPager(vp);
        //设置默认选中第四个位置
        vp.setCurrentItem(0);
    }
    @Override
    public void onTabSelect(int position) {
        Toast.makeText(mContext, "onTabSelect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabReselect(int position) {
        Toast.makeText(mContext, "onTabReselect&position--->" + position, Toast.LENGTH_SHORT).show();
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }
}
