package com.xpy.administrator.probityeducation.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.activity.ZhunZeDetailsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MingGuiFragment extends Fragment {
    @BindView(R.id.img_minggui_item1)
    ImageView imgMingGuiItem1;
    @BindView(R.id.img_minggui_item2)
    ImageView imgMingGuiItem2;
    @BindView(R.id.img_minggui_item3)
    ImageView imgMingGuiItem3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_minggui, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    public MingGuiFragment() {
        // Required empty public constructor
    }

    @OnClick(R.id.img_minggui_item1)
    public void item1Click(View view){
        Intent intent = new Intent(getActivity(), ZhunZeDetailsActivity.class);
        startActivity(intent);
    }
}
