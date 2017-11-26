package com.xpy.administrator.probityeducation.utils;

/**
 * Created by Administrator on 2017/6/4.
 */

public abstract class HttpCallBack<T> {
    public abstract void onSuccess(T data);
    public abstract void onFail(String errorMsg);
}
