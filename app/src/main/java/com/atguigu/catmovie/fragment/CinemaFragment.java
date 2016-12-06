package com.atguigu.catmovie.fragment;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.cinema.adapter.CinemaAdapter;
import com.atguigu.catmovie.cinema.bean.CinemaBean;
import com.atguigu.catmovie.cinema.bean.ItemBean;
import com.atguigu.catmovie.cinema.utils.CitydatasUtil;
import com.atguigu.catmovie.cinema.view.MenuPopup;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 影院的bean类
 */
public class CinemaFragment extends BaseFragment {
    private static final String TAG = "cinema";
    @Bind(R.id.listview_cinema)
    ListView listviewCinema;
    @Bind(R.id.tv_detail_attr)//下面悬浮的TextView
            TextView tv_detail_attr;
    private Banner banner;
    private List<String> imageurls;
    private CinemaBean cinemaBean;
    private LocalBroadcastManager mLBM;
    private TextView curCity;
    private CinemaAdapter adapter;
    private List<ItemBean> datas;
    private LinearLayout ll_cinema_search;//搜索
    private LinearLayout ll_cinema_select;//城市筛选
    private MenuPopup mMenuPopup;
    private ListView popup_listview;
    private List<String> cities;
    private CitydatasUtil citydatasUtil;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_cinema, null);
        ll_cinema_search = (LinearLayout) view.findViewById(R.id.ll_cinema_search);
        ll_cinema_select = (LinearLayout) view.findViewById(R.id.ll_cinema_select);
        ButterKnife.bind(this, view);
        View headView = View.inflate(mContext, R.layout.layout_cinema_headview, null);
        TextView tv_cinema_head_text = (TextView) headView.findViewById(R.id.tv_cinema_head_text);
        TextView tv_cinema_login = (TextView) headView.findViewById(R.id.tv_cinema_login);//登陆
        banner = (Banner) headView.findViewById(R.id.banner_cinema);
        /**
         * 当前所选的城市
         */
        curCity = (TextView) view.findViewById(R.id.tv_select_city);
        listviewCinema.addHeaderView(headView);
        return view;
    }

    @Override
    public void initData() {
//        //设置


        String url = "http://p0.meituan.net/mmc/34df9f37cdbb47e7c701582697d2566254352.jpg";//上面banner的图片
        imageurls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imageurls.add(url);
        }

        setBannerStyle();

        setAdapter();

        citydatasUtil = new CitydatasUtil(getActivity(), adapter);
        initListener();


    }


    private void initListener() {
        //设置下面的悬浮的textView的隐藏和显示
        listviewCinema.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tv_detail_attr.setVisibility(View.INVISIBLE);
                    return false;
                } else if (event.getAction() == MotionEvent.ACTION_MOVE) {
                    tv_detail_attr.setVisibility(View.INVISIBLE);
                    return false;
                } else {
                    tv_detail_attr.setVisibility(View.VISIBLE);
                    return false;
                }
            }
        });
        mMenuPopup = new MenuPopup(getActivity());
        ll_cinema_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMenuPopup.showPopupWindow(v);
                setSelect(); //设置筛选刷新数据
            }
        });
    }
    //设置筛选刷新数据
    private void setSelect() {
        mMenuPopup.getTx1().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData();
            }
        });
        mMenuPopup.getTx2().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              citydatasUtil.getData1();
            }
        });
        mMenuPopup.getTx3().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData2();
            }
        });
        mMenuPopup.getTx4().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData3();
            }
        });
        mMenuPopup.getTx5().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData4();
            }
        });
        mMenuPopup.getTx6().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData5();
            }
        });
        mMenuPopup.getTx7().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData6();
            }
        });
        mMenuPopup.getTx8().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData7();
            }
        });
        mMenuPopup.getTx9().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData8();
            }
        });
        mMenuPopup.getTx10().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citydatasUtil.getData9();
            }
        });

    }

    private void setAdapter() {
        adapter = new CinemaAdapter(getActivity());
        listviewCinema.setAdapter(adapter);
    }


    private void setBannerStyle() {
        //（1）设置banner的样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //（2）设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //（4）设置图片集合与banner关联
        banner.setImages(imageurls);
        //（5）设置动画效果
        banner.setBannerAnimation(Transformer.Default);
        //（7）设置自动轮播
        banner.isAutoPlay(true);
        //（8）设置轮播时间
        banner.setDelayTime(2000);
        //（9）设置指示器位置(当banner模式中有指示器时)
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //（10）banner设置方法全部调用完毕时最后调用
        banner.start();

    }


    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //使用Picasso加载图片
            Picasso.with(context).load((String) path).into(imageView);
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
        activity.getLlCommonTitl().setVisibility(View.GONE);
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
        isFragmentVisible();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        isFragmentVisible();
        Log.e(TAG, "onStop");
    }
}

