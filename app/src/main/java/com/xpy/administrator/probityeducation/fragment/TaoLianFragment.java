package com.xpy.administrator.probityeducation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.YuLuAndStoryContentImageTitleAdapter;
import com.xpy.administrator.probityeducation.model.ContentImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    private List<ContentImageTitleModel> listYuLu;
    private List<ContentImageTitleModel> listStories;

    private YuLuAndStoryContentImageTitleAdapter yuLuAdapter;
    private YuLuAndStoryContentImageTitleAdapter storyAdapter;

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
        listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        listYuLu.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        listStories.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        listStories.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        listStories.add(new ContentImageTitleModel(R.drawable.taolian,"1","1"));
        yuLuAdapter = new YuLuAndStoryContentImageTitleAdapter(getContext(),listYuLu);
        lvTYuLu.setAdapter(yuLuAdapter);
        storyAdapter = new YuLuAndStoryContentImageTitleAdapter(getContext(),listStories);
        lvTStories.setAdapter(storyAdapter);
    }
}
