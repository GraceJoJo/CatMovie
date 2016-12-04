package com.atguigu.catmovie.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.fragment.FindPlayFragment;
import com.atguigu.catmovie.movie.fragment.HotPlayFragment;
import com.atguigu.catmovie.movie.fragment.WaitPlayFragment;
import com.atguigu.catmovie.movie.utils.ViewFindUtils;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * 电影页面---展示数据---选择城市功能---搜索影片功能
 */
public class MovieFragment extends BaseFragment implements OnTabSelectListener {
    private static final String TAG = "movie";
    //    @Bind(R.id.tv_select_city)
//    TextView tvSelectCity;
//    @Bind(R.id.rl_select_city)
//    RelativeLayout rlSelectCity;
//    @Bind(R.id.text_cinema_center)
//    TextView textCinemaCenter;
//    @Bind(R.id.tl_10)
//    SlidingTabLayout tl10;
//    @Bind(R.id.slidelayout)
//    LinearLayout slidelayout;
//    @Bind(R.id.iv_select_city)
//    ImageView ivSelectCity;
//    @Bind(R.id.ll_cinema_select)
//    LinearLayout llCinemaSelect;
//    @Bind(R.id.iv_search_icon)
//    ImageView ivSearchIcon;
//    @Bind(R.id.ll_cinema_search)
//    LinearLayout llCinemaSearch;
    private Context mContext;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private final String[] mTitles = {
            "热映", "待映", "找片"

    };
    private MyPagerAdapter mAdapter;
    private HotPlayFragment hotPlayFragment;
    private WaitPlayFragment waitPlayFragment;
    private FindPlayFragment findPlayFragment;
    private RelativeLayout rl_select_city;
    private TextView curCity;
    LocalBroadcastManager mLBM;
    private ViewPager vp;

    @Override
    public View initView() {
        View view = View.inflate(getActivity(), R.layout.fragment_movie, null);
        //选择城市
        rl_select_city = (RelativeLayout) view.findViewById(R.id.rl_select_city);
        /**
         * 当前所选的城市
         */
        curCity = (TextView) view.findViewById(R.id.tv_select_city);

        mContext = getActivity();
        initFragment();
        return view;
    }

    @Override
    public void initData() {

        setStyle();


    }

    private void initListener() {


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

        View decorView = getActivity().getWindow().getDecorView();
        vp = ViewFindUtils.find(decorView, R.id.vp);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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


    @Override
    public void onDestroy() {
        super.onDestroy();
//        要解注册
//        mLBM.unregisterReceiver();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged" + hidden);
        if (!hidden) {
            isFragmentVisible();
        }
    }

    private void isFragmentVisible() {
        MainActivity activity = (MainActivity) getActivity();
        activity.getLlCommonTitl().setVisibility(View.VISIBLE);
        activity.getLlCinemaSearch().setVisibility(View.INVISIBLE);
        activity.getLlCinemaSelect().setVisibility(View.INVISIBLE);
        activity.getSlidelayout().setVisibility(View.VISIBLE);
        activity.getTl10().setVisibility(View.VISIBLE);
        activity.getTextCinemaCenter().setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentVisible();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        isFragmentVisible();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
        isFragmentVisible();
    }
}
