package com.xpy.administrator.probityeducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.YuLuTitleContentAdapter;
import com.xpy.administrator.probityeducation.model.TitleContentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class YuLuActivity extends AppCompatActivity {
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.lv_yulu)
    ListView lvYuLu;

    YuLuTitleContentAdapter adapter;
    List<TitleContentModel> list;

    @BindArray(R.array.arr_lianjie_yulu)
    String yuluDetails[];

    @BindArray(R.array.arr_lianjie_yulu_time)
    String yuluTime[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_lu);
        ButterKnife.bind(this);

        tvContentTitle.setText("廉洁语录");

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YuLuActivity.this.finish();
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < yuluTime.length; i++) {
            TitleContentModel titleContentModel = new TitleContentModel(yuluTime[i],yuluDetails[i]);
            list.add(titleContentModel);
        }

        adapter = new YuLuTitleContentAdapter(YuLuActivity.this,list);
        lvYuLu.setAdapter(adapter);
    }
}
