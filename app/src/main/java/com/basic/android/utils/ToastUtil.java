package com.basic.android.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class ToastUtil {
    private static Toast mToast;

    public static void showShortTop(Context context, Object msg) {
        show(context, msg, Gravity.TOP, Toast.LENGTH_SHORT);
    }

    public static void showShortCenter(Context context, Object msg) {
        show(context, msg, Gravity.CENTER, Toast.LENGTH_SHORT);
    }

    public static void showShortBottom(Context context, Object msg) {
        show(context, msg, Gravity.BOTTOM, Toast.LENGTH_SHORT);
    }

    public static void showLongTop(Context context, Object msg) {
        show(context, msg, Gravity.TOP, Toast.LENGTH_LONG);
    }

    public static void showLongCenter(Context context, Object msg) {
        show(context, msg, Gravity.CENTER, Toast.LENGTH_LONG);
    }

    public static void showLongBottom(Context context, Object msg) {
        show(context, msg, Gravity.BOTTOM, Toast.LENGTH_LONG);
    }

    private static void show(Context context, Object msg, int gravity, int duration) {
        String showMsg = "";

        if (msg instanceof Integer) {
            showMsg = context.getString((Integer) msg);
        } else if (msg instanceof String) {
            showMsg = (String) msg;
        }

        if (mToast == null) {
            mToast = Toast.makeText(context, showMsg, duration);
        } else {
            mToast.setText(showMsg);
        }
        mToast.setGravity(gravity, 0, 100);
        mToast.show();
    }

    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
            mToast = null;
        }
    }
}
