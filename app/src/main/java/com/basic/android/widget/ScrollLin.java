package com.basic.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import com.basic.android.utils.LogUtil;

public class ScrollLin extends RelativeLayout implements View.OnClickListener {
    private Scroller mScroller;
    private Context context;
    private View mView;
    private View mButton;
    private boolean isFirst = true;

    public ScrollLin(Context context) {
        this(context, null);
    }

    public ScrollLin(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollLin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        mScroller = new Scroller(context);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (isFirst) {
            LogUtil.showLog(context, "======isFirst======");
            mView = getChildAt(0);
            mButton = getChildAt(1);
            mButton.setOnClickListener(this);
        }
        isFirst = false;
    }

    @Override
    public void onClick(View v) {
        LogUtil.showLog(context, "======onClick======");
        mScroller.startScroll(0, 0, 0, -mView.getTop(), 2000);
        invalidate();
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {
            int currentY = mScroller.getCurrY();
            //平移
            mView.setTranslationY(currentY);
            invalidate();
        }
    }
}
