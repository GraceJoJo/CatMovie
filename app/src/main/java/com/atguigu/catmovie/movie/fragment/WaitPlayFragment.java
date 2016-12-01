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
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.atguigu.catmovie.utils.DataUtil;
import com.google.gson.Gson;

import java.util.List;

/**
 * 电影--待映--页面
 */
public class WaitPlayFragment extends BaseFragment {

    private TextView textView;
    private View view;

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
        RecyclerView recycleview = (RecyclerView)view.findViewById(R.id.recycleview);
        final TextView tv_headview = (TextView)view.findViewById(R.id.tv_headview);

        assert recycleview != null;
        assert tv_headview != null;

        recycleview.setLayoutManager(new LinearLayoutManager(mContext));
        recycleview.setAdapter(new StickyExampleAdapter(mContext, DataUtil.getData()));
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
                                    Log.e("TAG", "待映页面--Json=="+response);
                                    processJson(response);
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }

    private void processJson(String json) {
        Gson gson = new Gson();
        WaitPlayBean waitPlayBean = gson.fromJson(json, WaitPlayBean.class);
        List<WaitPlayBean.DataBean.ComingBean> comingList = waitPlayBean.getData().getComing();
        Log.e("WAIT", "comingList==="+comingList.size());
    }
}
