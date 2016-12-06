package com.atguigu.catmovie.cinema.view;

import android.animation.Animator;
import android.app.Activity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.atguigu.catmovie.R;
import com.atguigu.catmovie.base.BasePopupWindow;
import com.atguigu.catmovie.utils.DensityUtil;

public class MenuPopup extends BasePopupWindow {

    private final TextView tx4;
    private final TextView tx5;
    private final TextView tx6;
    private final TextView tx7;
    private final TextView tx8;
    private final TextView tx9;
    private final TextView tx10;
    private TextView tx1;
    private TextView tx2;
    private TextView tx3;

    private int[] viewLocation;

    public TextView getTx1() {
        return tx1;
    }

    public TextView getTx2() {
        return tx2;
    }

    public TextView getTx3() {
        return tx3;
    }
    public TextView getTx4() {
        return tx4;
    }

    public TextView getTx5() {
        return tx5;
    }

    public TextView getTx6() {
        return tx6;
    }
    public TextView getTx7() {
        return tx7;
    }
    public TextView getTx8() {
        return tx8;
    }

    public TextView getTx9() {
        return tx9;
    }

    public TextView getTx10() {
        return tx10;
    }

    public MenuPopup(Activity context) {
        super(context, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        viewLocation=new int[2];
        tx1 = (TextView) mPopupView.findViewById(R.id.tx_1);
        tx2 = (TextView)  mPopupView.findViewById(R.id.tx_2);
        tx3 = (TextView) mPopupView.findViewById(R.id.tx_3);
        tx4 = (TextView) mPopupView.findViewById(R.id.tx_4);
        tx5 = (TextView) mPopupView.findViewById(R.id.tx_5);
        tx6 = (TextView) mPopupView.findViewById(R.id.tx_6);
        tx7 = (TextView) mPopupView.findViewById(R.id.tx_7);
        tx8 = (TextView) mPopupView.findViewById(R.id.tx_8);
        tx9 = (TextView) mPopupView.findViewById(R.id.tx_9);
        tx10 = (TextView) mPopupView.findViewById(R.id.tx_10);
    }

    @Override
    protected Animation getShowAnimation() {
        AnimationSet set=new AnimationSet(true);
        set.setInterpolator(new DecelerateInterpolator());
        set.addAnimation(getScaleAnimation(0,1,0,1,Animation.RELATIVE_TO_SELF,1,Animation.RELATIVE_TO_SELF,0));
        set.addAnimation(getDefaultAlphaAnimation());
        return set;
        //return null;
    }

    @Override
    public Animator getShowAnimator() {
       /* AnimatorSet set=new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(mAnimaView,"scaleX",0.0f,1.0f).setDuration(300),
                ObjectAnimator.ofFloat(mAnimaView,"scaleY",0.0f,1.0f).setDuration(300),
                ObjectAnimator.ofFloat(mAnimaView,"alpha",0.0f,1.0f).setDuration(300*3/2));*/
        return null;
    }

    @Override
    public void showPopupWindow(View v) {
        try {
            v.getLocationOnScreen(viewLocation);
            mPopupWindow.showAtLocation(v, Gravity.RIGHT | Gravity.TOP, (int)(v.getWidth()- DensityUtil.dip2px(mContext,30)),
                    viewLocation[1]+((v.getHeight()*2/3)+DensityUtil.dip2px(mContext,13)));
            if (getShowAnimation() != null && mAnimaView != null) {
                mAnimaView.clearAnimation();
                mAnimaView.startAnimation(getShowAnimation());
            }
            if (getShowAnimation() == null && getShowAnimator() != null && mAnimaView != null) {
                getShowAnimator().start();
            }
        } catch (Exception e) {
            Log.w("error","error");
        }
    }

    @Override
    protected View getClickToDismissView() {
        return null;
    }

    @Override
    public View getPopupView() {
        return getPopupViewById(R.layout.popup_menu);
    }

    @Override
    public View getAnimaView() {
        return mPopupView.findViewById(R.id.popup_contianer);
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.tx_1:
//                Toast.makeText(mContext, "click tx_1", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tx_2:
//                Toast.makeText(mContext, "click tx_2", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.tx_3:
//                Toast.makeText(mContext, "click tx_3", Toast.LENGTH_SHORT).show();
//                break;
//            default:
//                break;
//
//        }
//
//    }
}
