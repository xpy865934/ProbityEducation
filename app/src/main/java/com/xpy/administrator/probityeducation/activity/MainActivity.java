package com.xpy.administrator.probityeducation.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.xpy.administrator.probityeducation.BottomNavigationHelp;
import com.xpy.administrator.probityeducation.R;
import com.xpy.administrator.probityeducation.adapter.ViewPagerAdapter;
import com.xpy.administrator.probityeducation.fragment.TaoLianFragment;
import com.xpy.administrator.probityeducation.fragment.MingGuiFragment;
import com.xpy.administrator.probityeducation.fragment.LianJieFragment;
import com.xpy.administrator.probityeducation.fragment.ZuoPinFragment;


public class MainActivity extends AppCompatActivity {
    private ViewPager mViewPager=null;
    private BottomNavigationView mBottomNavigationView=null;
    private MenuItem menuItem=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        //默认>3的选中效果会影响viewPager的滑动切换时的效果，故利用反射去掉
        BottomNavigationHelp.disableShiftMode(mBottomNavigationView);
        //导航切换
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item_minggui:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.item_taolian:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.item_lianjie:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.item_zuopin:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(menuItem!=null){
                    menuItem.setChecked(false);
                }else{
                    mBottomNavigationView.getMenu().getItem(0).setCheckable(true);
                }
                menuItem = mBottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //禁止viewPage滑动
//        mViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                return true;
//            }
//        });
        
        setViewPager(mViewPager);
    }

    private void setViewPager(ViewPager mViewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MingGuiFragment());
        adapter.addFragment(new TaoLianFragment());
        adapter.addFragment(new LianJieFragment());
        adapter.addFragment(new ZuoPinFragment());
        mViewPager.setAdapter(adapter);
    }


}
