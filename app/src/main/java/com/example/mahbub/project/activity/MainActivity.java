package com.example.mahbub.project.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.mahbub.project.R;
import com.example.mahbub.project.mFragments.FragmentProgramming;
import com.example.mahbub.project.mFragments.FragmentDataStructure;
import com.example.mahbub.project.mFragments.FragmentNetworking;
import com.example.mahbub.project.mFragments.FragmentEnglish;
import com.example.mahbub.project.mFragments.FragmentbookLink;
import com.example.mahbub.project.mFragments.Fragmentmath;
import com.example.mahbub.project.mFragments.MyPagerAdapter;

public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    ViewPager vp;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        vp = (ViewPager) findViewById(R.id.mViewpager_ID);
        this.addPages();
        tabLayout = (TabLayout) findViewById(R.id.mTab_ID);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setupWithViewPager(vp);
        tabLayout.setOnTabSelectedListener(this);
    }

    private void addPages() {
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(this.getSupportFragmentManager());
        pagerAdapter.addFragment(new FragmentProgramming());
        pagerAdapter.addFragment(new FragmentDataStructure());
        pagerAdapter.addFragment(new FragmentNetworking());
        pagerAdapter.addFragment(new FragmentEnglish());
        pagerAdapter.addFragment(new Fragmentmath());
        pagerAdapter.addFragment(new FragmentbookLink());



        vp.setAdapter(pagerAdapter);
    }

    public void onTabSelected(TabLayout.Tab tab) {
        vp.setCurrentItem(tab.getPosition());
    }



    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    public void TestUpload(){
        int i = 1+1;
    }
}