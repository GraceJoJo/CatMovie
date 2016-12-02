package com.atguigu.catmovie.utils;

import com.atguigu.catmovie.movie.bean.StickyExampleBean;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
  public static final int MODEL_COUNT = 30;

  public static List<StickyExampleBean> getData() {
    List<StickyExampleBean> stickyExampleBeans = new ArrayList<>();

//    for (int index = 0; index < MODEL_COUNT; index++) {
//      if (index < 1) {
//        stickyExampleBeans.add(new StickyExampleBean("预告片推荐", "name" + index, "gender" + index, "profession" + index));
//      } else if (index < 2) {
//        stickyExampleBeans.add(new StickyExampleBean("近期最受期待", "name" + index, "gender" + index, "profession" + index));
//      } else if (index < 15) {
//        stickyExampleBeans.add(new StickyExampleBean("12月2日 周五", "name" + index, "gender" + index, "profession" + index));
//      }
////      else {
//          stickyExampleBeans.add(new StickyExampleBean(
//                  "吸顶文本4", "name" + index, "gender" + index, "profession" + index));
//      }
//    }

    return stickyExampleBeans;
  }
}
