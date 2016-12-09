package com.atguigu.catmovie;

import android.app.Application;
import android.content.Context;

import cn.smssdk.SMSSDK;

/**
 */
public class MyApplication extends Application {
    public static Context mContext;
    private String WX_APP_ID = "wx19424d3a9c8ee316";

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        //初始化手机验证SDK
        SMSSDK.initSDK(this, "19b6aea0e4b21", "8b150d2cf8a01aacb5f0c14ce4038510");
    }

    public static Context getmContext() {
        return mContext;
    }

}
