package com.atguigu.catmovie.movie.adapter;

public class StickyExampleModel {
  public String sticky;//悬浮头

  public String movieName;//电影名称
  public int wish;//1110人想看
  public String desc;//描述
  public String star;//演员
  public String imageUrl;//宣传图片

  public StickyExampleModel(String sticky, String movieName, int wish, String desc, String star, String imageUrl) {
    this.sticky = sticky;
    this.movieName = movieName;
    this.wish = wish;
    this.desc = desc;
    this.star = star;
    this.imageUrl = imageUrl;
  }

  @Override
  public String toString() {
    return "StickyExampleModel{" +
            "sticky='" + sticky + '\'' +
            ", movieName='" + movieName + '\'' +
            ", wish=" + wish +
            ", desc='" + desc + '\'' +
            ", star='" + star + '\'' +
            ", imageUrl='" + imageUrl + '\'' +
            '}';
  }
}
