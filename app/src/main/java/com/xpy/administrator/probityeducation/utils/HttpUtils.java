package com.xpy.administrator.probityeducation.utils;


import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.xpy.administrator.probityeducation.MyApplication;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/6/4.
 */

public class HttpUtils {
    private Gson mGson;
    private RequestQueue mRequestQueue;
    private static HttpUtils mHttpUtils;
    private String BASE_URL="http://localhost:8080";

    private HttpUtils(){
        mGson = new Gson();
        mRequestQueue = Volley.newRequestQueue(MyApplication.myApplication);
    }

    public static HttpUtils getInstances(){
        if(mHttpUtils==null){
            synchronized (HttpUtils.class){
                if(mHttpUtils==null){
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }

    public <T> void httpJsonObjectRequest(String url, String requestBody, final HttpCallBack<T> mTHttpCallBack){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, BASE_URL + url, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                try {
                    if(mTHttpCallBack==null){
                        return;
                    }

                    Type type = getTType(mTHttpCallBack.getClass());

                    if(type==String.class){
                        mTHttpCallBack.onSuccess((T)jsonObject.toString());
                    }else{
                        if(jsonObject.has("ROWS_DETAIL")){
                            String temp = jsonObject.getString("ROWS_DETAIL");
                            T t = mGson.fromJson(temp,type);
                            mTHttpCallBack.onSuccess(t);
                        }else{
                            T t = mGson.fromJson(jsonObject.toString(),type);
                            mTHttpCallBack.onSuccess(t);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    mTHttpCallBack.onFail("数据解析异常");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                NetworkResponse networkResponse = volleyError.networkResponse;
                if(networkResponse!=null){
                    try {
                        byte[] html = networkResponse.data;
                        JSONObject jsonObject = new JSONObject(new String(html));
                        String errorMsg = jsonObject.getString("ERRMSG");
                        mTHttpCallBack.onFail(errorMsg);
                    } catch (Exception e) {
                        e.printStackTrace();
                        mTHttpCallBack.onFail("请求失败");
                    }
                }else {
                    mTHttpCallBack.onFail(volleyError.toString());
                }
            }
        });

        if(mRequestQueue!=null){
            mRequestQueue.add(jsonObjectRequest);
        }
    }

    private Type getTType(Class<?> clazz){
        Type mSuperType = clazz.getGenericSuperclass();
        Type[] types = ((ParameterizedType)mSuperType).getActualTypeArguments();
        if(types!=null&&types.length>0){
            return types[0];
        }
        return null;
    }
}
