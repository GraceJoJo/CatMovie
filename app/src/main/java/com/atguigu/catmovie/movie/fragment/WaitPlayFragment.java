package com.atguigu.catmovie.movie.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.adapter.StickyExampleAdapter;
import com.atguigu.catmovie.movie.adapter.StickyExampleModel;
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影--待映--页面
 */
public class WaitPlayFragment extends BaseFragment {

    private View view;
    private TextView tv_headview;
    private RecyclerView recycleview;
    private List<WaitPlayBean.DataBean.ComingBean> comingList;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_movie_waitplay, null);
        initRecyclerView();
        return view;
    }
    @Override
    public void initData() {

//        rl_loading_common.setVisibility(View.VISIBLE);
//        rl_error_common.setVisibility(View.GONE);
        getDataFromNet();
    }
    private void initRecyclerView() {
        recycleview = (RecyclerView)view.findViewById(R.id.recycleview);
        tv_headview = (TextView)view.findViewById(R.id.tv_headview);

        assert recycleview != null;
        assert tv_headview != null;


        recycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                View stickyInfoView = recyclerView.findChildViewUnder(
                        tv_headview.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tv_headview.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                View transInfoView = recyclerView.findChildViewUnder(
                        tv_headview.getMeasuredWidth() / 2, tv_headview.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tv_headview.getMeasuredHeight();
                    if (transViewStatus == StickyExampleAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {
                            tv_headview.setTranslationY(dealtY);
                        } else {
                            tv_headview.setTranslationY(0);
                        }
                    } else if (transViewStatus == StickyExampleAdapter.NONE_STICKY_VIEW) {
                        tv_headview.setTranslationY(0);
                    }
                }
            }
        });
    }

    private void getDataFromNet() {
        //请求待映的json数据
        RequestNet
                .get()
                .url(ConstantsUtils.HOT_WAIT_PALY_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
//                        rl_error_common.setVisibility(View.VISIBLE);
//                        rl_loading_common.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    rl_loading_common.setVisibility(View.GONE);
                                    Log.e("WAIT", "待映页面--联网成功");
                                    Log.e("TAG", "待映页面--Json==" + response);
                                    processJson(response);
                                    recycleview.setLayoutManager(new LinearLayoutManager(mContext));
                                    recycleview.setAdapter(new StickyExampleAdapter(mContext, getData(), comingList));
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }
    public List<StickyExampleModel> getData() {
        List<StickyExampleModel> stickyExampleModels = new ArrayList<>();
        String constantsUrl = "http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg";
        for (int index = 0; index < 30; index++) {
            if (index == 0) {
                stickyExampleModels.add(new StickyExampleModel("预告片推荐","电影"+index,000,"","",constantsUrl));
            } else if (index == 1) {
                stickyExampleModels.add(new StickyExampleModel("近期最受期待","电影"+index,111,"","",constantsUrl));
            } else if (index < comingList.size()+2) {
                //设置一个死的图片路径

                WaitPlayBean.DataBean.ComingBean comingBean = comingList.get(index - 2);
                Log.e("TAG", "imageUrls=="+comingBean.getImg());
                stickyExampleModels.add(new StickyExampleModel("12月2日 周五",comingBean .getNm(),
                        comingBean.getWish(),comingBean.getDesc(),comingBean.getStar(),constantsUrl));
            }
//      else
//          stickyExampleModels.add(new StickyExampleModel(
//                  "吸顶文本4", "name" + index, "gender" + index, "profession" + index));
//      }
        }

        return stickyExampleModels;
    }

    private void processJson(String json) {
        Gson gson = new Gson();
        WaitPlayBean waitPlayBean = gson.fromJson(json, WaitPlayBean.class);
        comingList = waitPlayBean.getData().getComing();
        Log.e("WAIT", "comingList===" + comingList.size());
    }
}
