package com.atguigu.catmovie.net;


import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

/**
 * 二次封装okhttputils
 */
public class RequestNet {

    private static  String url;
    private static RequestNet requestNet = new RequestNet(url);
    public RequestNet(String url){
        this.url = url;
    }

    public static RequestNet get() {
        return requestNet;
    }

    public static  void url(String url,CallBack callBack) {
        OkHttpUtils
                .get()
                .url(url)
                .id(100)
                .build()
                .execute(new MyStringCallback(callBack));
    }
     static class MyStringCallback extends StringCallback {

         private final CallBack callBack;

         public  MyStringCallback(CallBack callBack){
            this.callBack = callBack;
        }

         @Override
         public void onError(okhttp3.Call call, Exception e, int id) {
             callBack.onError(e);
         }

         @Override
         public void onResponse(String response, int id) {

            switch (id) {
                case 100 :
                    callBack.onSuccess(response,id);
                    break;
                case 101:
                    break;
            }

         }
    }

}
