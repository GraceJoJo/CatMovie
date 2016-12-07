package com.atguigu.catmovie.find.shopmall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.find.shopmall.bean.ShopMallList;
import com.atguigu.catmovie.find.shopmall.bean.TeJiaBean;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 商城的适配器
 */
public class ShopMallAdapter extends RecyclerView.Adapter {

    private static final int BANNER = 1;//Banner
    private static final int CAHNNER = 2;//频道
    private static final int SELL = 3;//每月特价
    private static final int NORMAL = 4;//正常情况的item
    private final Context mContext;
    private final List<ShopMallList.DataBean.ListBean> datas;//你可能喜欢的数据
    private final List<TeJiaBean.DataBean.ListBean> goodsList;
    private List<String> imageUrls;

    public ShopMallAdapter(Context context, List<String> imageUrls, List<ShopMallList.DataBean.ListBean> datas, List<TeJiaBean.DataBean.ListBean> goodsList) {
        this.mContext = context;
        this.imageUrls = imageUrls;
        this.datas = datas;
        this.goodsList = goodsList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BANNER;
        } else if (position == 1) {
            return CAHNNER;
        } else if (position == 2 || position == 3) {
            return SELL;
        } else {
            return NORMAL;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BANNER) {
            View itemView = View.inflate(mContext, R.layout.item_banner, null);
            return new BannerHodler(itemView);
        } else if (viewType == CAHNNER) {
            View itemView = View.inflate(mContext, R.layout.item_channal, null);
            return new ChannelHolder(itemView);
        } else if (viewType == SELL) {
            View itemView = View.inflate(mContext, R.layout.item_sell, null);
            return new SellHolder(itemView);
        } else if (viewType == NORMAL) {
            View itemView = View.inflate(mContext, R.layout.item_normal, null);
            return new NormalHolder(itemView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == BANNER) {
            BannerHodler bannerHodler = (BannerHodler) holder;
            bannerHodler.setData(imageUrls);
        } else if (itemViewType == CAHNNER) {
            ChannelHolder channelHolder = (ChannelHolder) holder;
            channelHolder.setData();
        } else if (itemViewType == SELL) {
            SellHolder sellHolder = (SellHolder) holder;
            sellHolder.setData(goodsList,position);
        } else if (itemViewType == NORMAL) {
            NormalHolder normalHolder = (NormalHolder) holder;
            normalHolder.setData(datas, position);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size() + 4;
    }


    private class BannerHodler extends RecyclerView.ViewHolder {

        private final Banner banner;

        public BannerHodler(View itemView) {
            super(itemView);
            banner = (Banner) itemView.findViewById(R.id.banner);
        }

        public void setData(List<String> imageUrls) {
            setBannerStyle(imageUrls);
        }

        private void setBannerStyle(List<String> imageUrls) {
            Log.e("TAG", "imageUrls.size==" + imageUrls.get(0).toString() + "dfwed" + imageUrls.size());
            //（1）设置banner的样式
            banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //（2）设置图片加载器
            banner.setImageLoader(new GlideImageLoader());
            //（4）设置图片集合与banner关联
            banner.setImages(imageUrls);
            //（5）设置动画效果
            banner.setBannerAnimation(Transformer.Default);
            //（7）设置自动轮播
            banner.isAutoPlay(true);
            //（8）设置轮播时间
            banner.setDelayTime(2000);
            //（9）设置指示器位置(当banner模式中有指示器时)
            banner.setIndicatorGravity(BannerConfig.RIGHT);
            //（10）banner设置方法全部调用完毕时最后调用
            banner.start();
        }

        public class GlideImageLoader extends ImageLoader {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                //使用Picasso加载图片
                Picasso.with(context).load((String) path).into(imageView);
            }
        }

    }

    class ChannelHolder extends RecyclerView.ViewHolder {
        public String[] SHOOP_TYPE = {"数码", "高玩专区", "玩具", "生活", "服饰", "超蝙", "机器猫", "魔兽", "美队", "星球大战"};
        public int[] SHOOP_TUPIAN = {R.drawable.a01, R.drawable.a02, R.drawable.a03, R.drawable.a04, R.drawable.a05, R.drawable.a06, R.drawable.a077, R.drawable.a08, R.drawable.a09, R.drawable.a10,};
        private final GridView gridview;

        public ChannelHolder(View itemView) {
            super(itemView);
            gridview = (GridView) itemView.findViewById(R.id.gridview);
        }

        public void setData() {
            gridview.setAdapter(new ChannelAdapter(mContext, SHOOP_TYPE, SHOOP_TUPIAN));
        }
    }


    class SellHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_name1)
        TextView tvName1;
        @Bind(R.id.tv_desc1)
        TextView tvDesc1;
        @Bind(R.id.iv_icon1)
        ImageView ivIcon1;
        @Bind(R.id.tv_name2)
        TextView tvName2;
        @Bind(R.id.tv_desc2)
        TextView tvDesc2;
        @Bind(R.id.iv_icon2)
        ImageView ivIcon2;
        @Bind(R.id.tv_name3)
        TextView tvName3;
        @Bind(R.id.tv_desc3)
        TextView tvDesc3;
        @Bind(R.id.iv_icon3)
        ImageView ivIcon3;
        public SellHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }

        public void setData(List<TeJiaBean.DataBean.ListBean> goodsList, int position) {
            position = position-2;
            List<TeJiaBean.DataBean.ListBean.GoodsBean> goods1 = goodsList.get(0).getGoods();
            List<TeJiaBean.DataBean.ListBean.GoodsBean> goods2 = goodsList.get(1).getGoods();
            List<TeJiaBean.DataBean.ListBean.GoodsBean> goods3= goodsList.get(2).getGoods();

            TeJiaBean.DataBean.ListBean.GoodsBean goodsBean1 = goods1.get(position);
            TeJiaBean.DataBean.ListBean.GoodsBean goodsBean2 = goods2.get(position);
            TeJiaBean.DataBean.ListBean.GoodsBean goodsBean3 = goods3.get(position);
            tvName1.setText(goodsBean1.getTitle());
            tvDesc1.setText(goodsBean1.getDesc());
            Picasso.with(mContext).load(goodsBean1.getPic()).into(ivIcon1);

            tvName2.setText(goodsBean2.getTitle());
            tvDesc2.setText(goodsBean2.getDesc());
            Picasso.with(mContext).load(goodsBean2.getPic()).into(ivIcon2);

            tvName3.setText(goodsBean3.getTitle());
            tvDesc3.setText(goodsBean3.getDesc());
            Picasso.with(mContext).load(goodsBean1.getPic()).into(ivIcon3);
        }
    }

    class NormalHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.iv_image)
        ImageView ivImage;
        @Bind(R.id.tv_name)
        TextView tvName;
        @Bind(R.id.tv_price)
        TextView tvPrice;

        public NormalHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        public void setData(List<ShopMallList.DataBean.ListBean> datas, int position) {
            position = position - 4;
            ShopMallList.DataBean.ListBean listBean = datas.get(position);
            tvName.setText(listBean.getTitle());
            tvPrice.setText(listBean.getPrice()+"元");
            Picasso.with(mContext).load(listBean.getPic()).into(ivImage);
        }
    }
}
