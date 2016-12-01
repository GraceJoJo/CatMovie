package com.atguigu.catmovie.movie.fragment;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * 电影--待映--页面
 */
public class WaitPlayFragment extends BaseFragment {

    private TextView textView;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_movie_waitplay, null);
        return view;
    }
    @Override
    public void initData() {

//        rl_loading_common.setVisibility(View.VISIBLE);
//        rl_error_common.setVisibility(View.GONE);
        getDataFromNet();
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
