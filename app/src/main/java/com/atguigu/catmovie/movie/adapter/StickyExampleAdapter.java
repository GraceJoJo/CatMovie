package com.atguigu.catmovie.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.movie.bean.RecentRespectBean;
import com.atguigu.catmovie.movie.bean.StickyExampleBean;
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.atguigu.catmovie.movie.bean.YugaoBean;
import com.atguigu.catmovie.ui.HorizontalListView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StickyExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static final int FIRST_STICKY_VIEW = 1;
    public static final int HAS_STICKY_VIEW = 2;
    public static final int NONE_STICKY_VIEW = 3;
    private static final String TAG = "WAIT";
    private final List<WaitPlayBean.DataBean.ComingBean> datas;
    private final YugaoBean yugaoBean;

    private Context context;
    private List<StickyExampleBean> stickyExampleBeans;
    private static final int TYPE1 = 0;
    private static final int TYPE2 = 1;
    private static final int TYPE3 = 2;
    private RecentRespectBean recentRespectBean;

    public StickyExampleAdapter(Context context, List<StickyExampleBean> recyclerViewModels, List<WaitPlayBean.DataBean.ComingBean> comingList, RecentRespectBean recentRespectBean,YugaoBean yugaoBean) {
        this.context = context;
        this.stickyExampleBeans = recyclerViewModels;
        this.datas = comingList;
        this.recentRespectBean = recentRespectBean;
        this.yugaoBean = yugaoBean;
    }



    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE1;
        }else if(position==1) {
            return TYPE2;
        }else {
            return TYPE3;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE1) {
            View itemView =  LayoutInflater.from(context).inflate(R.layout.item_waitplay_type1, parent, false);
            return new Type1Holder(itemView);
        }else if(viewType==TYPE2) {
            View itemView2 =  LayoutInflater.from(context).inflate(R.layout.item_waitplay_type2, parent, false);
            return new Type2Holder(itemView2);
        }else if(viewType==TYPE3) {
            View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
            return new TickyHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (getItemViewType(position)==TYPE3) {
            TickyHolder tickyholder = (TickyHolder) viewHolder;

//      public String movieName;//电影名称
//      public int wish;//1110人想看
//      public String desc;//描述
//      public String star;//演员
//      public String imageUrl;//宣传图片

            StickyExampleBean stickyExampleBean = stickyExampleBeans.get(position);
            tickyholder.tv_movieName.setText(stickyExampleBean.movieName);
            tickyholder.tv_star_name.setText(stickyExampleBean.star);
            if (stickyExampleBean.desc.length() >= 12) {
                tickyholder.movie_desc.setText(stickyExampleBean.desc.substring(1, 12) + "...");
            } else {
                tickyholder.movie_desc.setText(stickyExampleBean.desc);
            }

            boolean preshow = stickyExampleBean.preshow;
            Log.e("TAG", " stickyExampleBean.preshow==================" + stickyExampleBean.preshow);
            //判断是否预售
            if (preshow) {
                tickyholder.buy_tickt.setVisibility(View.VISIBLE);
                tickyholder.xiang_kan.setVisibility(View.GONE);

            } else {
                tickyholder.buy_tickt.setVisibility(View.GONE);
                tickyholder.xiang_kan.setVisibility(View.VISIBLE);

            }
            tickyholder.tv_wish.setText(stickyExampleBean.wish + "");

//      Log.e("TAG", "stickyExampleBean===============111111111" + stickyExampleBean.toString());
            if (!TextUtils.isEmpty(stickyExampleBean.imageUrl)) {
                Picasso.with(context).load(stickyExampleBean.imageUrl).into(tickyholder.iv_movie_icon);
            }

            if (position == 0) {
                tickyholder.tvStickyHeader.setVisibility(View.VISIBLE);
                tickyholder.tvStickyHeader.setText(stickyExampleBean.sticky);
                tickyholder.itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                //说明前面至少有一个悬浮头了，也就是当前悬浮着的位置是0以后的位置
                if (!TextUtils.equals(stickyExampleBean.sticky, stickyExampleBeans.get(position - 1).sticky)) {
                    tickyholder.tvStickyHeader.setVisibility(View.VISIBLE);
                    tickyholder.tvStickyHeader.setText(stickyExampleBean.sticky);
                    tickyholder.itemView.setTag(HAS_STICKY_VIEW);
                } else {
                    tickyholder.tvStickyHeader.setVisibility(View.GONE);
                    tickyholder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }
            tickyholder.itemView.setContentDescription(stickyExampleBean.sticky);
        }else if(getItemViewType(position)==TYPE2) {
            StickyExampleBean stickyExampleBean = stickyExampleBeans.get(position);
            Type2Holder type2Holder = (Type2Holder)viewHolder;
            type2Holder.setData(recentRespectBean);

            if (position == 0) {
                type2Holder.tvStickyHeader.setVisibility(View.VISIBLE);
                type2Holder.tvStickyHeader.setText(stickyExampleBean.sticky);
                type2Holder.itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                //说明前面至少有一个悬浮头了，也就是当前悬浮着的位置是0以后的位置
                if (!TextUtils.equals(stickyExampleBean.sticky, stickyExampleBeans.get(position - 1).sticky)) {
                    type2Holder.tvStickyHeader.setVisibility(View.VISIBLE);
                    type2Holder.tvStickyHeader.setText(stickyExampleBean.sticky);
                    type2Holder.itemView.setTag(HAS_STICKY_VIEW);
                } else {
                    type2Holder.tvStickyHeader.setVisibility(View.GONE);
                    type2Holder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }
            type2Holder.itemView.setContentDescription(stickyExampleBean.sticky);
        }else if(getItemViewType(position)==TYPE1) {
            StickyExampleBean stickyExampleBean = stickyExampleBeans.get(position);
            Type1Holder type1Holder = (Type1Holder)viewHolder;
            type1Holder.setData(yugaoBean);

            if (position == 0) {
                type1Holder.tvStickyHeader.setVisibility(View.VISIBLE);
                type1Holder.tvStickyHeader.setText(stickyExampleBean.sticky);
                type1Holder.itemView.setTag(FIRST_STICKY_VIEW);
            } else {
                //说明前面至少有一个悬浮头了，也就是当前悬浮着的位置是0以后的位置
                if (!TextUtils.equals(stickyExampleBean.sticky, stickyExampleBeans.get(position - 1).sticky)) {
                    type1Holder.tvStickyHeader.setVisibility(View.VISIBLE);
                    type1Holder.tvStickyHeader.setText(stickyExampleBean.sticky);
                    type1Holder.itemView.setTag(HAS_STICKY_VIEW);
                } else {
                    type1Holder.tvStickyHeader.setVisibility(View.GONE);
                    type1Holder.itemView.setTag(NONE_STICKY_VIEW);
                }
            }
            type1Holder.itemView.setContentDescription(stickyExampleBean.sticky);
        }
    }

    @Override
    public int getItemCount() {
        return stickyExampleBeans == null ? 0 : stickyExampleBeans.size();
    }

    public class TickyHolder extends RecyclerView.ViewHolder {
        public TextView tvStickyHeader;
        public RelativeLayout rlContentWrapper;

        public TextView tv_movieName;
        public TextView movie_desc;
        public TextView tv_wish;
        public TextView buy_tickt;
        public TextView xiang_kan;
        public TextView tv_star_name;
        public ImageView iv_movie_icon;


//    public String sticky;//悬浮头
//
//    public String movieName;//电影名称
//    public int wish;//1110人想看
//    public String scm;//描述
//    public String star;//演员
//    public String imageUrl;//宣传图片

        public TickyHolder(View itemView) {
            super(itemView);

            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_headview);
            rlContentWrapper = (RelativeLayout) itemView.findViewById(R.id.rl_content_wrapper);

            iv_movie_icon = (ImageView) itemView.findViewById(R.id.iv_movie_icon);
            tv_movieName = (TextView) itemView.findViewById(R.id.movie_name);
            tv_wish = (TextView) itemView.findViewById(R.id.tv_wish);
            xiang_kan = (TextView) itemView.findViewById(R.id.xiang_kan);
            movie_desc = (TextView) itemView.findViewById(R.id.movie_desc);
            buy_tickt = (TextView) itemView.findViewById(R.id.buy_ticket);
            tv_star_name = (TextView) itemView.findViewById(R.id.tv_star_name);
        }
    }

    private class Type1Holder extends RecyclerView.ViewHolder {

        private final HorizontalListView horizontallistview_type1;
        private final TextView tvStickyHeader;

        public Type1Holder(View itemView) {
            super(itemView);
            horizontallistview_type1 = (HorizontalListView) itemView.findViewById(R.id.horizontallistview_type1);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_headview);

        }

        public void setData(YugaoBean yugaoBean) {
            horizontallistview_type1.setAdapter(new WaitHorizantalListViewAdapter1(context,yugaoBean));
        }
    }
    //近期最受期待
    private class Type2Holder extends RecyclerView.ViewHolder {

        private final HorizontalListView horizontallistview_type1;
        private final TextView tvStickyHeader;

        public Type2Holder(View itemView) {
            super(itemView);
            horizontallistview_type1 = (HorizontalListView) itemView.findViewById(R.id.horizontallistview_type2);
            tvStickyHeader = (TextView) itemView.findViewById(R.id.tv_headview);

        }

        public void setData(RecentRespectBean recentRespectBean) {

            horizontallistview_type1.setAdapter(new WaitHorizantalListViewAdapter2(context, recentRespectBean));
        }
    }
}
