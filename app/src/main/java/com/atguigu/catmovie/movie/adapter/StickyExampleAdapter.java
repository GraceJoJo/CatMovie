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
import com.atguigu.catmovie.movie.bean.WaitPlayBean;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StickyExampleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
  public static final int FIRST_STICKY_VIEW = 1;
  public static final int HAS_STICKY_VIEW = 2;
  public static final int NONE_STICKY_VIEW = 3;
  private final List<WaitPlayBean.DataBean.ComingBean> datas;

  private Context context;
  private List<StickyExampleModel> stickyExampleModels;

  public StickyExampleAdapter(Context context, List<StickyExampleModel> recyclerViewModels, List<WaitPlayBean.DataBean.ComingBean> comingList) {
    this.context = context;
    this.stickyExampleModels = recyclerViewModels;
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

      StickyExampleModel stickyExampleModel = stickyExampleModels.get(position);
      recyclerViewHolder.tv_movieName.setText(stickyExampleModel.movieName);
      recyclerViewHolder.tv_star_name.setText(stickyExampleModel.star);
      recyclerViewHolder.tv_wish.setText(stickyExampleModel.wish+"");
      recyclerViewHolder.movie_desc.setText(stickyExampleModel.desc);
      Log.e("TAG", "stickyExampleModel===============111111111" + stickyExampleModel.toString());
      if(!TextUtils.isEmpty(stickyExampleModel.imageUrl)) {
        Picasso.with(context).load(stickyExampleModel.imageUrl).into(recyclerViewHolder.iv_movie_icon);
      }

      if (position == 0) {
        recyclerViewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
        recyclerViewHolder.tvStickyHeader.setText(stickyExampleModel.sticky);
        recyclerViewHolder.itemView.setTag(FIRST_STICKY_VIEW);
      } else {
        if (!TextUtils.equals(stickyExampleModel.sticky, stickyExampleModels.get(position - 1).sticky)) {
          recyclerViewHolder.tvStickyHeader.setVisibility(View.VISIBLE);
          recyclerViewHolder.tvStickyHeader.setText(stickyExampleModel.sticky);
          recyclerViewHolder.itemView.setTag(HAS_STICKY_VIEW);
        } else {
          recyclerViewHolder.tvStickyHeader.setVisibility(View.GONE);
          recyclerViewHolder.itemView.setTag(NONE_STICKY_VIEW);
        }
      }
      recyclerViewHolder.itemView.setContentDescription(stickyExampleModel.sticky);
    }
  }

  @Override
  public int getItemCount() {
    return stickyExampleModels == null ? 0 : stickyExampleModels.size();
  }

  public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView tvStickyHeader;
    public RelativeLayout rlContentWrapper;

    public TextView tv_movieName;
    public TextView movie_desc;
    public TextView tv_wish;
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
      movie_desc = (TextView) itemView.findViewById(R.id.movie_desc);
      tv_star_name = (TextView) itemView.findViewById(R.id.tv_star_name);
    }
  }
}
