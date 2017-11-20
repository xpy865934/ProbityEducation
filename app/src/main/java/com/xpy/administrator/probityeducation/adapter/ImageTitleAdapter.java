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

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ImageTitleAdapter extends BaseAdapter {
    private Context context;
    private List<ImageTitleModel> list;

    public ImageTitleAdapter(Context context) {
        this.context = context;
    }

    public ImageTitleAdapter(Context context, List<ImageTitleModel> list) {
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
        ImageTitleAdapterItemViewHolder holder;
        if (convertView == null) {
            holder = new ImageTitleAdapterItemViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.image_title_adapter, null);
            holder.img = (ImageView) convertView.findViewById(R.id.cita_img);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.cita_tv_title);
            convertView.setTag(holder);
        } else {
            holder = (ImageTitleAdapterItemViewHolder) convertView.getTag();
        }

        holder.img.setImageResource(list.get(position).getImageId());
        holder.tvTitle.setText(list.get(position).getTitle() + "");

        return convertView;
    }

    private class ImageTitleAdapterItemViewHolder {
        ImageView img;
        TextView tvTitle;
    }
}
