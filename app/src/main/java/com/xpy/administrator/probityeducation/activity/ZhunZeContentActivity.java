package com.xpy.administrator.probityeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhunZeContentActivity extends AppCompatActivity {

    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindArray(R.array.arr_zhunze)
    String zhunze[];

    @BindArray(R.array.arr_zhunze_details)
    String zhunzeDetails[];

    @BindArray(R.array.arr_zhunze_time)
    String zhunzeTime[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhun_ze_content);
        ButterKnife.bind(this);

        Intent it = getIntent();
        Bundle b = it.getExtras();
        if(b!=null){
            int id=b.getInt("id");
            tvContentTitle.setText(zhunze[id].substring(0,3));

            tvTitle.setText(zhunze[id]);

            tvTime.setText(zhunzeTime[id]);

            tvContent.setText(zhunzeDetails[id]);

        }else{
            this.finish();
        }

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZhunZeContentActivity.this.finish();
            }
        });

    }
}
