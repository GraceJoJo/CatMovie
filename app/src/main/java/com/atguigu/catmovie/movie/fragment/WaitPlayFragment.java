package com.atguigu.catmovie.movie.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.MyApplication;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseViewPagerFragment;
import com.atguigu.catmovie.movie.adapter.StickyExampleAdapter;
import com.atguigu.catmovie.movie.bean.RecentRespectBean;
import com.atguigu.catmovie.movie.bean.StickyExampleBean;
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.atguigu.catmovie.movie.bean.YugaoBean;
import com.atguigu.catmovie.movie.utils.StringUitls;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.atguigu.catmovie.utils.SpUtil;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 电影--待映--页面
 */
public class WaitPlayFragment extends BaseViewPagerFragment implements View.OnClickListener {

    private static final String TAG = "WAIT";
    @Bind(R.id.et_search_center)
    EditText etSearchCenter;
    @Bind(R.id.ll_search_center)
    LinearLayout llSearchCenter;
    @Bind(R.id.tv_headview)
    TextView tvHeadview;
    @Bind(R.id.fl_movie_waitplay)
    FrameLayout flMovieWaitplay;
    @Bind(R.id.click_refresh)
    TextView clickRefresh;
    @Bind(R.id.rl_error_common)
    RelativeLayout rlErrorCommon;
    @Bind(R.id.rl_loading_common)
    RelativeLayout rlLoadingCommon;
    private View view;
    private TextView tv_headview;
    private RecyclerView recycleview;
    private List<WaitPlayBean.DataBean.ComingBean> comingList;
    private RecentRespectBean recentRespectBean;
    private YugaoBean yugaoBean;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_movie_waitplay, null);
        ButterKnife.bind(this, view);
        initRecyclerView();
        return view;
    }

    @Override
    public void initData() {

        rlLoadingCommon.setVisibility(View.VISIBLE);
        rlErrorCommon.setVisibility(View.GONE);
        getDataFromNet();
        initListener();
    }

    //延迟加载
    @Override
    protected void lazyLoad() {

    }

    private void initListener() {
        clickRefresh.setOnClickListener(this);
    }

    private void initRecyclerView() {
        recycleview = (RecyclerView) view.findViewById(R.id.recycleview);
        tv_headview = (TextView) view.findViewById(R.id.tv_headview);

        assert recycleview != null;
        assert tv_headview != null;


        recycleview.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                // Get the sticky information from the topmost view of the screen.
                View stickyInfoView = recyclerView.findChildViewUnder(
                        tv_headview.getMeasuredWidth() / 2, 5);

                if (stickyInfoView != null && stickyInfoView.getContentDescription() != null) {
                    tv_headview.setText(String.valueOf(stickyInfoView.getContentDescription()));
                }

                // Get the sticky view's translationY by the first view below the sticky's height.
                View transInfoView = recyclerView.findChildViewUnder(
                        tv_headview.getMeasuredWidth() / 2, tv_headview.getMeasuredHeight() + 1);

                if (transInfoView != null && transInfoView.getTag() != null) {
                    int transViewStatus = (int) transInfoView.getTag();
                    int dealtY = transInfoView.getTop() - tv_headview.getMeasuredHeight();
                    // If the first view below the sticky's height scroll off the screen,
                    // then recovery the sticky view's translationY.
                    if (transViewStatus == StickyExampleAdapter.HAS_STICKY_VIEW) {
                        if (transInfoView.getTop() > 0) {//设置跟随滑动平移
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
                        rlErrorCommon.setVisibility(View.VISIBLE);
                        rlLoadingCommon.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    rlLoadingCommon.setVisibility(View.GONE);
                                    Log.e("WAIT", "待映页面--联网成功");
                                    Log.e("TAG", "待映页面--Json==" + response);
                                    processJson(response);
                                    recycleview.setLayoutManager(new LinearLayoutManager(mContext));
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            if (comingList != null && comingList.size() > 0 && recentRespectBean != null & recentRespectBean.getData().getComing().size() > 0 && yugaoBean != null && yugaoBean.getData().size() > 0) {
                                                recycleview.setAdapter(new StickyExampleAdapter(mContext, getData(), comingList, recentRespectBean, yugaoBean));
                                            }
                                        }
                                    }, 5000);
//
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
        //近期最受期待
        RequestNet
                .get()
                .url(ConstantsUtils.HOT_WAIT_RECENT_RESPECT, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
//                        rlErrorCommon.setVisibility(View.VISIBLE);
//                        rlLoadingCommon.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    rlLoadingCommon.setVisibility(View.GONE);
                                    Log.e(TAG, "待映页面近期最受期待--联网成功");
                                    Log.e(TAG, "待映页面近期最受期待----response======" + response);
                                    processRespectJson(response);
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });

        //预告片
        RequestNet
                .get()
                .url(ConstantsUtils.HOT_WAIT_YUGAO, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲,没网了", Toast.LENGTH_SHORT).show();
//                        rlErrorCommon.setVisibility(View.VISIBLE);
//                        rlLoadingCommon.setVisibility(View.GONE);
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    rlLoadingCommon.setVisibility(View.GONE);
                                    Log.e(TAG, "预告--联网成功");
                                    Log.e(TAG, "预告----response======" + response);
                                    processYugaoJson(response);
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });

    }


    private void processYugaoJson(String json) {
        Gson gson = new Gson();
        yugaoBean = gson.fromJson(json, YugaoBean.class);
        Log.e(TAG, "预告" + yugaoBean.getData().size() + "");
    }

    private void processRespectJson(String json) {
        Gson gson = new Gson();
        recentRespectBean = gson.fromJson(json, RecentRespectBean.class);
        //近期最受期待的集合数据
        Log.e(TAG, "recentRespectBean==" + recentRespectBean.getData().getComing().size());
        SpUtil.getInstance(MyApplication.getmContext()).save("respect", json);
    }


    public List<StickyExampleBean> getData() {
        List<StickyExampleBean> stickyExampleBeans = new ArrayList<>();
        String constantsUrl = "http://p0.meituan.net/165.220/movie/f2820b28cff46c530a1aee47a2c00011274783.jpg";
        for (int index = 0; index < 30; index++) {
            if (index == 0) {
                stickyExampleBeans.add(new StickyExampleBean("预告片推荐", "电影" + index, "000", "", "", constantsUrl, false));
            } else if (index == 1) {
                stickyExampleBeans.add(new StickyExampleBean("近期最受期待", "电影" + index, "000", "", "", constantsUrl, false));
            } else if (index < comingList.size() + 2) {
                //设置一个死的图片路径

                WaitPlayBean.DataBean.ComingBean comingBean = comingList.get(index - 2);
//                Log.e("TAG", "imageUrls==" + comingBean.getImg());
                stickyExampleBeans.add(new StickyExampleBean(comingBean.getComingTitle(), comingBean.getNm(),
                        comingBean.getWish() + "", comingBean.getDesc(), comingBean.getStar(), StringUitls.parseImageUrl(comingBean.getImg()), comingBean.isPreShow()));
            }
//      else
//          stickyExampleBeans.add(new StickyExampleBean(
//                  "吸顶文本4", "name" + index, "gender" + index, "profession" + index));
//      }
        }

        return stickyExampleBeans;
    }

    private void processJson(String json) {
        Gson gson = new Gson();
        WaitPlayBean waitPlayBean = gson.fromJson(json, WaitPlayBean.class);
        comingList = waitPlayBean.getData().getComing();
        Log.e("WAIT", "comingList===" + comingList.size());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.click_refresh:
                getDataFromNet();
                rlErrorCommon.setVisibility(View.GONE);
                rlLoadingCommon.setVisibility(View.VISIBLE);
                Toast.makeText(getActivity(), "刷新", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
