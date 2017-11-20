package com.xpy.administrator.probityeducation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.HeaderViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ZuoPinFragment extends Fragment {
    @BindView(R.id.viewpager1)
    ViewPager mViewPager;
    @BindView(R.id.header_tablayout)
    TabLayout mHeaderTabLayout;

    private List<Fragment> list =null;
    @BindArray(R.array.arr_header_menu)
    String[] titles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_zuopin, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    public ZuoPinFragment() {
        // Required empty public constructor
    }


    private void initView() {
        setViewPager(mViewPager);
        mHeaderTabLayout.setupWithViewPager(mViewPager);
    }

    private void setViewPager(ViewPager mViewPager) {
        list = new ArrayList<>();
        list.add(new ShuFaFragment());
        list.add(new HuiHuaFragment());
        list.add(new PingBaoFragment());
        list.add(new WangYeFragment());
        list.add(new PPTFragment());
        HeaderViewPagerAdapter adapter = new HeaderViewPagerAdapter(getActivity().getSupportFragmentManager(),list,titles);
        mViewPager.setAdapter(adapter);
    }
}
