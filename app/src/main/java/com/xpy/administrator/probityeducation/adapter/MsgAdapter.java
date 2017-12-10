package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.model.MsgModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/20.
 */

public class MsgAdapter extends BaseAdapter {
    private List<MsgModel> list;
    private Context context;

    public MsgAdapter(Context context,List<MsgModel> list){
        this.context=context;
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
            convertView = LayoutInflater.from(context).inflate(R.layout.msg_item, null);
            holder.imgHead = (ImageView) convertView.findViewById(R.id.img_head);
            holder.tvNickName = (TextView) convertView.findViewById(R.id.tv_nickname);
            holder.tvComment= (TextView) convertView.findViewById(R.id.tv_comment);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.imgHead.setImageResource(list.get(position).getImageId());
        holder.tvNickName.setText(list.get(position).getNickName() + "");
        holder.tvComment.setText(list.get(position).getComment() + "");
        holder.tvTime.setText(list.get(position).getTime() + "");

         return convertView;
    }

    private class Holder{
        ImageView imgHead;
        TextView tvNickName;
        TextView tvComment;
        TextView tvTime;
    }
}
