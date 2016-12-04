package com.atguigu.catmovie.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.login.LoginActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 我的--页面
 */
public class MeFragment extends BaseFragment implements View.OnClickListener {

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

    @Override
    public View initView() {
        View view = View.inflate(mContext, R.layout.fragment_me, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initData() {
        initListener();
    }

    private void initListener() {
        tvLoginNow.setOnClickListener(this);
        tvLoginNow.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(MotionEvent.ACTION_UP==event.getAction()) {
                    isFragmentVisible();
                    Intent intent = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_login_now:

                break;
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
}
