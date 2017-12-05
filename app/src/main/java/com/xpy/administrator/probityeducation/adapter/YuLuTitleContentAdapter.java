package com.xpy.administrator.probityeducation.adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.model.TitleContentModel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/3.
 */

public class YuLuTitleContentAdapter extends BaseAdapter {
    private Context context;
    private List<TitleContentModel> list;
    private RelativeLayout.LayoutParams lp;

    public YuLuTitleContentAdapter(Context context) {
        this.context = context;
    }

    public YuLuTitleContentAdapter(Context context, List<TitleContentModel> list) {
        this.context = context;
        this.list = list;
    }

    public List<TitleContentModel> getList() {
        return list;
    }

    public void setList(List<TitleContentModel> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TitleContentModel getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ImageTitleAdapterItemViewHolder holder;
        if (convertView == null) {
            holder = new ImageTitleAdapterItemViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.yu_lu_item_layout, null);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
            holder.ll2 = (LinearLayout) convertView.findViewById(R.id.ll2);
            convertView.setTag(holder);
        } else {
            holder = (ImageTitleAdapterItemViewHolder) convertView.getTag();
        }
        lp= (RelativeLayout.LayoutParams) holder.ll2.getLayoutParams();

        if(position%2!=0){
            lp.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);//注意:remove是关键，必须
            lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            holder.ll2.setLayoutParams(lp);
            holder.ll2.setBackgroundResource(R.color.colorGreen);
            holder.tvTitle.setGravity(Gravity.LEFT);
        }else{
            lp.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
            lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            holder.ll2.setLayoutParams(lp);
            holder.ll2.setBackgroundResource(R.color.colorRed);
            holder.tvTitle.setGravity(Gravity.RIGHT);
        }

        holder.tvTitle.setText(list.get(position).getTitle() + "");
        holder.tvContent.setText(list.get(position).getContent()+"");

        return convertView;
    }

    private class ImageTitleAdapterItemViewHolder {
        TextView tvTitle;
        TextView tvContent;
        LinearLayout ll2;
    }
}
