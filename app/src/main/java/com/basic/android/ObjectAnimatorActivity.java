package com.basic.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-10-14 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class ObjectAnimatorActivity extends AppCompatActivity {
    private Button mBtn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        mBtn1 = findViewById(R.id.btn_btn1);

        ObjectAnimator animator = ObjectAnimator.ofFloat(mBtn1, "translationX", 300);
        animator.setDuration(300);
        animator.start();

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
            }
        });

        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }

            @Override
            public void onAnimationResume(Animator animation) {
                super.onAnimationResume(animation);
            }
        });

        PropertyValuesHolder pvh1 = PropertyValuesHolder.ofFloat("translationX", 300);
        PropertyValuesHolder pvh2 = PropertyValuesHolder.ofFloat("scaleX", 1f, 0, 1f);
        PropertyValuesHolder pvh3 = PropertyValuesHolder.ofFloat("scaleY", 1f, 0, 1f);
        ObjectAnimator.ofPropertyValuesHolder(mBtn1, pvh1, pvh2, pvh3)
                .setDuration(1000)
                .start();

        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mBtn1, "translationX", 300f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mBtn1, "scaleX", 1f, 0f, 1f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mBtn1, "scaleY", 1f, 0f, 1f);
        AnimatorSet set = new AnimatorSet();
        set.setDuration(1000);
        set.playTogether(animator1, animator2, animator3);
        set.start();

        LinearLayout ll = findViewById(R.id.ll_object_animator);
        //设置过度动画
        ScaleAnimation sa = new ScaleAnimation(0, 1, 0, 1);
        sa.setDuration(2000);
        //设置布局动画的显示属性
        LayoutAnimationController lac = new LayoutAnimationController(sa, 0.5F);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        //为ViewGroup设置布局动画
        ll.setLayoutAnimation(lac);
    }
}
