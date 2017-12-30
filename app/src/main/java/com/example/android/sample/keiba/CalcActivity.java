package com.example.android.sample.keiba;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;




public class CalcActivity extends AppCompatActivity {

    private ViewPager pager;

    private FragmentPagerAdapter adapter;

    private int currentPage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);



        pager = (ViewPager) findViewById(R.id.pager);

        adapter = new UserInfoViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        currentPage = 0;

    }
//ここをなくすと、余計なボタンがなくなっていい
//    public void onClickNext(View view) {
//        currentPage ++;
//        pager.setCurrentItem(currentPage);
//    }
//
//    public void onClickGoToTop(View view) {
//        currentPage = 0;
//        pager.setCurrentItem(currentPage);
//    }
}


