package com.xpy.administrator.probityeducation.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.activity.ZhunZeDetailsActivity;
import com.xpy.administrator.probityeducation.adapter.MyRollViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class MingGuiFragment extends Fragment {
    @BindView(R.id.m_rollpager)
    RollPagerView mRollPager;
    @BindView(R.id.img_minggui_item1)
    ImageView imgMingGuiItem1;
    @BindView(R.id.img_minggui_item2)
    ImageView imgMingGuiItem2;
    @BindView(R.id.img_minggui_item3)
    ImageView imgMingGuiItem3;
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_minggui, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    private void initView() {
        //设置播放时间间隔
        mRollPager.setPlayDelay(1000);
        //设置透明度
        mRollPager.setAnimationDurtion(500);
        //设置适配器
        mRollPager.setAdapter(new MyRollViewPagerAdapter());

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        mRollPager.setHintView(new ColorPointHintView(getActivity(), YELLOW, WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

        tvContentTitle.setText("明规");
    }

    public MingGuiFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.img_minggui_item1)
    public void item1Click(View view){
        Intent intent = new Intent(getActivity(), ZhunZeDetailsActivity.class);
        startActivity(intent);
    }
}
