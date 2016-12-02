package com.atguigu.catmovie.movie.bean;

public class StickyExampleBean {
    public String sticky;//悬浮头

    public String movieName;//电影名称
    public String wish;//1110人想看
    public String desc;//描述
    public String star;//演员
    public String imageUrl;//宣传图片
    public boolean preshow;//预售还是想看


    public StickyExampleBean(String sticky, String movieName, String wish, String desc, String star, String imageUrl, boolean preshow) {
        this.sticky = sticky;
        this.movieName = movieName;
        this.wish = wish;
        this.desc = desc;
        this.star = star;
        this.imageUrl = imageUrl;
        this.preshow = preshow;
    }

    @Override
    public String toString() {
        return "StickyExampleBean{" +
                "sticky='" + sticky + '\'' +
                ", movieName='" + movieName + '\'' +
                ", wish=" + wish +
                ", desc='" + desc + '\'' +
                ", star='" + star + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
