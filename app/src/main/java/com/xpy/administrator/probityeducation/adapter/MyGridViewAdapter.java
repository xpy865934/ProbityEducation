package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.model.ProductModel;
import com.xpy.administrator.probityeducation.utils.GildeUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private List<ProductModel> list;
    private Context context;

    public MyGridViewAdapter(Context context,List<ProductModel> list){
        this.context = context;
        this.list = list;
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
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_view_item, null);
            holder.imtThumbnail = (ImageView) convertView.findViewById(R.id.img_thumbnail);
            holder.tvName = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        GildeUtils.loadImage("http://192.168.253.1:8080"+list.get(position).getProduct_path(),context,holder.imtThumbnail);

        holder.tvName.setText(list.get(position).getProduct_name() + "");
        return convertView;
    }

    private class Holder{
        ImageView imtThumbnail;
        TextView tvName;
    }
}
