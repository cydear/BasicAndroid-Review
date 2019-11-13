package com.basic.android.http;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.basic.android.R;
import com.basic.android.utils.LogUtil;
import com.basic.android.utils.ToastUtil;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * [类功能说明]
 *
 * @author lary.huang
 * @version v 1.4.8 2019-11-13 XLXZ Exp $
 * @email huangyang@xianglin.cn
 */
public class OkHttpActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp);
        findViewById(R.id.btn_get).setOnClickListener(this);
        findViewById(R.id.btn_post).setOnClickListener(this);
        findViewById(R.id.btn_send_file).setOnClickListener(this);
        findViewById(R.id.btn_send_file).setOnClickListener(this);
        findViewById(R.id.btn_retrofit).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int _id = v.getId();
        if (_id == R.id.btn_get) {
            getAsynHttp();
        } else if (_id == R.id.btn_post) {
            postAsynHttp();
        } else if (_id == R.id.btn_send_file) {
            postAsynFile();
        } else if (_id == R.id.btn_download_file) {
            downAysnFile();
        } else if (_id == R.id.btn_retrofit) {
            getIpInformation("59.108.54.37");
        }
    }

    //retrofit
    private void getIpInformation(String ip) {
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IpService ipService = retrofit.create(IpService.class);
        retrofit2.Call<IpModel> call = ipService.getIpMsg(ip);
        call.enqueue(new retrofit2.Callback<IpModel>() {
            @Override
            public void onResponse(retrofit2.Call<IpModel> call, retrofit2.Response<IpModel> response) {
                String country = response.body().getData().getCountry();
                LogUtil.showLog("country:" + country);
                ToastUtil.showLongCenter(getApplicationContext(), country);
            }

            @Override
            public void onFailure(retrofit2.Call<IpModel> call, Throwable t) {
                ToastUtil.showLongCenter(getApplicationContext(), t.getMessage());
            }
        });
    }

    //Get请求
    private void getAsynHttp() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder()
                .url("http://www.baidu.com");
        //可以省略，默认是GET请求
        requestBuilder.method("GET", null);
        Request request = requestBuilder.build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LogUtil.showLog(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if (null != response.cacheResponse().toString()) {
                    String str = response.cacheResponse().toString();
                    LogUtil.showLog("cache---" + str);
                } else {
                    response.body().string();
                    String str = response.networkResponse().toString();
                    LogUtil.showLog("network--" + str);
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showLongCenter(getApplicationContext(), "请求成功");
                    }
                });
            }
        });
    }

    //POST
    private void postAsynHttp() {
        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("size", "10")
                .build();
        Request request = new Request.Builder()
                .url("http://api.1-blog.com/biz/bizserver/article/list.do")
                .post(formBody)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LogUtil.showLog(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String str = response.body().string();
                LogUtil.showLog(str);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtil.showLongCenter(getApplicationContext(), "请求成功");
                    }
                });
            }
        });
    }

    //上传文件
    private void postAsynFile() {
        OkHttpClient client = new OkHttpClient();
        File file = new File("/sdcard/test.txt");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(MediaType.parse("text/x-markdown;charset=utf-8"), file))
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LogUtil.showLog(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                LogUtil.showLog(response.body().string());
            }
        });
    }

    private void downAysnFile() {
        OkHttpClient client = new OkHttpClient();
        String url = "http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                LogUtil.showLog(e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    InputStream inputStream = response.body().byteStream();
                    FileOutputStream fos = new FileOutputStream(new File("/sdcard/test.jpg"));
                    byte[] buffer = new byte[2048];
                    int len = 0;
                    while ((len = inputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, len);
                    }
                    fos.flush();
                    inputStream.close();
                    fos.close();
                    LogUtil.showLog("文件下载成功!");
                } catch (Exception e) {
                    LogUtil.showLog(e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
