package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.model.ImageTitleModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ZhunZeImageTitleAdapter extends BaseAdapter {
    private Context context;
    private List<ImageTitleModel> list;

    public ZhunZeImageTitleAdapter(Context context) {
        this.context = context;
    }

    public ZhunZeImageTitleAdapter(Context context, List<ImageTitleModel> list) {
        this.context = context;
        this.list = list;
    }

    public List<ImageTitleModel> getList() {
        return list;
    }

    public void setList(List<ImageTitleModel> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ImageTitleModel getItem(int position) {
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
            convertView = LayoutInflater.from(context).inflate(R.layout.zhun_ze_image_title_adapter, null);
            holder.img = (ImageView) convertView.findViewById(R.id.cita_img);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.cita_tv_title);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.img.setImageResource(list.get(position).getImageId());
        holder.tvTitle.setText(list.get(position).getTitle() + "");

        return convertView;
    }

    private class Holder {
        ImageView img;
        TextView tvTitle;
    }
}
