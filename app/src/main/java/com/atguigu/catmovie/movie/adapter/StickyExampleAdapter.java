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
import com.atguigu.catmovie.movie.bean.StickyExampleBean;
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StickyExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public static final int FIRST_STICKY_VIEW = 1;
  public static final int HAS_STICKY_VIEW = 2;
  public static final int NONE_STICKY_VIEW = 3;
  private final List<WaitPlayBean.DataBean.ComingBean> datas;

  private Context context;
  private List<StickyExampleBean> stickyExampleBeans;

  public StickyExampleAdapter(Context context, List<StickyExampleBean> recyclerViewModels, List<WaitPlayBean.DataBean.ComingBean> comingList) {
    this.context = context;
    this.stickyExampleBeans = recyclerViewModels;
    this.datas = comingList;
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false);
    return new RecyclerViewHolder(view);
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
    if (viewHolder instanceof RecyclerViewHolder) {
      RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) viewHolder;

//      public String movieName;//电影名称
//      public int wish;//1110人想看
//      public String desc;//描述
//      public String star;//演员
//      public String imageUrl;//宣传图片

      StickyExampleBean stickyExampleBean = stickyExampleBeans.get(position);
      recyclerViewHolder.tv_movieName.setText(stickyExampleBean.movieName);
      recyclerViewHolder.tv_star_name.setText(stickyExampleBean.star);
      if(stickyExampleBean.desc.length()>=12) {
        recyclerViewHolder.movie_desc.setText(stickyExampleBean.desc.substring(1,12)+"...");
      }else {
        recyclerViewHolder.movie_desc.setText(stickyExampleBean.desc);
      }

      boolean preshow = stickyExampleBean.preshow;
      Log.e("TAG", " stickyExampleBean.preshow=================="+ stickyExampleBean.preshow);
      //判断是否预售
      if(preshow) {
        recyclerViewHolder.buy_tickt.setVisibility(View.VISIBLE);
        recyclerViewHolder.xiang_kan.setVisibility(View.GONE);

      }else {
        recyclerViewHolder.buy_tickt.setVisibility(View.GONE);
        recyclerViewHolder.xiang_kan.setVisibility(View.VISIBLE);

      }
      recyclerViewHolder.tv_wish.setText(stickyExampleBean.wish+"");

//      Log.e("TAG", "stickyExampleBean===============111111111" + stickyExampleBean.toString());
      if(!TextUtils.isEmpty(stickyExampleBean.imageUrl)) {
        Picasso.with(context).load(stickyExampleBean.imageUrl).into(recyclerViewHolder.iv_movie_icon);
      }

      if (position == 0) {
        recyclerViewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
        recyclerViewHolder.tvStickyHeader.setText(stickyExampleBean.sticky);
        recyclerViewHolder.itemView.setTag(FIRST_STICKY_VIEW);
      } else {
        if (!TextUtils.equals(stickyExampleBean.sticky, stickyExampleBeans.get(position - 1).sticky)) {
          recyclerViewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
          recyclerViewHolder.tvStickyHeader.setText(stickyExampleBean.sticky);
          recyclerViewHolder.itemView.setTag(HAS_STICKY_VIEW);
        } else {
          recyclerViewHolder.tvStickyHeader.setVisibility(View.GONE);
          recyclerViewHolder.itemView.setTag(NONE_STICKY_VIEW);
        }
      }
      recyclerViewHolder.itemView.setContentDescription(stickyExampleBean.sticky);
    }
  }

  @Override
  public int getItemCount() {
    return stickyExampleBeans == null ? 0 : stickyExampleBeans.size();
  }

  public class RecyclerViewHolder extends RecyclerView.ViewHolder {
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

    public RecyclerViewHolder(View itemView) {
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
}
