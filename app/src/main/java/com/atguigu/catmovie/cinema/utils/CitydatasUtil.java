package com.atguigu.catmovie.cinema.utils;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.atguigu.catmovie.cinema.adapter.CinemaAdapter;
import com.atguigu.catmovie.cinema.bean.CinemaBean;
import com.atguigu.catmovie.cinema.bean.ItemBean;
import com.atguigu.catmovie.net.CallBack;
import com.atguigu.catmovie.net.RequestNet;
import com.atguigu.catmovie.utils.ConstantsUtils;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * 影院--联网请求数据
 */
public class CitydatasUtil {

    private  Context context;
    private CinemaBean cinemaBean;
    private List<ItemBean> datas;
    private CinemaAdapter adapter;
    public CitydatasUtil(Context context,CinemaAdapter adapter) {
        this.context = context;
        this.adapter = adapter;

        getDataFromNet();
    }

    private   void getDataFromNet() {
        RequestNet
                .get()
                .url(ConstantsUtils.CINIMA_URL, new CallBack() {
                    @Override
                    public void onError(Exception e) {
                        Toast.makeText(context, "亲,没网了", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(String response, int id) {
                        switch (id) {
                            case 100:
                                if (response != null) {
//                                    rl_loading_common.setVisibility(View.GONE);
                                    Log.e("TTT", "影院---联网成功--" + response);
                                    parseJson(response);
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
        Log.e("TTT", "TTTTTTTTTTT" + cinemaBean.getData().get昌平区().toString() + "");
        getData();
        Log.e("TAG", "itembean====222222222" + datas.get(0).getAddr());
    }

    public void getData() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get昌平区().size(); i++) {
            String addr = cinemaBean.getData().get昌平区().get(i).getAddr();
            String area = cinemaBean.getData().get昌平区().get(i).getArea();
            String nm = cinemaBean.getData().get昌平区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get昌平区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get昌平区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }

    //得到朝阳区数据
    public void getData1() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get朝阳区().size(); i++) {
            String addr = cinemaBean.getData().get朝阳区().get(i).getAddr();
            String area = cinemaBean.getData().get朝阳区().get(i).getArea();
            String nm = cinemaBean.getData().get朝阳区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get朝阳区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get朝阳区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }

    //得到海淀区数据
    public void getData2() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get海淀区().size(); i++) {
            String addr = cinemaBean.getData().get海淀区().get(i).getAddr();
            String area = cinemaBean.getData().get海淀区().get(i).getArea();
            String nm = cinemaBean.getData().get海淀区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get海淀区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get海淀区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }

    //得到丰台区数据
    public void getData3() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get丰台区().size(); i++) {
            String addr = cinemaBean.getData().get丰台区().get(i).getAddr();
            String area = cinemaBean.getData().get丰台区().get(i).getArea();
            String nm = cinemaBean.getData().get丰台区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get丰台区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get丰台区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }

    //得到大兴区数据
    public void getData4() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get大兴区().size(); i++) {
            String addr = cinemaBean.getData().get大兴区().get(i).getAddr();
            String area = cinemaBean.getData().get大兴区().get(i).getArea();
            String nm = cinemaBean.getData().get大兴区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get大兴区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get大兴区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
    //得到怀柔区数据
    public void getData5() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get怀柔区().size(); i++) {
            String addr = cinemaBean.getData().get怀柔区().get(i).getAddr();
            String area = cinemaBean.getData().get怀柔区().get(i).getArea();
            String nm = cinemaBean.getData().get怀柔区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get怀柔区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get怀柔区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
    //得到怀柔区数据
    public void getData6() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get石景山区().size(); i++) {
            String addr = cinemaBean.getData().get石景山区().get(i).getAddr();
            String area = cinemaBean.getData().get石景山区().get(i).getArea();
            String nm = cinemaBean.getData().get石景山区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get石景山区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get石景山区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
    //得到怀柔区数据
    public void getData7() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get平谷区().size(); i++) {
            String addr = cinemaBean.getData().get平谷区().get(i).getAddr();
            String area = cinemaBean.getData().get平谷区().get(i).getArea();
            String nm = cinemaBean.getData().get平谷区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get平谷区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get平谷区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
    //得到怀柔区数据
    public void getData8() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get西城区().size(); i++) {
            String addr = cinemaBean.getData().get西城区().get(i).getAddr();
            String area = cinemaBean.getData().get西城区().get(i).getArea();
            String nm = cinemaBean.getData().get西城区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get西城区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get西城区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
    //得到怀柔区数据
    public void getData9() {
        datas = new ArrayList<>();
        datas.clear();
        for (int i = 0; i < cinemaBean.getData().get顺义区().size(); i++) {
            String addr = cinemaBean.getData().get顺义区().get(i).getAddr();
            String area = cinemaBean.getData().get顺义区().get(i).getArea();
            String nm = cinemaBean.getData().get顺义区().get(i).getNm();
            boolean isSell = cinemaBean.getData().get顺义区().get(i).isSell();
            String sellPrice = cinemaBean.getData().get顺义区().get(i).getSellPrice();
            ItemBean itemBean = new ItemBean(addr, area, nm, isSell, sellPrice);
            datas.add(itemBean);
        }

        adapter.refresh(datas);
    }
}
