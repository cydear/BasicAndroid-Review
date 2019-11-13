package com.basic.android.http;

import android.text.TextUtils;

import com.basic.android.BaseViewApplication;
import com.basic.android.utils.LogUtil;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    //在Application中初始化
    public static String baseUrl;

    /**
     * token
     */
    public static String userToken = "23843214879123";

    private static final int DEFAULT_TIME_OUT = 15;
    private static RetrofitManager mRetrofitManager;
    private static HttpLoggingInterceptor loggingInterceptor;
    private static OkHttpClient okHttpClient;
    private Retrofit mRetrofit;

    private RetrofitManager() {
        if (TextUtils.isEmpty(baseUrl)) {
            new Throwable("baseUrl is empty").printStackTrace();
        }
        mRetrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitManager getInstance() {
        if (mRetrofitManager == null) {
            synchronized (RetrofitManager.class) {
                if (mRetrofitManager == null) {
                    mRetrofitManager = new RetrofitManager();
                }
            }
        }
        return mRetrofitManager;
    }

    /**
     * 获取单例OkHttpClient
     *
     * @return
     */
    private static OkHttpClient initOkHttpClient() {
        //添加公共参数拦截器
        HttpCommonInterceptor interceptor = new HttpCommonInterceptor.Builder()
                .addHeaderParams("platForm", "android")
                .addHeaderParams("userToken", userToken)
                .build();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NotNull String s) {
                //打印日志
                LogUtil.showLog(BaseViewApplication.mInstance, s);
            }
        });
        //设置日志级别
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        if (okHttpClient == null) {
            synchronized (OkHttpClient.class) {
                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(interceptor)
                            .addNetworkInterceptor(loggingInterceptor)
                            //设置连接超时时间
                            .connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            //设置读取超时时间
                            .readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            //设置写入超时时间
                            .writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    static {
        initOkHttpClient();
    }

    public <T> T create(Class<T> reqService) {
        return mRetrofit.create(reqService);
    }
}
