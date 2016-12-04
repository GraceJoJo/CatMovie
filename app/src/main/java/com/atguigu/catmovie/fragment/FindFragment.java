package com.atguigu.catmovie.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.atguigu.catmovie.MainActivity;
import com.atguigu.catmovie.base.BaseFragment;
import com.atguigu.catmovie.utils.DensityUtil;

/**
 * 发现页面
 */
public class FindFragment extends BaseFragment {
    private static final String TAG = "find";
    private TextView textView;
    @Override
    public View initView() {
//        View.inflate(mContext, R.layout.fragment_me,null);
        textView = new TextView(mContext);
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(Color.RED);
        textView.setTextSize(DensityUtil.dip2px(mContext, 40));
        return textView;
    }
    @Override
    public void initData() {
        textView.setText("发现");
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "onHiddenChanged" + hidden);
        if(!hidden) {
            isFragmentVisible();
        }
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
}
