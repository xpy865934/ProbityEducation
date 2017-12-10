package com.xpy.administrator.probityeducation.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.activity.StoryDetailsActivity;
import com.xpy.administrator.probityeducation.activity.StoryListActivity;
import com.xpy.administrator.probityeducation.activity.YuLuListActivity;
import com.xpy.administrator.probityeducation.adapter.StoryContentImageTitleAdapter;
import com.xpy.administrator.probityeducation.adapter.TaoLianYuLuContentImageAdapter;
import com.xpy.administrator.probityeducation.model.ContentImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class TaoLianFragment extends Fragment {
    @BindView(R.id.tv_content_title)
    TextView tvContentTitle;
    @BindView(R.id.lv_t_yulu)
    ListView lvTYuLu;
    @BindView(R.id.lv_t_stories)
    ListView lvTStories;
    @BindView(R.id.tv_yulu_more)
    TextView tvYuLuMore;
    @BindView(R.id.tv_story_more)
    TextView tvStoryMore;

    @BindArray(R.array.arr_taolian_story_title)
    String[] taoLianStoryTitle;

    @BindArray(R.array.arr_taolian_story_content)
    String[] taoLianStoryContent;

    @BindArray(R.array.arr_taolian_yulu_content)
    String[] yuLuContent;


    private List<ContentImageTitleModel> listYuLu;
    private List<ContentImageTitleModel> listStories;

    private TaoLianYuLuContentImageAdapter yuLuAdapter;
    private StoryContentImageTitleAdapter storyAdapter;

    public TaoLianFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_taolian, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tvContentTitle.setText("陶廉");

        listYuLu = new ArrayList<>();
        listStories= new ArrayList<>();
        listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"",yuLuContent[0]));
        listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"",yuLuContent[1]));
        listStories.add(new ContentImageTitleModel(R.drawable.zhunze1,taoLianStoryTitle[0],taoLianStoryContent[0]));
        listStories.add(new ContentImageTitleModel(R.drawable.taolian,taoLianStoryTitle[1],taoLianStoryContent[1]));
        yuLuAdapter = new TaoLianYuLuContentImageAdapter(getContext(),listYuLu);
        lvTYuLu.setAdapter(yuLuAdapter);
        storyAdapter = new StoryContentImageTitleAdapter(getContext(),listStories);
        lvTStories.setAdapter(storyAdapter);
    }

    @OnClick(R.id.tv_yulu_more)
    public void yuLuOnClick(View view){
        Intent intent = new Intent(getActivity(), YuLuListActivity.class);
        Bundle b = new Bundle();
        b.putStringArray("yulu",yuLuContent);
        intent.putExtras(b);
        startActivity(intent);
    }

    @OnClick(R.id.tv_story_more)
    public void storyOnClick(View view){
        Intent intent = new Intent(getActivity(), StoryListActivity.class);
        Bundle b = new Bundle();
        b.putStringArray("title",taoLianStoryTitle);
        b.putStringArray("content",taoLianStoryContent);
        intent.putExtras(b);
        startActivity(intent);
    }

    @OnItemClick(R.id.lv_t_stories)
    public void storyItemOnClick(int position){
        Intent intent = new Intent(getActivity(), StoryDetailsActivity.class);
        Bundle b = new Bundle();
        b.putString("title",taoLianStoryTitle[position]);
        b.putString("content",taoLianStoryContent[position]);
        intent.putExtras(b);
        startActivity(intent);
    }
}
