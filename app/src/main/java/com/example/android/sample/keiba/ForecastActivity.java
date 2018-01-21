package com.example.android.sample.keiba;


import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class ForecastActivity  extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG ="ForecastActivity" ;
    ArrayUserListAdapter setUsersAdapterlist;
    private FragmentPagerAdapter adapter;


    // スライド用の部品
    private ViewPager mPager;



    Button pushChatButton;
    Button pushMainButton;
    Button pushAccountButton;
    Button pushCalcButton;


    ListView usersListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);


        //viewPagerは使わない
//        mPager = (ViewPager) findViewById(R.id.viewpager);
//
//        adapter = new SampleFragmentPagerAdapter(getSupportFragmentManager());
//        mPager.setAdapter(adapter);





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

        ListViewSet();
    }





    ArrayList<UserAccount> usersAdapterlist;


    public void ListViewSet() {

        usersAdapterlist = new ArrayList<UserAccount>();



        UserAccount user = new UserAccount();

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.s135094276);

        user.setImageView(image);

        user.setScore("15point");
        user.setUsername("taichi");
        //user.setIdnumber("idnumber");
        usersAdapterlist.add(user);
        // 出力結果をリストビューに表示



        usersListView=(ListView)findViewById(R.id.users_list_view);
        setUsersAdapterlist = new ArrayUserListAdapter(ForecastActivity.this, usersAdapterlist);


            usersListView.setAdapter(setUsersAdapterlist);
            usersListView.setSelection(usersListView.getCount());


        user();
        user();
        user();

    }


    //commentではない、userをどんどん追加するメソッド、これでuserリストを作る
    public void user(){


        UserAccount user = new UserAccount();

        ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.s135094276);

        user.setImageView(image);
        user.setScore("15point");
        user.setUsername("taichi");
        //user.setIdnumber("idnumber");
        usersAdapterlist.add(user);

        ArrayUserListAdapter setUsersAdapterlist;
        usersListView=(ListView)findViewById(R.id.users_list_view);
        setUsersAdapterlist = new ArrayUserListAdapter(ForecastActivity.this, usersAdapterlist);
        usersListView.setAdapter(setUsersAdapterlist);
        usersListView.setSelection(usersListView.getCount());

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