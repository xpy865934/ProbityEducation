package com.xpy.administrator.probityeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.ZhunZeImageTitleAdapter;
import com.xpy.administrator.probityeducation.model.ContentImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhunZeListActivity extends AppCompatActivity {

    @BindView(R.id.lv_zhun_ze_details)
    ListView lvZhunZeDetails;
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    private ZhunZeImageTitleAdapter adapter;
    private List<ContentImageTitleModel> list= new ArrayList<>();
    private int[] img_id = {R.drawable.zhunze1,R.drawable.zhunze2,R.drawable.zhunze3,
            R.drawable.zhunze4,R.drawable.zhunze5,R.drawable.zhunze6,R.drawable.zhunze7,R.drawable.zhunze8};

    @BindArray(R.array.arr_zhunze)
    String zhunze[];

    @BindArray(R.array.arr_zhunze_details)
    String zhunzeDetails[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhun_ze_details);
        ButterKnife.bind(this);

        tvContentTitle.setText("准则");

        for (int i = 0; i < img_id.length; i++) {
            String detail = zhunzeDetails[i];
            if(detail.length()>54){
                detail = detail.substring(0,51)+"...";
            }
            ContentImageTitleModel contentImageTitleModel = new ContentImageTitleModel(img_id[i],zhunze[i],detail);
            list.add(contentImageTitleModel);
        }

        adapter = new ZhunZeImageTitleAdapter(ZhunZeListActivity.this,list);
        lvZhunZeDetails.setAdapter(adapter);

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ZhunZeListActivity.this.finish();
            }
        });

        lvZhunZeDetails.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ZhunZeListActivity.this,ZhunZeContentActivity.class);
                Bundle b = new Bundle();
                b.putInt("id",position);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
