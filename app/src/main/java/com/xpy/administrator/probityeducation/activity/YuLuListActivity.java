package com.xpy.administrator.probityeducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.TaoLianYuLuContentImageAdapter;
import com.xpy.administrator.probityeducation.model.ContentImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YuLuListActivity extends AppCompatActivity {
    @BindView(R.id.lv_yulu_list)
    ListView lvYuLuList;
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;


    private String[] yuLuContent=null;

    private TaoLianYuLuContentImageAdapter adapter;
    private List<ContentImageTitleModel> listYuLu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yu_lu_list);
        ButterKnife.bind(this);
        tvContentTitle.setText("陶行知语录");

        Bundle b =getIntent().getExtras();
        yuLuContent = b.getStringArray("yulu");

        listYuLu = new ArrayList<>();
        for (int i = 0; i < yuLuContent.length; i++) {
            listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"",yuLuContent[i]));
        }
        adapter = new TaoLianYuLuContentImageAdapter(this,listYuLu);
        lvYuLuList.setAdapter(adapter);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YuLuListActivity.this.finish();
            }
        });
    }
}
