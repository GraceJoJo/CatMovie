package com.atguigu.catmovie.fragment;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.MyApplication;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.cityindex.citylist.CityList;
import com.atguigu.catmovie.movie.ViewFindUtils;
import com.atguigu.catmovie.movie.fragment.FindPlayFragment;
import com.atguigu.catmovie.movie.fragment.HotPlayFragment;
import com.atguigu.catmovie.movie.fragment.WaitPlayFragment;
import com.atguigu.catmovie.utils.SpUtil;
import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;

import java.util.ArrayList;

/**
 * 电影页面---展示数据---选择城市功能---搜索影片功能
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
    private RelativeLayout rl_select_city;
    private TextView curCity;
    LocalBroadcastManager mLBM ;
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
        /**  City---1.判断之前选择的城市：SP中读取
         *          //判断是否需要切换城市
         */
        mLBM = LocalBroadcastManager.getInstance(getActivity());
        mLBM.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String firstLocation = intent.getStringExtra("firstLocation");
                if(!TextUtils.isEmpty(firstLocation)) {
                    curCity.setText(firstLocation);
                }
            }
        },new IntentFilter("isFrist"));
        isSwichCity();
        //设置集成FlocoLayout
        setStyle();

        initListener();

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("TAG", "onResume");
    }

    private void isSwichCity() {
        final String city = SpUtil.getInstance(MyApplication.getmContext()).getString("city", "");
        //定位获得的城市---第二次进来时进行判断是否需要切换
        final String location_city = SpUtil.getInstance(MyApplication.getmContext()).getString("location_city", "");
        if(!TextUtils.isEmpty(city)) {
            if(!TextUtils.isEmpty(location_city)&&!location_city.equals(city)) {
                new AlertDialog.Builder(getActivity())
                            .setTitle("检测到您所在城市为" + location_city + ",是否需要切换")
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    curCity.setText(location_city);
                                    SpUtil.getInstance(MyApplication.getmContext()).save("city",location_city);
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    curCity.setText(city);
                                }
                            })
                            .show();
            }
            curCity.setText(location_city);
        }else {
            //默认设置"长沙"
            curCity.setText("长沙");
        }
    }

    private void initListener() {
       rl_select_city.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getActivity(), "选择城市", Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(getActivity(), CityList.class);
               startActivityForResult(intent, 1);
           }
       });
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

    /**
     * 处理选择城市的返回结果
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null)
            switch (resultCode) {
                case 2:
                    curCity.setText(data.getStringExtra("city"));
                    break;
                default:
                    break;
            }
    }
}
