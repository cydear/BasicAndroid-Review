package com.basic.android;

import android.app.IntentService;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

public class WindowActivity extends AppCompatActivity {
    private WindowManager mWindowManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window);

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

        //通过windowManager添加Window
        Button floatingButton = new Button(this);
        floatingButton.setText("floating button");
        WindowManager.LayoutParams floatingParam = new WindowManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSPARENT);
        floatingParam.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED;
        floatingParam.gravity = Gravity.LEFT | Gravity.TOP;
        floatingParam.x = 100;
        floatingParam.y = 300;
        mWindowManager.addView(floatingButton, floatingParam);

        Handler handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
        handler.sendEmptyMessage(0);

        //HandlerThread ht=new HandlerThread();

        //AsyncTask

        //IntentService

        //bindService()

    }
}
