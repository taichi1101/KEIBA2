package com.example.android.sample.keiba;


import android.content.Intent;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;

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
    Button pushForecastButton;



    //    レースのspinner
    Spinner idRaceSpinner;
    //    馬のspinner
    Spinner idHourseSpinner;


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
        pushForecastButton=(Button)findViewById(R.id.pushForecastButton);

        pushChatButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);
        pushCalcButton.setOnClickListener(this);
        pushForecastButton.setOnClickListener(this);




//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);
        idHourseSpinner=(Spinner) findViewById(R.id.hourseSpinner);

        ListViewSet();

        firstRaceSpinner();
        firstHourseSpinner();

        ListViewSet();
    }




    String raceSpinner[];
    public void firstRaceSpinner(){


        //ここのspinnerは一つのものを参照したい spinnerを全部の画面で使っているので、参照する為のspinnerクラスを作る
        raceSpinner = new String[6];
        raceSpinner[0] = "全レース";
        raceSpinner[1] = "桜花賞 2017 12/24(日)";
        raceSpinner[2] ="菊花賞 2018 1/22(土)";
        raceSpinner[3] ="天皇賞・秋 2018 3/13(日)";
        raceSpinner[4] ="有馬記念 2018 5/23(土)";
        raceSpinner[5] ="日本ダービー 2018 10/4(土)";

//        この下のコードがあるとlistが表示されなくなり、ボタンが押せなくなる。とりあえず省いておく
        //このしたが、キーボードが押されないようにしてる
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //setContentView(R.layout.activity_chat);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // setSupportActionBar(toolbar);
        //toolbar.setTitle("");
        // mResolvingError = false;
        //nullになるから、ここでよんどく


//        spinnerを使うためここでセットする。セットしないとnullになる
        raceSpinnerAdapterSet();

    }

    String hourseSpinner[];
    public void firstHourseSpinner(){


        hourseSpinner = new String[5];
        hourseSpinner[0] = "キタサンブラック";
        hourseSpinner[1] = "サイレントスズカ";
        hourseSpinner[2] ="ディープインパクト";
        hourseSpinner[3] ="オルフェーブル";
        hourseSpinner[4] ="マカヒキ";

//        この下のコードがあるとlistが表示されなくなり、ボタンが押せなくなる。とりあえず省いておく
        //このしたが、キーボードが押されないようにしてる
        //getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //setContentView(R.layout.activity_chat);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // setSupportActionBar(toolbar);
        //toolbar.setTitle("");
        // mResolvingError = false;
        //nullになるから、ここでよんどく

//        spinnerを使うためここでセットする。セットしないとnullになる
        hourseSpinnerAdapterSet();

    }

    public void onStart(){
        super.onStart();


//        レースのspinnerが押された時の対応
        idRaceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner nowRaceSpinner = (Spinner) parent;
                String item = (String) nowRaceSpinner.getSelectedItem();

                //クラス変数に入れる。今選択されていたspinnerを後で指定できるように
                int nowRaceSpinnerPosition=position;


//                spinner初回起動
                if (idRaceSpinner.isFocusable() == false) {
                    idRaceSpinner.setFocusable(true);
                    String activity = getIntent().getStringExtra("Activity");
                    if (item.equals("桜花賞")) {

                        Log.e(TAG,"1/6:初期化のspinnerで桜花賞が選択された");
                    }
                    return;
                }

//                選択を検知したspinnerごとの対応
                if (item.equals("日本ダービー")) {
                    String activity = getIntent().getStringExtra("Activity");

                    Log.e(TAG,"1/6:初期化のspinnerで日本ダービーが選択された");
                }
            }
            //アイテムが選択されなかった

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//        spinnerItems = favorite.favorite(LocationActivity.this, username);//もしかしたら役に立つから、コメントを残す


//    馬のspinnerが押された時の対応

//        レースのspinnerが押された時の対応
        idHourseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner nowHourseSpinner = (Spinner) parent;
                String item = (String) nowHourseSpinner.getSelectedItem();

                //クラス変数に入れる。今選択されていたspinnerを後で指定できるように
                int nowHourseSpinnerPosition=position;


//                spinner初回起動
                if (idHourseSpinner.isFocusable() == false) {
                    idHourseSpinner.setFocusable(true);
                    String activity = getIntent().getStringExtra("Activity");
                    if (item.equals("キタサンブラック")) {

                        Log.e(TAG,"1/6:初期化のspinnerでキタサンブラックが選択された");
                    }
                    return;
                }

//                選択を検知したspinnerごとの対応
                if (item.equals("マカヒキ")) {
                    String activity = getIntent().getStringExtra("Activity");

                    Log.e(TAG,"1/6:初期化のspinnerでマカヒキが選択された");
                }
            }
            //アイテムが選択されなかった

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
//        spinnerItems = favorite.favorite(LocationActivity.this, username);//もしかしたら役に立つから、コメントを残す

    }


    //    名前が変な気もするが、spinnerItemsを更新した時に呼び出す
    public void raceSpinnerAdapterSet() {
        ArrayAdapter<String> raceSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,raceSpinner);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idRaceSpinner.setAdapter(raceSpinnerAdapter);
        idRaceSpinner.setFocusable(false);

    }

//    一応馬用のAdapterSetも作る

    public void hourseSpinnerAdapterSet() {
        ArrayAdapter<String> hourseSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,hourseSpinner);
        hourseSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idHourseSpinner.setAdapter(hourseSpinnerAdapter);
        idHourseSpinner.setFocusable(false);

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



        //違うlistviewもセットしておく
        usersListView=(ListView)findViewById(R.id.users_list_view_score);
        setUsersAdapterlist = new ArrayUserListAdapter(ForecastActivity.this, usersAdapterlist);

        usersListView.setAdapter(setUsersAdapterlist);
        usersListView.setSelection(usersListView.getCount());



        //違うlistviewもセットしておく
        usersListView=(ListView)findViewById(R.id.users_list_view_friend);
        setUsersAdapterlist = new ArrayUserListAdapter(ForecastActivity.this, usersAdapterlist);

        usersListView.setAdapter(setUsersAdapterlist);
        usersListView.setSelection(usersListView.getCount());


        user();
        user();
        user();

        user();
        user();
        user();

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
                break;

            case R.id.pushCalcButton:
                intent = new Intent(this, CalcActivity.class);
                startActivity(intent);
                break;

            case R.id.pushForecastButton:
                intent = new Intent(this,ForecastActivity.class);
                startActivity(intent);
                break;



        }
    }
}