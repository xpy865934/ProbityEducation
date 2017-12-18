package com.xpy.administrator.probityeducation.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.xpy.administrator.probityeducation.Config;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyDialogImageAdapter;
import com.xpy.administrator.probityeducation.model.ProductModel;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MyImageDialog extends Dialog implements View.OnClickListener{
    Context context;
    private ListView lvImage=null;
    private MyDialogOnClickListener listener;
    private MyDialogImageAdapter adapter;

    //暂时默认只有一张图片，只传一个ProductModel
    private ProductModel productModel;
    private ImageView imgBig;

    public MyImageDialog(@NonNull Context context,ProductModel productModel) {
        super(context);
        this.context = context;
        this.productModel = productModel;
    }

    public MyImageDialog(@NonNull Context context, int themeResId,ProductModel productModel) {
        super(context, themeResId);
        this.context = context;
        this.productModel = productModel;
    }

    protected MyImageDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener,ProductModel productModel) {
        super(context, cancelable, cancelListener);
        this.context=context;
        this.productModel = productModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //默认只有一张图片，一张图片是控件使用的是自定义控件，可以缩放和滑动，多张图片时使用List，但是不能
        //使用自定义的ImageView,使用List是后期开发考虑，主要实现可以查看ppt多张图片
//        setContentView(R.layout.image_dialog_layout);
//        lvImage = (ListView) findViewById(R.id.lv_image);
//        List<String> list = new ArrayList<>();
        //暂时就默认只有一张图片
//        list.add("1");
//        adapter = new MyDialogImageAdapter(context,list,productModel);
//        lvImage.setAdapter(adapter);

        //这里一张图片时，直接加载item的布局，直接设置图片
        setContentView(R.layout.image_dialog_list_item_layout);
        imgBig = (ImageView) this.findViewById(R.id.img_big);
        GildeUtils.loadImage(Config.ADDRESS+productModel.getProduct_path(),context,imgBig);

        //设置弹出框宽高
        Window dialogWindow = this.getWindow();
        WindowManager.LayoutParams params = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.CENTER);
        WindowManager m = dialogWindow.getWindowManager();
        Display d = m.getDefaultDisplay();
        params.width = 435;
        params.height = 630;
        dialogWindow.setAttributes(params);
    }

    @Override
    public void onClick(View v) {
        //接口实现点击，暂时用不到，可能是点击某一个List里面的item，为后期开发做服务
        listener.onClick(v);
    }
}
