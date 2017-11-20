package com.xpy.administrator.probityeducation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> list=new ArrayList<Fragment>();
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list=list;
    }

    public void addFragment(Fragment fragment){
        list.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list!=null?list.size():0;
    }
}
