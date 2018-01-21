package com.example.android.sample.keiba;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ForecastActivity  extends AppCompatActivity implements View.OnClickListener {


    private FragmentPagerAdapter adapter;


    // スライド用の部品
    private ViewPager mPager;



    Button pushChatButton;
    Button pushMainButton;
    Button pushAccountButton;
    Button pushCalcButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);
        mPager = (ViewPager) findViewById(R.id.viewpager);

        adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(adapter);
//        currentPage = 0;  使われてない

//        //ページ切り替え用のFragmentのAdapterは複数作る必要がありそう。前のは使えない
//        mPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
//                ForecastActivity.this));
        // 上部にタブをセットする
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//        tabLayout.setupWithViewPager(mPager);


        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushMainButton=(Button)findViewById(R.id.pushRaceOrderButton);
        pushAccountButton=(Button)findViewById(R.id.pushAccountButton);
        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);

        pushChatButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);
        pushCalcButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        Intent intent;


        switch (view.getId()) {
            case R.id.pushChatButton:

                //次のデータ入力画面にいくボタンが押されたので、処理する
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;

            case R.id.pushRaceOrderButton:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.pushAccountButton:
                intent = new Intent(this, AccountActivity.class);
                startActivity(intent);

            case R.id.pushCalcButton:
                intent = new Intent(this, CalcActivity.class);
                startActivity(intent);

        }
    }
}