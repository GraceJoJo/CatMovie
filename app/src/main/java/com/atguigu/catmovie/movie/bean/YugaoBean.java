package com.atguigu.catmovie.movie.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/4.
 */
public class YugaoBean {

    /**
     * img : http://p1.meituan.net/movie/2cefee086c9547481bf695760e9cd19a16661.jpg
     * movieId : 342003
     * movieName : 萨利机长
     * name : 《萨利机长》首发版预告片
     * originName : 首发版预告片
     * url : http://maoyan.meituan.net/movie/videos/854x480c2f837c07f724ae88f031898de40dadc.mp4
     * videoId : 81730
     * wish : 16523
     */

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String img;
        private String movieId;
        private String movieName;
        private String name;
        private String originName;
        private String url;
        private String videoId;
        private String wish;

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVideoId() {
            return videoId;
        }

        public void setVideoId(String videoId) {
            this.videoId = videoId;
        }

        public String getWish() {
            return wish;
        }

        public void setWish(String wish) {
            this.wish = wish;
        }
    }
}
