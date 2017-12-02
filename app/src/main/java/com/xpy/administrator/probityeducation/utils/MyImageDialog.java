package com.xpy.administrator.probityeducation.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ListView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyDialogImageAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MyImageDialog extends Dialog implements View.OnClickListener{
    Context context;
    private ListView lvImage=null;
    private MyDialogOnClickListener listener;
    private MyDialogImageAdapter adapter;

    public MyImageDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public MyImageDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected MyImageDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context=context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_dialog_layout);
        lvImage = (ListView) findViewById(R.id.lv_image);
        List<String> list = new ArrayList<>();
        list.add("1");
        adapter = new MyDialogImageAdapter(context,list);
        lvImage.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        listener.onClick(v);
    }
}