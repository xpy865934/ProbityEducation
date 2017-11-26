package com.xpy.administrator.probityeducation.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.MyGridViewAdapter;
import com.xpy.administrator.probityeducation.model.ImageTitleModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ShuFaFragment extends Fragment {
    @BindView(R.id.gv_shufa)
    GridView gvShuFa;

    private List<ImageTitleModel> list;
    private MyGridViewAdapter adapter = null;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shu_fa, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<>();

        adapter = new MyGridViewAdapter(getActivity(), list);
        gvShuFa.setAdapter(adapter);
        new AdapterTask().execute();
    }

    public ShuFaFragment() {
    }


    public class AdapterTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            ImageTitleModel imageTitleModel1 = new ImageTitleModel(R.drawable.panyu, "17计科1潘宇");
            ImageTitleModel imageTitleModel2 = new ImageTitleModel(R.drawable.liumengyuan, "17计科4刘梦圆");
            ImageTitleModel imageTitleModel3 = new ImageTitleModel(R.drawable.chenyi, "17计科2陈怡");
            ImageTitleModel imageTitleModel4 = new ImageTitleModel(R.drawable.xueyang, "14数师3薛杨 ");
            ImageTitleModel imageTitleModel5 = new ImageTitleModel(R.drawable.yanjing, "14网工1严谨 ");
            ImageTitleModel imageTitleModel6 = new ImageTitleModel(R.drawable.liuhui, "14软工6刘慧 ");
            ImageTitleModel imageTitleModel7 = new ImageTitleModel(R.drawable.fanyuanyuan, "15软工6范圆圆 ");
            ImageTitleModel imageTitleModel8 = new ImageTitleModel(R.drawable.jihaimin, "17计科1嵇海民 ");
            //ImageTitleModel imageTitleModel9 = new ImageTitleModel(R.drawable.yujiaying, "17计科4余家颖");
            //ImageTitleModel imageTitleModel10 = new ImageTitleModel(R.drawable.shicheng, "14软转石城");

            //ImageTitleModel imageTitleModel11 = new ImageTitleModel(R.drawable.zhengjiaoyue, "14网工郑皎月");
            //ImageTitleModel imageTitleModel12 = new ImageTitleModel(R.drawable.chenlei, "14卓工2陈蕾");
            //ImageTitleModel imageTitleModel13 = new ImageTitleModel(R.drawable.wangxuechun, "17计科5王雪纯");
            //ImageTitleModel imageTitleModel14 = new ImageTitleModel(R.drawable.wangying, "17计科5王颖");
            ImageTitleModel imageTitleModel15 = new ImageTitleModel(R.drawable.suyifan, "17网工苏怡梵");
            ImageTitleModel imageTitleModel16 = new ImageTitleModel(R.drawable.zhuchengliang, "17数师1朱成樑");
            ImageTitleModel imageTitleModel17 = new ImageTitleModel(R.drawable.wutong, "17计科5吴彤");
            ImageTitleModel imageTitleModel18 = new ImageTitleModel(R.drawable.zhangliang, "15软转1张靓");
            ImageTitleModel imageTitleModel19 = new ImageTitleModel(R.drawable.yuyingchun, "17计科5于迎春");
            ImageTitleModel imageTitleModel20 = new ImageTitleModel(R.drawable.wangruiyue, "17计科4王睿玥");

            list.add(imageTitleModel1);
            list.add(imageTitleModel2);
            list.add(imageTitleModel3);
            list.add(imageTitleModel4);
            list.add(imageTitleModel5);
            list.add(imageTitleModel6);
            list.add(imageTitleModel7);
            list.add(imageTitleModel8);
//        list.add(imageTitleModel9);
//        list.add(imageTitleModel10);
//        list.add(imageTitleModel11);
//        list.add(imageTitleModel12);
//        list.add(imageTitleModel13);
//        list.add(imageTitleModel14);
            list.add(imageTitleModel15);
            list.add(imageTitleModel16);
            list.add(imageTitleModel17);
            list.add(imageTitleModel18);
            list.add(imageTitleModel19);
            list.add(imageTitleModel20);
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            adapter.notifyDataSetChanged();
        }
    }

}
