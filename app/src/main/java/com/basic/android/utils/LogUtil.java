package com.basic.android.utils;

import android.content.Context;
import android.nfc.Tag;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogUtil {
    private static final String DEFAULT_TAG = LogUtil.class.getSimpleName();

    /**
     * log switch open or close
     */
    private static boolean mIsLogOpen = true;

    /**
     * set log enable true or flase
     *
     * @param enable
     */
    public static void setLogEnable(boolean enable) {
        mIsLogOpen = enable;
    }


    //日志类型
    private static final int DEBUG = 111;
    private static final int ERROR = 112;
    private static final int INFO = 113;
    private static final int VERBOSE = 114;
    private static final int WARN = 115;

    /**
     * default INFO DEFAULT_TAG
     *
     * @param message
     */
    public static void showLog(String message) {
        showLog(null, message);
    }

    /**
     * default INFO
     *
     * @param context
     * @param message
     */
    public static void showLog(Context context, String message) {
        showLog(context, message, INFO);
    }

    /**
     * @param context
     * @param message
     * @param logType
     */
    public static void showLog(Context context, String message, int logType) {
        printLog(context, message, logType);
    }

    private static void printLog(Context context, String message, int logType) {
        if (mIsLogOpen) {
            String tag;
            if (null != context) {
                tag = context.getClass().getSimpleName();
            } else {
                tag = DEFAULT_TAG;
            }
            switch (logType) {
                case DEBUG:
                    Log.d(tag, message);
                    break;
                case ERROR:
                    Log.e(tag, message);
                    break;
                case INFO:
                    Log.i(tag, message);
                    break;
                case VERBOSE:
                    Log.v(tag, message);
                    break;
                case WARN:
                    Log.w(tag, message);
                    break;
                default:
                    Log.i(tag, message);
                    break;
            }
        }
    }

    /**
     * write log to sdcard
     *
     * @param path
     * @param log
     */
    public static void writeLog(String path, String log) {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
            String datetime = sdf.format(new Date());
            try {
                File file = new File(path);
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file, true);
                fw.append("--" + datetime + "\n");
                fw.append(log);
                fw.append("========================================\n\n");
                fw.flush();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
