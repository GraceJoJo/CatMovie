package com.atguigu.catmovie.find.shopmall;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MallActivity extends Activity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.iv_search)
    ImageView ivSearch;
    @Bind(R.id.recycleview)
    RecyclerView recycleview;
    @Bind(R.id.tv_mall)
    TextView tvMall;
    @Bind(R.id.ll_titlebar)
    RelativeLayout llTitlebar;
    private List<String> imageUrls;
    private ShopMallAdapter adapter;
    private List<ShopMallList.DataBean.ListBean> datas;
    private List<TeJiaBean.DataBean.ListBean> goodsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mall);
        ButterKnife.bind(this);
        initData();
        initListener();
    }

    private void initListener() {
//        实现思路：
//
//        1、先获取顶部图片的高度height，这个有3种方式获取，我用的是监听onGlobalLayout方法的回调
//
//        2、监听scrollview的滚动坐标，原生的没有这个监听，需要我们自己写个view继承scrollview，然后重写onScrollChanged()方法，创建一个监听，在这个方法里面回调
//
//        3、根据图片高度height和滚动的纵坐标y进行判断，算出比例，透明度范围0~255，根据比例设置改变的透明度，当y>height是不做改变
        recycleview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
//                int height = 100;
//                if (dy <= height && dy >= 0) {
//                    float scale = (float) dy / height;
//                    float alpha = (255 * scale);
//                    llTitlebar.setBackgroundColor(Color.parseColor("#D43E37"));
//                } else if (dy > height) {
//                    llTitlebar.getBackground().setAlpha(0);
//                }
                Log.e("TAG", "dy====="+dy);
            }
        });
//        // 最重要的方法，标题栏的透明度变化在这个方法实现
//        @Override
//        public void onScroll(AbsListView listView, int firstVisibleItem,
//        int visibleItemCount, int totalItemCount) {
//            // 判断当前最上面显示的是不是头布局，因为Xlistview有刷新控件，所以头布局的位置是1，即第二个
//            if (firstVisibleItem == 1) {
//                // 获取头布局
//                View view = listView.getChildAt(0);
//                if (view != null) {
//                    // 获取头布局现在的最上部的位置的相反数
//                    int top = -view.getTop();
//                    // 获取头布局的高度
//                    headerHeight = view.getHeight();
//                    // 满足这个条件的时候，是头布局在XListview的最上面第一个控件的时候，只有这个时候，我们才调整透明度
//                    if (top <= headerHeight && top >= 0) {
//                        // 获取当前位置占头布局高度的百分比
//                        float f = (float) top / (float) headerHeight;
//                        rl_title.getBackground().setAlpha((int) (f * 255));
//                        // 通知标题栏刷新显示
//                        rl_title.invalidate();
//                    }
//                }
//            } else if (firstVisibleItem > 1) {
//                rl_title.getBackground().setAlpha(255);
//            } else {
//                rl_title.getBackground().setAlpha(0);
//            }
//        }
    }


    private void initData() {

        getDataFromNet();//得到图片数据
        getListDatas();//得到您可能喜欢的数据


    }


    private void getDataFromNet() {
        RequestNet
                .url(ConstantsUtils.BASE_URL_MALL_VIEWPAGER, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(MallActivity.this, "联网失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        parseJson(response);
                        setAdapter();
                    }
                });

    }

    private void setAdapter() {
        GridLayoutManager manager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position <= 3) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        recycleview.setLayoutManager(manager);
        adapter = new ShopMallAdapter(this, imageUrls, datas, goodsList);
        recycleview.setAdapter(adapter);
    }

    private void parseJson(String json) {
        //解析图片
        imageUrls = new ArrayList<>();
        JSONObject jsonObject = JSONObject.parseObject(json);
        String data = jsonObject.getString("data");
        List<ImageBean.DataBean> dataBeans = JSON.parseArray(data, ImageBean.DataBean.class);

        for (int i = 0; i < dataBeans.size(); i++) {
            ImageBean.DataBean dataBean = dataBeans.get(i);
            imageUrls.add(dataBean.getImgUrl());
        }
    }

    private void getListDatas() {
        //使用fastjson解析--下面商品的Json数据
        JSONObject mJsonObject = JSONObject.parseObject(ConstantsUtils.SHOP_MALL_JSON);
        String mData = mJsonObject.getString("data");
        JSONObject mJsonObject2 = JSONObject.parseObject(mData);
        String list = mJsonObject2.getString("list");
        datas = JSON.parseArray(list, ShopMallList.DataBean.ListBean.class);

        TeJiaBean teJiaBean = new Gson().fromJson(ConstantsUtils.SHOP_TEJIA, TeJiaBean.class);
        goodsList = teJiaBean.getData().getList();
    }
}
