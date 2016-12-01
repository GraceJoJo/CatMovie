package com.atguigu.catmovie.movie.fragment;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.adapter.HotPlayFragmentAdapter;
import com.atguigu.catmovie.movie.bean.AdvertiseImageBean;
import com.atguigu.catmovie.movie.bean.HotPlayBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 电影---热映Fragment
 */
public class HotPlayFragment extends BaseFragment implements View.OnClickListener {
    private ArrayList<String> datas;
    private LinearLayout ll_search_center;
    private ListView listviewHot;
    private Banner banner;
    private RelativeLayout rl_loading_common;
    private RelativeLayout rl_error_common;
    private List<String> imageurls = new ArrayList<>();
    private List<HotPlayBean.DataBean.MoviesBean> movieList;
    private TextView click_refresh;
    private MaterialRefreshLayout materialRefreshLayout;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_movie_hot, null);
        View headView = View.inflate(mContext, R.layout.hot_listview_head_layout, null);//一个LinearLayout
        //初始化fragment_movie_hot中的控件
        listviewHot = (ListView) view.findViewById(R.id.listview_hot);
        rl_loading_common = (RelativeLayout) view.findViewById(R.id.rl_loading_common);//加载的页面
        rl_error_common = (RelativeLayout) view.findViewById(R.id.rl_error_common);//出错页面
        click_refresh = (TextView) view.findViewById(R.id.click_refresh);//点击刷新
        materialRefreshLayout = (MaterialRefreshLayout)view.findViewById(R.id.refresh);
        //初始化头布局--控件
        ll_search_center = (LinearLayout) headView.findViewById(R.id.ll_search_center);
        banner = (Banner) headView.findViewById(R.id.banner);
        listviewHot.addHeaderView(headView);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {

        listviewHot.setVisibility(View.GONE);
        rl_loading_common.setVisibility(View.VISIBLE);
        rl_error_common.setVisibility(View.GONE);
        materialRefreshLayout.setVisibility(View.GONE);

        getDataFromServer();


        initLister();
    }

    private void setRefresh() {
        materialRefreshLayout.setVisibility(View.VISIBLE);
        materialRefreshLayout.setSunStyle(true);
        materialRefreshLayout.setMaterialRefreshListener(new MaterialRefreshListener() {
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                materialRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialRefreshLayout.finishRefresh();
//                        getDataFromNet();
                    }
                }, 3000);

            }

            @Override
            public void onfinish() {
                Toast.makeText(mContext, "finish", Toast.LENGTH_LONG).show();
            }


        });
    }

    /**
     * 延迟请求网络--模拟加载页面的效果
     */
    private void getDataFromServer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getDataFromNet();
            }
        }, 3000);
    }

    private void initLister() {
        click_refresh.setOnClickListener(this);
    }

    /**
     * 请求广告条和ListView中的数据
     */
    private void getDataFromNet() {
        //请求热映的广告条图片
        RequestNet
                .get()
                .url(ConstantsUtils.HOT_IAMGE_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "二次封装成功，联网失败", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    setRefresh();
                                    rl_loading_common.setVisibility(View.GONE);
                                    Log.e("TAG", "联网成功");
                                    processImageJson(response);
                                    setBannerStyle();
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });

        //请求热映的ListView数据
        RequestNet
                .get()
                .url(ConstantsUtils.HOT_LIST_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
                        rl_error_common.setVisibility(View.VISIBLE);
                        rl_loading_common.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    rl_loading_common.setVisibility(View.GONE);
                                    listviewHot.setVisibility(View.VISIBLE);
                                    Log.e("TAG", "联网成功");
                                    Log.e("TAG", "ListResponse==" + response);
                                    //解析数据
                                    processListViewJson(response);
                                    //设置适配器显示
                                    listviewHot.setAdapter(new HotPlayFragmentAdapter(mContext,movieList));
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }
    //解析Hot的ListView数据
    private void processListViewJson(String json) {
        Gson gson = new Gson();
        HotPlayBean hotPlayBean = gson.fromJson(json, HotPlayBean.class);
        movieList = hotPlayBean.getData().getMovies();
        Log.e("TAG", "movieLsit==="+movieList.size());
    }

    //解析广告条数据
    private void processImageJson(String json) {
        Gson gson = new Gson();
        AdvertiseImageBean advertiseImageBean = gson.fromJson(json, AdvertiseImageBean.class);
        List<AdvertiseImageBean.DataBean> datas = advertiseImageBean.getData();
        for (int i = 0; i < datas.size(); i++) {
            imageurls.add(datas.get(i).getImgUrl());
        }
    }

    private void setBannerStyle() {
        //（1）设置banner的样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //（2）设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //（4）设置图片集合与banner关联
        banner.setImages(imageurls);
        //（5）设置动画效果
        banner.setBannerAnimation(Transformer.CubeOut);
        //（7）设置自动轮播
        banner.isAutoPlay(true);
        //（8）设置轮播时间
        banner.setDelayTime(2000);
        //（9）设置指示器位置(当banner模式中有指示器时)
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        //（10）banner设置方法全部调用完毕时最后调用
        banner.start();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_refresh :
                //错误页面的点击重新刷新请求网络
                getDataFromServer();
                rl_error_common.setVisibility(View.GONE);
                rl_loading_common.setVisibility(View.VISIBLE);
                break;
        }
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            //使用Picasso加载图片
            Picasso.with(context).load((String) path).into(imageView);
        }
    }



}
