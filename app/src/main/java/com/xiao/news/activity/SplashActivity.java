package com.xiao.news.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import com.xiao.news.R;
import com.xiao.news.Utils.PrefUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //初始化背景图片
        RelativeLayout mView = (RelativeLayout) findViewById(R.id.rl_bg);

        //设置缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,
                Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
        scaleAnimation.setDuration(1000);//持续1s
        scaleAnimation.setFillAfter(true);//保持动画结束状态

        //设置渐变动画
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setFillAfter(true);

        //动画集合
        AnimationSet set = new AnimationSet(true);
        set.addAnimation(scaleAnimation);
        set.addAnimation(alphaAnimation);

        //启动动画
        mView.startAnimation(set);

        //设置动画监听
        set.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //动画结束，跳转到导航页
            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent;
                //判断是否是第一次登陆，第一次登陆跳转到导航页，否则跳转至主页面
                boolean isFirstEnter = PrefUtils.getBoolean(getApplicationContext(), "is_first_enter", true);
                if (isFirstEnter) {
                    intent = new Intent(getApplicationContext(), GuideActivity.class);
                } else {
                    intent = new Intent(getApplicationContext(), MainActivity.class);
                }
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
