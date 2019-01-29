package com.example.beatrice.globonews;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TabListener {
    private static ViewPager viewPager;
    private static ActionBar actionBar;
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {

        viewPager =  findViewById(R.id.pager);

        fragmentManager = getSupportFragmentManager();

        viewPager.setAdapter(new MyAdapter(fragmentManager));

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int pos) {

                actionBar.setSelectedNavigationItem(pos);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });

    }

//    private void setTabs() {
//        // Getting actionbar
//        actionBar = getSupportActionBar();
//
//        if (actionBar != null) {
//
//            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        }
//
//        android.support.v7.app.ActionBar.Tab tab1 = actionBar.newTab();
//        tab1.setText("RecyclerView");
//        tab1.setTabListener(this);
//
//
//        actionBar.addTab(tab1);
//
//    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction arg1) {
        // Setting current position of tab to view pager
        viewPager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {


    }

    // My adapter i.e. custom adapter for displaying fragments over view pager
    private class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);

        }

        @Override
        public Fragment getItem(int i) {

            // Getting fragments according to selected position
            Fragment fragment = null;
            if (i == 0) {
                fragment = new MainFragment();
            }

            // and finally returning fragments
            return fragment;
        }

        @Override
        public int getCount() {

            // Returning no. of counts of fragments
            return 1;
        }
    }

}