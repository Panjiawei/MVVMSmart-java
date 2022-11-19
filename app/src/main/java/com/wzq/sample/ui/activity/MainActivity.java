package com.wzq.sample.ui.activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.wzq.sample.R;
import com.wzq.sample.base.BaseActivity;
import com.wzq.sample.base.BaseViewModel;
import com.wzq.sample.bean.TabEntity;
import com.wzq.sample.databinding.ActivityMainBinding;
import com.wzq.sample.ui.example.tab_bar.fragment.TabBar1Fragment;
import com.wzq.sample.ui.example.tab_bar.fragment.TabBar2Fragment;
import com.wzq.sample.ui.example.tab_bar.fragment.TabBar3Fragment;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity<ActivityMainBinding, BaseViewModel> {

    List<Fragment> fragments;
    VpAdapter adapter;
    View secondTab;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }

    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_main;
    }


    @Override
    public void initData() {
        super.initData();
        initView();
        initfragments();


        binding.tl.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {

                    binding.vp.setCurrentItem(position);


            }

            @Override
            public void onTabReselect(int position) {

            }
        });
        binding.vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                binding.tl.setCurrentTab(position);


            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        binding.vp.setCurrentItem(0);

    }

    private void initView() {
        mTabEntities.add(new TabEntity("首页", R.mipmap.shouye, R.mipmap.shouye1));
        mTabEntities.add(new TabEntity("客户管理", R.mipmap.kehuguanli, R.mipmap.kehuguanli1));
       // mTabEntities.add(new TabEntity("健康档案", R.mipmap.analysis, R.mipmap.analysis1));
        mTabEntities.add(new TabEntity("我的", R.mipmap.wode, R.mipmap.wode1));
        binding.tl.setTabData(mTabEntities);

    }

    private void initfragments() {
        fragments = new ArrayList<>(4);

        TabBar1Fragment homeFragment = new TabBar1Fragment();

        TabBar2Fragment housekeeperFragment = new TabBar2Fragment();

        // AnalysisFragment analysisFragment = new AnalysisFragment();
        TabBar3Fragment analysisFragment = new TabBar3Fragment();

       // TabBar4Fragment personalFragment = new TabBar4Fragment();
        // add to fragments for adapter
        fragments.add(homeFragment);
        fragments.add(housekeeperFragment);
        fragments.add(analysisFragment);
        //fragments.add(personalFragment);

        // set adapter
        adapter = new VpAdapter(getSupportFragmentManager(), fragments);
        binding.vp.setOffscreenPageLimit(3);
        binding.vp.setAdapter(adapter);
        if (getIntent().getBooleanExtra("goSecondTab", false)) {
            binding.vp.setCurrentItem(1);
        }
    }


    private static class VpAdapter extends FragmentPagerAdapter {
        private List<Fragment> data;

        public VpAdapter(FragmentManager fm, List<Fragment> data) {
            super(fm);
            this.data = data;
        }

        @Override
        public int getItemPosition(Object object) {//最主要就是加了这个方法。
            return POSITION_NONE;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Fragment getItem(int position) {
            return data.get(position);
        }

    }


    @Override
    public int initVariableId() {
        return com.wzq.sample.BR.viewModel;
    }
}