package com.atguigu.catmovie;

import android.app.Application;
import android.content.Context;

import cn.smssdk.SMSSDK;

/**
 */
public class MyApplication extends Application {
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        SMSSDK.initSDK(this, "19b6aea0e4b21", "8b150d2cf8a01aacb5f0c14ce4038510");
    }

    public static Context getmContext() {
        return mContext;
    }
}
