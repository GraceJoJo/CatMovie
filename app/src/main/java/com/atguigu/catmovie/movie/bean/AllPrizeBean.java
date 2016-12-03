package com.atguigu.catmovie.movie.bean;

import java.util.List;

/**
 * 全部处理成字符串了
 */
public class AllPrizeBean {

    /**
     * festSessionId : 3510
     * festivalId : 108
     * festivalName : 欧洲电影奖
     * heldDate : 2016-12-10
     * img : http://p1.meituan.net/w.h/movie/5287354626e5dbc991753599fb09ba7e90753.jpg
     * movieId : 337359
     * movieName : 她
     * prizeName : 最佳影片(提名)
     * sessionNum : 29
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String festSessionId;
        private String festivalId;
        private String festivalName;
        private String heldDate;
        private String img;
        private String movieId;
        private String movieName;
        private String prizeName;
        private String sessionNum;

        public String getFestSessionId() {
            return festSessionId;
        }

        public void setFestSessionId(String festSessionId) {
            this.festSessionId = festSessionId;
        }

        public String getFestivalId() {
            return festivalId;
        }

        public void setFestivalId(String festivalId) {
            this.festivalId = festivalId;
        }

        public String getFestivalName() {
            return festivalName;
        }

        public void setFestivalName(String festivalName) {
            this.festivalName = festivalName;
        }

        public String getHeldDate() {
            return heldDate;
        }

        public void setHeldDate(String heldDate) {
            this.heldDate = heldDate;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getMovieId() {
            return movieId;
        }

        public void setMovieId(String movieId) {
            this.movieId = movieId;
        }

        public String getMovieName() {
            return movieName;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public String getPrizeName() {
            return prizeName;
        }

        public void setPrizeName(String prizeName) {
            this.prizeName = prizeName;
        }

        public String getSessionNum() {
            return sessionNum;
        }

        public void setSessionNum(String sessionNum) {
            this.sessionNum = sessionNum;
        }
    }
}
