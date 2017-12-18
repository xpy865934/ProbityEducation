package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.Config;
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

        GildeUtils.loadImage(Config.ADDRESS+list.get(position).getProduct_path(),context,holder.imtThumbnail);

        //如果班级不存在,则只显示姓名，如果班级存在则上面显示班级，下面一行显示姓名
        //注意：这里先设置为空字符串，不然可能第一个item显示有问题
        holder.tvName.setText("");
        if(list.get(position).getBanji()!=null){
            holder.tvName.setText(list.get(position).getBanji() + "");
        }
        if(list.get(position).getAuthor()!=null){
            if(holder.tvName.getText().toString().trim().length()>0){
                holder.tvName.setText(holder.tvName.getText()+"\n"+list.get(position).getAuthor() + "");
            }else{
                holder.tvName.setText(list.get(position).getAuthor() + "");
            }
        }
        return convertView;
    }

    private class Holder{
        ImageView imtThumbnail;
        TextView tvName;
    }
}
