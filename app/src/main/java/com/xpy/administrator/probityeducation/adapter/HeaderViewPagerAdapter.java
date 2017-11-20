package com.xpy.administrator.probityeducation.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/2.
 */

public class HeaderViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list = new ArrayList<Fragment>();
    private String[] titles;

    public HeaderViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public HeaderViewPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }

    public HeaderViewPagerAdapter(FragmentManager fm, List<Fragment> list, String[] titles) {
        super(fm);
        this.list = list;
        this.titles = titles;
    }

    public void addFragment(Fragment fragment) {
        list.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position < list.size()) {
            fragment = list.get(position);
        } else {
            fragment = list.get(0);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return list != null ? list.size() : 0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > 0)
            return titles[position];
        return null;
    }
}
