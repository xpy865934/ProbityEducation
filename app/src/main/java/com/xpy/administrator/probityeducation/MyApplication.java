package com.xpy.administrator.probityeducation;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Administrator on 2017/6/4.
 */

public class MyApplication  extends Application{
    public static  MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        Fresco.initialize(this);
    }
}
