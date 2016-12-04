package com.atguigu.catmovie.fragment;

import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.cinema.CinemaBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;
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
    @Bind(R.id.tv_cinema_head_text)
    TextView tvCinemaHeadText;
    @Bind(R.id.tv_cinema_login)
    TextView tvCinemaLogin;

    @Bind(R.id.listview_cinema)
    ListView listviewCinema;
    private Banner banner;
    private List<String> imageurls;
    private CinemaBean cinemaBean;
    private LocalBroadcastManager mLBM;
    private TextView curCity;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_cinema, null);
        ButterKnife.bind(this, view);
        banner = (Banner) view.findViewById(R.id.banner_cinema);
        /**
         * 当前所选的城市
         */
        curCity = (TextView) view.findViewById(R.id.tv_select_city);
        return view;
    }

    @Override
    public void initData() {
        String url = "http://p0.meituan.net/mmc/34df9f37cdbb47e7c701582697d2566254352.jpg";
        imageurls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            imageurls.add(url);
        }

        setBannerStyle();

        initListener();

        getDataFromNet();
    }

    private void initListener() {


    }

    private void getDataFromNet() {
        RequestNet
                .get()
                .url(ConstantsUtils.CINIMA_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    rl_loading_common.setVisibility(View.GONE);
                                    Log.e(TAG, "影院---联网成功--" + response);
                                    parseJson(response);

                                    if (cinemaBean != null) {
//                                        listviewCinema.setAdapter(new CinemaAdapter(cinemaBean,getActivity()));
                                    }
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }

    private void parseJson(String json) {
        Gson gson = new Gson();
        cinemaBean = gson.fromJson(json, CinemaBean.class);
        Log.e(TAG, cinemaBean.getData().get东城区().size()+"");
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
        if(!hidden) {
            isFragmentVisible();
        }
    }

    private void isFragmentVisible() {
        MainActivity activity = (MainActivity) getActivity();
        activity.getLlCommonTitl().setVisibility(View.VISIBLE);
        activity.getLlCinemaSearch().setVisibility(View.INVISIBLE);
        activity.getLlCinemaSelect().setVisibility(View.INVISIBLE);
        activity.getSlidelayout().setVisibility(View.GONE);
        activity.getTl10().setVisibility(View.GONE);
        activity.getTextCinemaCenter().setVisibility(View.VISIBLE);
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

