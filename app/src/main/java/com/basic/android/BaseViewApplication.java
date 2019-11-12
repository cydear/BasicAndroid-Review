package com.basic.android;

import android.app.Application;
import android.content.Context;

public class BaseViewApplication extends Application {
    public static Context mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
}
