package com.atguigu.catmovie.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.atguigu.catmovie.MyApplication;

/**
 * Created by Administrator on 2016/11/2.
 * 1. SpUtil工具类--SP存储
 */
public class SpUtil {
    private SpUtil() {

    }

    private static SpUtil instance = new SpUtil();
    private static SharedPreferences mSp = null;

    //对象-实例化
    //---------------------------注意点-------------------------
//    public static SpUtil getInstance(Context context){传入的上下文是一个Activity，容易导致内存泄漏。
    //所有在IMApplication中接收一个上下文
    public static SpUtil getInstance(Context context){
        if(mSp==null) {
            mSp = MyApplication.getmContext().getSharedPreferences("city", Context.MODE_PRIVATE);
        }
        return instance;
    }
    //保存
    public void save(String key,Object value){
        if(value instanceof String) {
            mSp.edit().putString(key, (String) value).commit();
        }else if(value instanceof Boolean) {
            mSp.edit().putBoolean(key, (Boolean) value).commit();
        }else if(value instanceof Integer) {
            mSp.edit().putInt(key, (Integer) value).commit();
        }
    }
    //读取--读取String类型数据
    public String getString(String key,String defValue){
        return mSp.getString(key,defValue);
    }
    //读取--读取boolean类型的数据
    public boolean getBoolean(String key,boolean defValue){
        return mSp.getBoolean(key, defValue);
    }
    //读取--读取int类型数据
    public int getInt(String key,int defValue){
        return mSp.getInt(key,defValue);
    }
}
