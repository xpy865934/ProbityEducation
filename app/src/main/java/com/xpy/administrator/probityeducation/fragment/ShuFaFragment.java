package com.xpy.administrator.probityeducation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyGridViewAdapter;
import com.xpy.administrator.probityeducation.bean.ImageTitleModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShuFaFragment extends Fragment {
    @BindView(R.id.gv_shufa)
    GridView gvShuFa;

    private List<ImageTitleModel> list;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_shu_fa, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        MyGridViewAdapter adapter = new MyGridViewAdapter(getActivity(),list);
        gvShuFa.setAdapter(adapter);
    }

    public ShuFaFragment() {}


}
