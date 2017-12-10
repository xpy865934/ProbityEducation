package com.xpy.administrator.probityeducation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.StoryContentImageTitleAdapter;
import com.xpy.administrator.probityeducation.model.ContentImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class StoryListActivity extends AppCompatActivity {
    @BindView(R.id.lv_story_list)
    ListView lvStoryList;
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.iv_back)
    ImageView ivBack;


    private String[] storyTitle=null;
    private String[] storyContent=null;

    private StoryContentImageTitleAdapter adapter;
    private List<ContentImageTitleModel> listStories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_list);
        ButterKnife.bind(this);

        tvContentTitle.setText("陶行知小故事");

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoryListActivity.this.finish();
            }
        });

        listStories= new ArrayList<>();
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        if(b!=null){
            storyTitle = b.getStringArray("title");
            storyContent = b.getStringArray("content");
            if(storyContent!=null&&storyTitle!=null){
                for (int i = 0; i <storyTitle.length ; i++) {
                    listStories.add(new ContentImageTitleModel(R.drawable.zhunze1,storyTitle[i],storyContent[i]));
                }
            }
        }
        adapter = new StoryContentImageTitleAdapter(StoryListActivity.this,listStories);
        lvStoryList.setAdapter(adapter);
    }

    @OnItemClick(R.id.lv_story_list)
    public void storyItemOnClick(int position){
        Intent intent = new Intent(StoryListActivity.this, StoryDetailsActivity.class);
        Bundle b = new Bundle();
        b.putString("title",storyTitle[position]);
        b.putString("content",storyContent[position]);
        intent.putExtras(b);
        startActivity(intent);
    }
}
