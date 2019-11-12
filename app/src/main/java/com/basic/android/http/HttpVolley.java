package com.basic.android.http;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.basic.android.BaseViewApplication;
import com.basic.android.utils.LogUtil;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class HttpVolley {

    /**
     * Volley请求网络是基于请求队列的，开发者只要把请求放在请求队列中就可以了，
     * 请求队列会一次进行请求
     */

    //StringRequest
    public void StringRequestTest() {
        //创建请求队列
        RequestQueue mQueue = Volley.newRequestQueue(BaseViewApplication.mInstance);
        //创建请求参数
        StringRequest request = new StringRequest(Request.Method.GET, "http://www.baidu.com",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        LogUtil.showLog(s);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        LogUtil.showLog(volleyError.getMessage());
                    }
                });
        //将请求添加在请求队列
        mQueue.add(request);
    }

    //JsonRequest
    public void JsonRequestTest() {
        RequestQueue mQueue = Volley.newRequestQueue(BaseViewApplication.mInstance);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://api.1-blog.com/biz/bizserver/article/list.do", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        Article article = new Gson().fromJson(jsonObject.toString(), Article.class);
                        List<Article.detail> lists = article.getDetail();
                        String title = lists.get(0).getTitle();
                        LogUtil.showLog(title);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        LogUtil.showLog(volleyError.getMessage());
                    }
                });
        mQueue.add(request);
    }

    //ImageRequest
    public void ImageRequestTest() {
        RequestQueue mQueue = Volley.newRequestQueue(BaseViewApplication.mInstance);
        ImageRequest request = new ImageRequest("http://img.my.csdn.net/uploads/201603/26/1458988468_5804.jpg",
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        //设置Bitmap至ImageView
                    }
                }, 0, 0, ImageView.ScaleType.CENTER, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        LogUtil.showLog(volleyError.getMessage());
                    }
                });
        mQueue.add(request);
    }
}
