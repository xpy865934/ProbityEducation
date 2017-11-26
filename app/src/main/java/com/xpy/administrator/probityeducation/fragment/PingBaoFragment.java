package com.xpy.administrator.probityeducation.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpy.administrator.probityeducation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PingBaoFragment extends Fragment {


    public PingBaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("TAG", "onCreateView: ");
        return inflater.inflate(R.layout.fragment_ping_bao, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("TAG", "onActivityCreated: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy: ");
    }
}
