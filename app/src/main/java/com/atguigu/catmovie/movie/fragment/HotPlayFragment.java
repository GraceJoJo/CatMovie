package com.atguigu.catmovie.movie.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.youth.banner.Banner;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 电影---热映Fragment
 */
public class HotPlayFragment extends BaseFragment {
    @Bind(R.id.listview_hot)
    ListView listviewHot;
    @Bind(R.id.ll_search_center)
    LinearLayout llSearchCenter;
    @Bind(R.id.banner)
    Banner banner;
    private ArrayList<String> datas;

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_movie_hot, null);
        View headView = View.inflate(mContext, R.layout.hot_listview_head_layout, null);
        listviewHot.addHeaderView(headView);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add("item  " + i);
        }
        listviewHot.setAdapter(new MyAdapter());

        setBannerStyle();
    }

    private void setBannerStyle() {
//        //（1）设置banner的样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
////        //（2）设置图片加载器
//        banner.setImageLoader(new GlideImageLoader());
//        //（3）添加图片url的集合
//        ArrayList<String> imageUrls = new ArrayList<>(5);
//        for (int i = 0; i < index.imageList.size(); i++) {
//            String imaurl = index.imageList.get(i).IMAURL;
//            imageUrls.add(imaurl);
//        }
//        //（4）设置图片集合与banner关联
//        banner.setImages(imageUrls);
//        //（5）设置动画效果
//        banner.setBannerAnimation(Transformer.CubeOut);
//        //（7）设置自动轮播
//        banner.isAutoPlay(true);
//        //（8）设置轮播时间
//        banner.setDelayTime(2000);
//        //（9）设置指示器位置(当banner模式中有指示器时)
//        banner.setIndicatorGravity(BannerConfig.RIGHT);
//        //（10）banner设置方法全部调用完毕时最后调用
//        banner.start();
//       // 需要GlideImageLoader的类：
//        //import com.youth.banner.loader.ImageLoader;

    }
//    public class GlideImageLoader extends ImageLoader {
//        @Override
//        public void displayImage(Context context, Object path, ImageView imageView) {
//            //使用Picasso加载图片
//            Picasso.with(context).load((String) path).into(imageView);
//        }
//    }


    private class MyAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                viewHolder = new ViewHolder();
                convertView = View.inflate(mContext, R.layout.item_hot_layout, null);
                viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.textView.setText(datas.get(position));
            return convertView;
        }
    }

    class ViewHolder {
        TextView textView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
