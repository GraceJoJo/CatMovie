package com.atguigu.catmovie.login;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.login.imagepicker.GlideImageLoader;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.lzy.imagepicker.view.CropImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的--页面
 */
public class MeFragment extends BaseFragment {

    private static final String TAG = "me";
    @Bind(R.id.iv_user_icon)
    ImageView ivUserIcon;
    @Bind(R.id.tv_login_now)
    TextView tvLoginNow;
    @Bind(R.id.rl_my_ordered)
    RelativeLayout rlMyOrdered;
    @Bind(R.id.ll_no_resume)
    LinearLayout llNoResume;
    @Bind(R.id.ll_wait_for_pay)
    LinearLayout llWaitForPay;
    @Bind(R.id.ll_wait_comment)
    LinearLayout llWaitComment;
    @Bind(R.id.ll_refund)
    LinearLayout llRefund;
    @Bind(R.id.rl_my_message)
    RelativeLayout rlMyMessage;
    @Bind(R.id.rl_collection)
    RelativeLayout rlCollection;
    @Bind(R.id.rl_achievement)
    RelativeLayout rlAchievement;
    @Bind(R.id.rl_meituan_wallet)
    RelativeLayout rlMeituanWallet;
    @Bind(R.id.next)
    ImageView next;
    @Bind(R.id.rl_my_balance)
    RelativeLayout rlMyBalance;
    @Bind(R.id.rl_my_coupon)
    RelativeLayout rlMyCoupon;
    @Bind(R.id.rl_shopping_mall)
    RelativeLayout rlShoppingMall;
    @Bind(R.id.rl_settings)
    RelativeLayout rlSettings;

    /**
     * 使用EventBus接收消息---qq登陆
     * @param msg
     */
    @Subscribe(threadMode= ThreadMode.MAIN)
    public void onEventMainThread(String msg){
        Log.e("TAG", "MainActivity收到了消息"+msg);
        String nickName = PreferenceUtils.getString(getActivity(), MyConstants.USER_NAME);
        String qqImageUrl = PreferenceUtils.getString(getActivity(), MyConstants.IMAGE_URL);
        Log.e("TAG", "nickName="+nickName+"---qqImage==="+qqImageUrl);
        tvLoginNow.setText(nickName);
        setImageAvator(qqImageUrl);
        tvLoginNow.setClickable(false);
    };
    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_me, null);
        ButterKnife.bind(this, view);
        EventBus.getDefault().register(this);
        return view;
    }
    private ImagePicker imagePicker;
    @Override
    public void initData() {
        /**
         * 集成裁剪图片的功能
         */
        imagePicker = ImagePicker.getInstance();
        imagePicker.setImageLoader(new GlideImageLoader());
        imagePicker.setStyle(CropImageView.Style.CIRCLE);
        imagePicker.setMultiMode(false);
        Integer radius = 140;
        radius = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, radius, getResources().getDisplayMetrics());
        imagePicker.setFocusWidth(radius * 2);
        imagePicker.setFocusHeight(radius * 2);

        initListener();
    }

    private void initListener() {
        tvLoginNow.setClickable(true);
        tvLoginNow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (MotionEvent.ACTION_UP == event.getAction()) {
                    isFragmentVisible();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        ivUserIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ImageGridActivity.class);
                startActivityForResult(intent, 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("TAG", "23232323232323");
       if(resultCode == ImagePicker.RESULT_CODE_ITEMS) {
           /**
            * 集成图片裁剪的返回结果--???????????不执行？？？？？？？？？？也是醉了。。。。。。。。
            */
           int size = 360;
           if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
               if (data != null && requestCode == 100) {
                   ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
                   for (int i = 0; i < images.size(); i++) {
                       ImageItem imageItem = images.get(i);
                       if (imageItem != null) {
                           imagePicker.getImageLoader().displayImage(getActivity(), imageItem.path, ivUserIcon, size, size);
                           Log.e("TAG", "集成图片裁剪的返回结果");
                       }
                   }
               } else {
                   Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT).show();
               }
           }
       }
    }

    /**
     * 设置用户头像
     *
     * @param imageurl
     */
    private void setImageAvator(String imageurl) {
        if (!TextUtils.isEmpty(imageurl)) {
            Picasso.with(mContext).load(imageurl).transform(new Transformation() {
                @Override
                public Bitmap transform(Bitmap bitmap) {
                    //先对图片进行压缩
                    Bitmap zoom = BitmapUtils.zoom(bitmap, 140, 140);
                    //对请求回来的Bitmap进行圆形处理
                    Bitmap ciceBitMap = BitmapUtils.circleBitmap(zoom);
                    bitmap.recycle();//必须队更改之前的进行回收
                    return ciceBitMap;
                }

                @Override
                public String key() {
                    return "";
                }
            }).into(ivUserIcon);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged" + hidden);
        isFragmentVisible();
    }

    private void isFragmentVisible() {
        MainActivity activity = (MainActivity) getActivity();
        activity.getLlCommonTitl().setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();
        isFragmentVisible();
        Log.e(TAG, "onResume");
    }



    @Override
    public void onStop() {
        super.onStop();
        isFragmentVisible();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        isFragmentVisible();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);//反注册EventBus
    }
}
