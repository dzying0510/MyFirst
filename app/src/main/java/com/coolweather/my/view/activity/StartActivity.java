package com.coolweather.my.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;

import com.coolweather.my.R;

import java.util.Timer;
import java.util.TimerTask;

public class StartActivity extends AppCompatActivity {

    private AppCompatImageView imgView;
    private AnimationSet as;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();// 初始化界面
        startAnimation();//开始播放动画
        initEvent();//初始化事件
    }

    private void initEvent() {
        //1、监听动画播放完的事件，只是一处用到事件就用匿名类对象，多处声明成员变量用
        as.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            //监听动画播放完
            @Override
            public void onAnimationEnd(Animation animation) {
                final Intent intent = new Intent(StartActivity.this,MainActivity.class);
                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(intent);
                        finish();
                    }
                };
                timer.schedule(task,1000*3);  //3秒之后
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    /**
     * 开始播放动画：旋转，缩放，渐变
     */
    private void startAnimation() {
        // false 代表动画集中每种动画都采用各自的动画插入器（数字函数）
        as = new AnimationSet(false);

//        //旋转动画，锚点: 设置锚点为图片的中心点
//        RotateAnimation ra = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
//        // 设置动画播放时间
//        ra.setDuration(2000);
//        //动画播放完之后，停留在当前状态
//        ra.setFillAfter(true);
//        // 添加到动画集
//        as.addAnimation(ra);

        // 渐变动画: 由完全透明到不透明
        AlphaAnimation aa = new AlphaAnimation(0, 1);
        aa.setDuration(2000);
        aa.setFillAfter(true);
        as.addAnimation(aa);

//        // 缩放动画
//        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        sa.setDuration(2000);
//        sa.setFillAfter(true);
//        as.addAnimation(sa);

        // 播放动画
        imgView.startAnimation(as);

    }

    private void initView() {
        // 设置主界面
        setContentView(R.layout.activity_start);
        //获取背景图片
        imgView = findViewById(R.id.start_bg_img);
    }

}
