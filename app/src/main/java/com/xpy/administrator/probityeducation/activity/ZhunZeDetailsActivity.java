package com.xpy.administrator.probityeducation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.ImageTitleAdapter;
import com.xpy.administrator.probityeducation.bean.ImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhunZeDetailsActivity extends AppCompatActivity {

    @BindView(R.id.lv_zhun_ze_details)
    ListView lvZhunZeDetails;

    private ImageTitleAdapter adapter;
    private List<ImageTitleModel> list= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhun_ze_details);
        ButterKnife.bind(this);

        adapter = new ImageTitleAdapter(ZhunZeDetailsActivity.this,list);
        lvZhunZeDetails.setAdapter(adapter);
    }
}
