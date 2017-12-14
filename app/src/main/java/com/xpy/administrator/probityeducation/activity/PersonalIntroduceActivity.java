package com.xpy.administrator.probityeducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyRollViewPagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.graphics.Color.WHITE;
import static android.graphics.Color.YELLOW;

public class PersonalIntroduceActivity extends AppCompatActivity {
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_content_title)
    TextView tv_content_title;
    @BindView(R.id.t_rollpager)
    RollPagerView tRollPager;
    private MyRollViewPagerAdapter adapter;
    private int[] imgs ={R.drawable.t_roll_image1,R.drawable.t_roll_image2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_introduce);
        ButterKnife.bind(this);
        initView();

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PersonalIntroduceActivity.this.finish();
            }
        });
    }

    private void initView() {
        //设置播放时间间隔
        tRollPager.setPlayDelay(2000);
        //设置透明度
        tRollPager.setAnimationDurtion(500);
        //设置适配器
        adapter = new MyRollViewPagerAdapter();
        adapter.setImgs(imgs);
        tRollPager.setAdapter(adapter);

        //设置指示器（顺序依次）
        //自定义指示器图片
        //设置圆点指示器颜色
        //设置文字指示器
        //隐藏指示器
        //mRollViewPager.setHintView(new IconHintView(this, R.drawable.point_focus, R.drawable.point_normal));
        tRollPager.setHintView(new ColorPointHintView(this, YELLOW, WHITE));
        //mRollViewPager.setHintView(new TextHintView(this));
        //mRollViewPager.setHintView(null);

        tv_content_title.setText("陶行知简介");
    }
}
