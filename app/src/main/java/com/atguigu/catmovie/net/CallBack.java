package com.atguigu.catmovie.net;

/**
 * 自定义请求网络回调
 */
public abstract class CallBack {
    public abstract void onError(Exception e);

    public abstract void onSuccess(String response, int id);
}
