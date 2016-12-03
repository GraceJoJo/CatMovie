package com.atguigu.catmovie.movie.fragment;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.movie.adapter.AllprizeAdapter;
import com.atguigu.catmovie.movie.adapter.HorizontalListViewAdapter;
import com.atguigu.catmovie.movie.adapter.PrizeAdapter;
import com.atguigu.catmovie.movie.bean.AllPrizeBean;
import com.atguigu.catmovie.movie.bean.PrizeBean;
import com.atguigu.catmovie.movie.bean.TagBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.ui.HorizontalListView;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;

import java.util.List;

/**
 * 找片--页面--Fragment
 */
public class FindPlayFragment extends BaseFragment implements GestureDetector.OnGestureListener {
    private int TAG1;
    private int TAG2;
    private int TAG3;
    private HorizontalListViewAdapter hlva1;
    private HorizontalListViewAdapter hlva2;
    private HorizontalListViewAdapter hlva3;
    private HorizontalListView hlv1;
    private HorizontalListView hlv2;
    private HorizontalListView hlv3;
    private View view;
    private List<TagBean.DataBean.TagListBean> tagList1;
    private List<TagBean.DataBean.TagListBean> tagList2;
    private List<TagBean.DataBean.TagListBean> tagList3;
    private TagBean tagBean;
    private String type1;
    private String type2;
    private String type3;
    private GridView gridview_find;
    private PrizeBean prizeBean;
    private HorizontalListView horizontallistview_allprize;
    private AllPrizeBean allPrizeBean;

    @Override
    public View initView() {
        view = View.inflate(mContext, R.layout.fragment_movie_find, null);

        hlv1 = (HorizontalListView) view.findViewById(R.id.horizontallistview1);
        hlv2 = (HorizontalListView) view.findViewById(R.id.horizontallistview2);
        hlv3 = (HorizontalListView) view.findViewById(R.id.horizontallistview3);
        gridview_find = (GridView) view.findViewById(R.id.gridview_find);//热门口碑
        horizontallistview_allprize = (HorizontalListView) view.findViewById(R.id.horizontallistview_allprize);//全部电影奖项
        return view;
    }

    @Override
    public void initData() {

        getDataFromNet();

    }

    private void getDataFromNet() {
        /**
         * 标签页面请求
         */
        RequestNet
                .url(ConstantsUtils.TAG_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(getActivity(), "亲，没网了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    Log.e("TAG", "发现页面联网成功response==" + response);
//                                    rl_loading_common.setVisibility(View.GONE);
//                                    Log.e("TAG", "联网成功");

                                    processJson(response);
                                    if (tagBean.getData().size() > 0 && tagBean != null) {
                                        hlva1 = new HorizontalListViewAdapter(getActivity(), tagList1, type1);
                                        hlva2 = new HorizontalListViewAdapter(getActivity(), tagList2, type2);
                                        hlva3 = new HorizontalListViewAdapter(getActivity(), tagList3, type3);
                                        hlva1.notifyDataSetChanged();
                                        hlva2.notifyDataSetChanged();
                                        hlva3.notifyDataSetChanged();
                                        hlv1.setAdapter(hlva1);
                                        hlv2.setAdapter(hlva2);
                                        hlv3.setAdapter(hlva3);
                                    }
                                }
                                break;
                            case 101:
                                break;
                        }
                    }
                });
        /**
         *   奖项请求的URL--GridView
         */
        RequestNet.url(ConstantsUtils.PRIZE_URL, new CallBack() {
            @Override
            public void onError(Exception e) {
//                Log.e("TAG", "奖项请求的URL--");
                Toast.makeText(getActivity(), "亲，没网了", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(String response, int id) {
                switch (id) {
                    case 100:
                        if (response != null) {
//                            Log.e("TAG", "奖项请求联网成功response==" + response);
                            processPrizeJson(response);
                            gridview_find.setAdapter(new PrizeAdapter(prizeBean, getActivity()));
                        }
                        break;
                    case 101:
                        break;
                }
            }
        });
        /**
         * 全部奖项请求
         */
        RequestNet.url(ConstantsUtils.ALL_PRIZE_URL, new CallBack() {
            @Override
            public void onError(Exception e) {
                Log.e("TAG", "全部奖项请求联网失败response--");
            }

            @Override
            public void onSuccess(String response, int id) {
                switch (id) {
                    case 100:
                        if (response != null) {
                            Log.e("TAG", "全部奖项请求联网成功response==" + response);
                            processAllPrizeJson(response);
                            if (allPrizeBean != null && allPrizeBean.getData().size() > 0) {
                                horizontallistview_allprize.setAdapter(new AllprizeAdapter(getActivity(),allPrizeBean));
                            }
                        }
                        break;
                    case 101:
                        break;
                }
            }
        });

    }

    /**
     * 全部奖项--数据解析
     *
     * @param json
     */
    private void processAllPrizeJson(String json) {
        allPrizeBean = new Gson().fromJson(json, AllPrizeBean.class);
        Log.e("TAG", "allPrizeBean==" + allPrizeBean.getData().size());
    }

    /**
     * 奖项--数据解析
     *
     * @param json
     */
    private void processPrizeJson(String json) {
        prizeBean = new Gson().fromJson(json, PrizeBean.class);
    }

    private void processJson(String json) {
        tagBean = new Gson().fromJson(json, TagBean.class);
        tagList1 = tagBean.getData().get(0).getTagList();
        tagList2 = tagBean.getData().get(1).getTagList();
        tagList3 = tagBean.getData().get(2).getTagList();
        type1 = tagBean.getData().get(0).getTagTypeName();
        type2 = tagBean.getData().get(1).getTagTypeName();
        type3 = tagBean.getData().get(2).getTagTypeName();
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }
}
