package com.xpy.administrator.probityeducation.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jude.rollviewpager.adapter.StaticPagerAdapter;

/**
 * Created by Administrator on 2017/11/23.
 */

public class MyRollViewPagerAdapter extends StaticPagerAdapter {
    private int[] imgs = null;

    public void setImgs(int[] imgs) {
        this.imgs = imgs;
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView view = new ImageView(container.getContext());
        view.setImageResource(imgs[position]);
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        return view;
    }

    @Override
    public int getCount() {
        if(imgs==null){
            return 0;
        }
        return imgs.length;
    }
}
