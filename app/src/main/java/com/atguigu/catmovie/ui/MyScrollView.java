package com.atguigu.catmovie.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

import com.atguigu.catmovie.utils.DensityUtil;

/**
 * 自定义ScrollView，
 * 1.在满足临界条件的时候：正常情况下，子视图内容小于屏幕高度，拖动ScrollView不会有效果，此种情况还是
 * 按照ScrollView的默认处理: return super.onTouchEvent(ev);
 * 2.当子视图内容大于等于屏幕的高度时，我们重新onTouchEven(),在满足某种临界状态的条件下，对ScrollView中的子视图重新布局，并且记录临界状态时的位置，up时能够回到临界处的位置。
 */
public class MyScrollView extends ScrollView {
    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private View childView;

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int childCount = this.getChildCount();
        if (childCount > 0) {
            childView = getChildAt(0);
        }
    }

    private int lastY;//记录上一次的位置
    private Rect normal = new Rect();//用于记录临界状态时的left,top,right,bottom的坐标
    //isFinishAnimation不写也不会太影响效果
//    private boolean isFinishAnimation = true;//判断是否结束了动画:作用：以防在平移动画还没有结束时用户去操作带来的小问题
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

//        if (childView == null&&!isFinishAnimation) {
        if (childView == null) {
            return super.onTouchEvent(ev);
        }
        int eventY = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastY = eventY;
                Log.e("TAA", "DOWN--eventY" + eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                int dy = eventY - lastY;
                Log.e("TAA", "MOVE--eventY" + eventY);
                Log.e("TAA", "dy==" + dy);
                //如果满足要移动的条件
                if (isNeedMove()) {
                    //用于记录临界状态的：如果没有记录过坐标，就记录一下chileView坐标left,top,right,bottom
                    if (normal.isEmpty()) {
                        //normal为包裹chileView外层矩形
                        normal.set(childView.getLeft(), childView.getTop(), childView.getRight(), childView.getBottom());

                    }
                    //重新定位,childView.getTop()+dy/2:实际上加上dy即可，用dy/2是让拖动的时候不那么敏感。
                    childView.layout(childView.getLeft(), childView.getTop() + dy / 2, childView.getRight(), childView.getBottom() + dy / 2);
                }

                lastY = eventY;//每次都要记录最近的上一次的位置
                break;
            case MotionEvent.ACTION_UP:
                //up的时候重新布局，以平移动画回到起始没有拖动的位置
                if(isNeedAnimation()) {
                    TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0, normal.bottom - childView.getBottom());
                    translateAnimation.setDuration(300);
                    childView.startAnimation(translateAnimation);

                    translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
//                        isFinishAnimation = false;
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
//                        isFinishAnimation = true;
                            //动画结束时，重新布局到临界值
                            childView.clearAnimation();
                            childView.layout(normal.left, normal.top, normal.right, normal.bottom);
                            normal.setEmpty();//重新设置normal为空，回到最初的状态
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {

                        }
                    });
                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    private boolean isNeedAnimation() {

        return !normal.isEmpty();
    }

    /**
         * 需要移动的临界状态判断
         */
    private boolean isNeedMove() {
        int measuredHeight = childView.getMeasuredHeight();//测量ScrollView子视图的高度，此时还没有布局在画布上
        int height = this.getHeight();//获得屏幕的高度
        int dy = measuredHeight - height;
        //获取当前视图在y轴方向上移动的位移 (最初：0.上移：+，下移：-):getScrollY--左+右-，上+下-
        int scrollY = this.getScrollY();
        if (scrollY <= 0 || scrollY >= dy) {
            return true;
        }
        return false;
    }

    private int lastX;
    private int downX, downY;


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean isIntercept = false;//是否需要拦截孩子
        int eventX = (int) ev.getX();
        int eventY = (int) ev.getY();
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = eventX;
                downX = eventX;
                downY = eventY;
                break;
            case MotionEvent.ACTION_MOVE:
                int dx = Math.abs(eventX - downX);
                int dy = Math.abs(eventY - downY);
                if (dx < dy && dy >= DensityUtil.dip2px(10)) {
                    isIntercept = true;
                }
                lastX = eventX;
                lastY = eventY;
                break;
        }
        return isIntercept;
    }
}
