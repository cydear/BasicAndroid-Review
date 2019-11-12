package com.basic.android.plugin;

import android.os.Build;

import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class HookHelper {
    public static final String TRAGET_INTENT = "target_inetnt";

    public static void hookAMS() throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Object defaultSingleton = null;
        if (Build.VERSION.SDK_INT >= 26) {
            Class<?> activityManager = Class.forName("android.app.ActivityManager");
            defaultSingleton = FieldUtils.getField(activityManager, null, "IActivityManagerSingleton");
        } else {
            Class<?> activityManagerNative = Class.forName("android.app.ActivityManagerNative");
            defaultSingleton = FieldUtils.getField(activityManagerNative, null, "gDefault");
        }
        Class<?> singletonClazz = Class.forName("android.util.Singleton");
        Field mInstanceField = FieldUtils.getField(singletonClazz, "mInstance");
        //获取IActivityManager
        Object iActivityManager = mInstanceField.get(defaultSingleton);
        Class<?> iActivityManagerClazz = Class.forName("android.app.IActivityManager");
        Object proxy = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class<?>[]{iActivityManagerClazz}, new IActivtyManagerProxy(iActivityManager));
        mInstanceField.set(defaultSingleton, proxy);
    }
}
