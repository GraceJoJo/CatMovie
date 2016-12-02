package com.atguigu.catmovie;

import android.app.Application;
import android.content.Context;

/**
 */
public class MyApplication extends Application {
    public static  Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
       mContext = this;
    }

    public static Context getmContext() {
        return mContext;
    }
}
