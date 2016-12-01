package com.atguigu.catmovie.utils;

import com.atguigu.catmovie.movie.adapter.StickyExampleModel;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {
  public static final int MODEL_COUNT = 30;

  public static List<StickyExampleModel> getData() {
    List<StickyExampleModel> stickyExampleModels = new ArrayList<>();

//    for (int index = 0; index < MODEL_COUNT; index++) {
//      if (index < 1) {
//        stickyExampleModels.add(new StickyExampleModel("预告片推荐", "name" + index, "gender" + index, "profession" + index));
//      } else if (index < 2) {
//        stickyExampleModels.add(new StickyExampleModel("近期最受期待", "name" + index, "gender" + index, "profession" + index));
//      } else if (index < 15) {
//        stickyExampleModels.add(new StickyExampleModel("12月2日 周五", "name" + index, "gender" + index, "profession" + index));
//      }
////      else {
//          stickyExampleModels.add(new StickyExampleModel(
//                  "吸顶文本4", "name" + index, "gender" + index, "profession" + index));
//      }
//    }

    return stickyExampleModels;
  }
}
