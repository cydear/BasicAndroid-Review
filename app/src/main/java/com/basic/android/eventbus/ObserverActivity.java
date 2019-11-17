package com.basic.android.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.basic.android.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ObserverActivity extends AppCompatActivity {
    private TextView mTvPost, mTvSticky;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
        EventBus.getDefault().register(this);
        mTvPost = findViewById(R.id.tv_post);
        mTvSticky = findViewById(R.id.tv_stick);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onRecivePostEvent(MessageEvent event) {
        mTvPost.setText(event.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onReciveStickEvent(StickMessageEvent event) {
        mTvSticky.setText(event.getMessage());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
