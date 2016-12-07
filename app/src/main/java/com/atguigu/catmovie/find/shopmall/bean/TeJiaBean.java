package com.atguigu.catmovie.find.shopmall.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/12/7.
 */
public class TeJiaBean {

    /**
     * list : [{"goods":[{"desc":"我们终会相遇","pic":"http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg","title":"你的名字"},{"desc":"电影珍藏原著","pic":"http://p0.meituan.net/165.220/movie/eccf1862c4f30042a373a080acc18ccf9587819.jpeg","title":"佩小姐的奇幻城堡"},{"desc":"士兵有信仰，战场拒拿枪","pic":"http://p0.meituan.net/165.220/movie/8b22149c2cdf2fd57108f2a1718ae085464061.jpg","title":"血战钢锯岭"}]},{"goods":[{"desc":"冬升携老怪，千仗无一败","pic":"http://p0.meituan.net/165.220/movie/c3eaa8556346814f2a3a79ffef0924b4577174.jpg","title":"三少爷的剑"},{"desc":"五军战饕餮，中国魂不灭","pic":"http://p0.meituan.net/165.220/movie/e4a3447ebe8c44eea59ab7f68790c7e2179321.jpeg","title":"长城"},{"desc":"航海家后代，征程向大海","pic":"http://p1.meituan.net/165.220/movie/dd600d0f054b234402edc3a93cd21da7133550.jpeg","title":"海洋奇缘"}]},{"goods":[{"desc":"飞机遇意外，机长险被害","pic":"http://p1.meituan.net/165.220/movie/946e6e4182042c1e94feacb0dc93e7e3229652.jpg","title":"萨利机长"},{"desc":"快递藏国宝，爆笑接力跑","pic":"http://p0.meituan.net/165.220/movie/658b714699f37110db35e343474ccf12808915.png","title":"超级快递"},{"desc":"哭成小笨蛋，笑回长大前","pic":"http://p1.meituan.net/165.220/movie/f85de4d42c6fe3e958bd204fcb6a76f59235962.jpg","title":"28岁未成年"}]}]
     * total : 823
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String total;
        private List<ListBean> list;

        public String getTotal() {
            return total;
        }

        public void setTotal(String total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * desc : 我们终会相遇
             * pic : http://p0.meituan.net/165.220/movie/910b2e6c7cb0da947d65ef5c33929eb9366676.jpg
             * title : 你的名字
             */

            private List<GoodsBean> goods;

            public List<GoodsBean> getGoods() {
                return goods;
            }

            public void setGoods(List<GoodsBean> goods) {
                this.goods = goods;
            }

            public static class GoodsBean {
                private String desc;
                private String pic;
                private String title;

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPic() {
                    return pic;
                }

                public void setPic(String pic) {
                    this.pic = pic;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
