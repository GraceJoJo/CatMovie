package com.atguigu.catmovie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WelcomeActivity extends Activity {

    @Bind(R.id.ll_welcome)
    LinearLayout llWelcome;
    private AlphaAnimation alphaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        startAnimation();
    }

    private void startAnimation() {
        alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        llWelcome.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
