package com.atguigu.catmovie.find;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.find.adapter.FindRecyclerViewAdapter;
import com.atguigu.catmovie.find.bean.HeadBean;
import com.atguigu.catmovie.find.adapter.HeadGridViewAdapter;
import com.atguigu.catmovie.find.bean.ListBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.google.gson.Gson;

import butterknife.ButterKnife;

/**
 * 发现页面
 */
public class FindFragment extends BaseFragment {
    private static final String TAG = "find";
    private HeadGridViewAdapter headGridViewAdapter;
    private HeadBean headBean;
    private MaterialRefreshLayout refresh;
    private View view;
    private RecyclerView find_recycleview;
    private FindRecyclerViewAdapter adapter;
    private ListBean listBean;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_find, null);
        find_recycleview = (RecyclerView) view.findViewById(R.id.find_recycleview);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        getHeadData();
        getListData(getUrl(0));
        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 1, LinearLayoutManager.VERTICAL, false);
        find_recycleview.setLayoutManager(manager);
        adapter = new FindRecyclerViewAdapter(getActivity());
        find_recycleview.setAdapter(adapter);

        initRefresh();

    }

    private void getListData(String url) {
        RequestNet
                .url(url, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("TAG", "发现页面List联网失败");
                        refresh.finishRefresh();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    Log.e("TAG", "发现List页面联网成功" + response);
                                    listBean = new Gson().fromJson(response, ListBean.class);
                                    refresh.finishRefresh();
                                    adapter.refreshList(listBean);
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }

    /**
     * 请求--第一种类型的数据
     */
    private void getHeadData() {
        RequestNet
                .url(ConstantsUtils.FIND_HEAD_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("TAG", "发现页面联网失败");
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    Log.e("TAG", "发现页面联网成功" + response);
                                    headBean = new Gson().fromJson(response, HeadBean.class);
                                    adapter.refreshHead(headBean.getData());
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
    }


    private void initRefresh() {
        refresh = (MaterialRefreshLayout) view.findViewById(R.id.materialrefreshlayout);//刷新
        refresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            /**
             * 下拉刷新
             */
            @Override
            public void onRefresh(final MaterialRefreshLayout materialRefreshLayout) {
                curPage = 0;
                String url = getUrl(curPage);
                getListData(url);
            }

            /**
             * 上拉刷新（加载更多）
             * @param materialRefreshLayout
             */
            @Override
            public void onRefreshLoadMore(final MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);
                loadMoreData();
            }
        });
    }

    private int curPage;

    private void loadMoreData() {
        boolean hasMore = listBean.getData().getPaging().isHasMore();
        if (hasMore) {
            curPage = curPage + 10;
            String url = getUrl(curPage);
            getMoreFromNet(url);
        }
    }



    @NonNull
    private String getUrl(int page) {
        return ConstantsUtils.FIND_LIST_URL + "offset=" + page + "&limit=10";
    }

    private void getMoreFromNet(final String url) {
        RequestNet
                .url(url, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Log.e("TAG", "发现页面List联网失败");
                        refresh.finishRefreshLoadMore();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        Log.e("TAG", "66666666666666666" + url);
                        switch (id) {
                            case 100:
                                if (response != null) {
                                    Log.e("TAG", "发现List页面联网成功" + response);
                                    ListBean listBean = new Gson().fromJson(response, ListBean.class);
                                    Log.e("TAG", "listBean==" + listBean.getData().getFeeds().get(0).getTitle());
                                    refresh.finishRefreshLoadMore();
                                    adapter.refreshListMore(listBean);
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
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
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
