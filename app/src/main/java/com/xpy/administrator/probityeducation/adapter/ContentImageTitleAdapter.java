package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.bean.ContentImageTitleModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */

public class ContentImageTitleAdapter extends BaseAdapter {
    private Context context;
    private List<ContentImageTitleModel> list;

    public ContentImageTitleAdapter(Context context) {
        this.context = context;
    }

    public ContentImageTitleAdapter(Context context, List<ContentImageTitleModel> list) {
        this.context = context;
        this.list = list;
    }

    public List<ContentImageTitleModel> getList() {
        return list;
    }

    public void setList(List<ContentImageTitleModel> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public ContentImageTitleModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ContentImageTitleAdapterItemViewHolder holder;
        if (convertView == null) {
            holder = new ContentImageTitleAdapterItemViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.content_image_title_adapter, null);
            holder.img = (ImageView) convertView.findViewById(R.id.cita_img);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.cita_tv_title);
            holder.tvContent = (TextView) convertView.findViewById(R.id.cita_tv_content);
            convertView.setTag(holder);
        } else {
            holder = (ContentImageTitleAdapterItemViewHolder) convertView.getTag();
        }

        holder.img.setImageResource(list.get(position).getImageId());
        holder.tvTitle.setText(list.get(position).getTitle() + "");
        holder.tvContent.setText(list.get(position).getContent() + "");

        return convertView;
    }

    private class ContentImageTitleAdapterItemViewHolder {
        ImageView img;
        TextView tvTitle;
        TextView tvContent;
    }
}
