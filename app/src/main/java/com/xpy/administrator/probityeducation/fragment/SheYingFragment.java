package com.xpy.administrator.probityeducation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyGridViewAdapter;
import com.xpy.administrator.probityeducation.model.ProductModel;
import com.xpy.administrator.probityeducation.utils.HttpCallBack;
import com.xpy.administrator.probityeducation.utils.HttpUtils;
import com.xpy.administrator.probityeducation.utils.MyImageDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SheYingFragment extends Fragment {
    @BindView(R.id.gv_sheying)
    GridView gvSheYing;

    private List<ProductModel> list;
    private MyGridViewAdapter adapter = null;
    private MyImageDialog myImageDialog;
    public SheYingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_she_ying, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();
        adapter = new MyGridViewAdapter(getActivity(), list);
        gvSheYing.setAdapter(adapter);

        HttpUtils.getInstances().httpJsonObjectRequest("/products_getAllByType.do", "{'type':'摄影'}", new HttpCallBack<List<ProductModel>>() {
            @Override
            public void onSuccess(List<ProductModel> data) {
                list.addAll(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String errorMsg) {
                Log.i("TAG", "onFail: "+errorMsg);
            }
        });

        gvSheYing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                myImageDialog = new MyImageDialog(getContext(),R.style.MyImageDialog,list.get(position));
                myImageDialog.show();
            }
        });
    }
}
