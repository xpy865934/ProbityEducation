package com.xpy.administrator.probityeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoryDetailsActivity extends AppCompatActivity {
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_details);
        ButterKnife.bind(this);

        tvContentTitle.setText("故事内容");

        Intent it = getIntent();
        Bundle b = it.getExtras();
        if(b!=null){
            String title = b.getString("title");
            String content = b.getString("content");
            tvTitle.setText(title);
            tvContent.setText(content);
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoryDetailsActivity.this.finish();
            }
        });
    }
}
