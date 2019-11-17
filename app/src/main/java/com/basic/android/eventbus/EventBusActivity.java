package com.basic.android.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.basic.android.R;

import org.greenrobot.eventbus.EventBus;

public class EventBusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventbus);
        EventBus.getDefault().register(this);
        findViewById(R.id.btn_post).setOnClickListener(view -> {
            MessageEvent event = new MessageEvent("我是POST消息哈");
            EventBus.getDefault().post(event);
        });
        findViewById(R.id.btn_sticky).setOnClickListener(view -> {
            StickMessageEvent event = new StickMessageEvent("我是Sticky消息哈");
            EventBus.getDefault().postSticky(event);
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
