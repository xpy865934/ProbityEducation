package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.xpy.administrator.probityeducation.Config;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.model.ProductModel;
import com.xpy.administrator.probityeducation.utils.GildeUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */

public class MyDialogImageAdapter extends BaseAdapter{
    private Context context;
    private List<String> list;
    private ProductModel productModel;

    public MyDialogImageAdapter(Context context,List<String> list,ProductModel productModel){
        this.context = context;
        this.list=list;
        this.productModel = productModel;
    }

    //设置item不能点击
    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if(convertView==null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.image_dialog_list_item_layout,null);
            holder.imgBig = (ImageView) convertView.findViewById(R.id.img_big);
            convertView.setTag(holder);
        }else{
            holder = (Holder) convertView.getTag();
        }

        GildeUtils.loadImage(Config.ADDRESS+productModel.getProduct_path(),context,holder.imgBig);

        return convertView;
    }

    private class Holder{
        ImageView imgBig;
    }
}
