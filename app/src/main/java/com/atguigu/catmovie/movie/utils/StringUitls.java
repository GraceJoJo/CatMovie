package com.atguigu.catmovie.movie.utils;

/**
 * Created by Administrator on 2016/12/2.
 */
public class StringUitls {
//    "http://p0.meituan.net/w.h/movie/c8f8e7c3af8c5792d80c958cca13b61a500299.jpg"
    public static String parseImageUrl(String imageUrl){
        String newUrl = imageUrl.replace("w.h", "200.200");
        return newUrl;
    }
}
