package com.atguigu.catmovie.find.shopmall;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.find.shopmall.bean.ImageBean;
import com.atguigu.catmovie.find.shopmall.bean.ShopMallList;
import com.atguigu.catmovie.find.shopmall.bean.TeJiaBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.atguigu.catmovie.utils.DensityUtil;
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
    private int mDistanceY;
    private void initListener() {
//        实现思路：
//        根据toolbar的高度height和滚动的纵坐标y进行判断，算出比例，透明度范围0~255，根据比例设置改变的透明度，当y>height是不做改变
        recycleview.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //滑动的距离
                mDistanceY += dy;
                //toolbar的高度
                int toolbarHeight = llTitlebar.getBottom()+ DensityUtil.dip2px(MallActivity.this,80);

                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
                if (mDistanceY <= toolbarHeight && mDistanceY >= 0) {
                    float scale = (float) mDistanceY / toolbarHeight;
                    float alpha = scale * 255;

                    llTitlebar.setBackgroundColor(Color.argb((int) alpha, 209, 52, 51));
                } else {
                    //上述虽然判断了滑动距离与toolbar高度相等的情况，但是实际测试时发现，标题栏的背景色
                    //很少能达到完全不透明的情况，所以这里又判断了滑动距离大于toolbar高度的情况，
                    //将标题栏的颜色设置为完全不透明状态
                    llTitlebar.setBackgroundColor(Color.parseColor("#E04037"));
                    llTitlebar.setAlpha(1);
                }

            }
        });
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
