package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
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
            holder.imgHead = (SimpleDraweeView) convertView.findViewById(R.id.img_head);
            holder.tvNickName = (TextView) convertView.findViewById(R.id.tv_nickname);
            holder.tvComment= (TextView) convertView.findViewById(R.id.tv_comment);
            holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.tvNickName.setText(list.get(position).getNickName() + "");
        holder.tvComment.setText(list.get(position).getComment() + "");
        holder.tvTime.setText(list.get(position).getTime() + "");

        //通过网络获取留言图片
        DraweeController placeHolderDraweeController = Fresco.newDraweeControllerBuilder()
                //.setUri(list.get(position).getImageURL()) //为图片设置url
                .setTapToRetryEnabled(false)   //设置在加载失败后,能否重试
                .setOldController(holder.imgHead.getController())
                .build();
        holder.imgHead.setController(placeHolderDraweeController);

        //临时设置图片
        holder.imgHead.getHierarchy().setPlaceholderImage(list.get(position).getImageId());
        return convertView;
    }

    private class Holder{
        SimpleDraweeView imgHead;
        TextView tvNickName;
        TextView tvComment;
        TextView tvTime;
    }
}
