package com.basic.android;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class PullDownAnimationActivity extends AppCompatActivity {
    private LinearLayout mHiddenView;
    private int mHiddenViewMeasureHeight = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulldown);
        mHiddenView = findViewById(R.id.hidden_view);
        float mDensity = getResources().getDisplayMetrics().density;
        mHiddenViewMeasureHeight = (int) (mDensity * 40 + 0.5);
    }

    public void llClick(View view) {
        if (mHiddenView.getVisibility() == View.GONE) {
            animatorOpen(mHiddenView);
        } else {
            animatorClose(mHiddenView);
        }
    }

    private void animatorClose(View view) {
        int originHeight = view.getHeight();
        ValueAnimator animator = createAnimator(view, originHeight, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                view.setVisibility(View.GONE);
            }
        });
        animator.start();
    }

    private void animatorOpen(View view) {
        view.setVisibility(View.VISIBLE);
        ValueAnimator animator = createAnimator(view, 0, mHiddenViewMeasureHeight);
        animator.start();
    }

    private ValueAnimator createAnimator(View view, int start, int end) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.addUpdateListener(animation -> {
            int value = (int) animation.getAnimatedValue();
            ViewGroup.LayoutParams params = view.getLayoutParams();
            params.height = value;
            view.setLayoutParams(params);
        });
        return animator;
    }
}
