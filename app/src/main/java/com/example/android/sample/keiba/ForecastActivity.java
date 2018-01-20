package com.example.android.sample.keiba;


import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ForecastActivity  extends AppCompatActivity {




    // スライド用の部品
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        mPager = (ViewPager) findViewById(R.id.viewpager);

        //ページ切り替え用のFragmentのAdapterは複数作る必要がありそう。前のは使えない
        mPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                ForecastActivity.this));
        // 上部にタブをセットする
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mPager);
    }
}