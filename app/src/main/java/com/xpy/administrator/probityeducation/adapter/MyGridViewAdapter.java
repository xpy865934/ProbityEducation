package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.bean.ImageTitleModel;
import com.xpy.administrator.probityeducation.utils.ImageUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class MyGridViewAdapter extends BaseAdapter {
    private List<ImageTitleModel> list;
    private Context context;

    public MyGridViewAdapter(Context context,List<ImageTitleModel> list){
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

        holder.imtThumbnail.setImageBitmap(ImageUtils.getImageThumbnail(context,list.get(position).getImageId()));
        holder.tvName.setText(list.get(position).getTitle() + "");
        return convertView;
    }

    private class Holder{
        ImageView imtThumbnail;
        TextView tvName;
    }
}
