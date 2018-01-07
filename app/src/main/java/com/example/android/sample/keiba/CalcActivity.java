package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager pager;


    Button pushChatButton;
    Button pushTotalButton;
    Button pushMainButton;
    Button pushAccountButton;

    //    レースのspinner
    Spinner idRaceSpinner;
    //    馬のspinner
    Spinner idHourseSpinner;


    private FragmentPagerAdapter adapter;

    private int currentPage;
    private String TAG="CalcActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        pushMainButton=(Button)findViewById(R.id.pushRaceOrderButton);
        pushAccountButton=(Button)findViewById(R.id.pushAccountButton);


        pushChatButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);



//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);
        idHourseSpinner=(Spinner) findViewById(R.id.hourseSpinner);

        firstRaceSpinner();
        firstHourseSpinner();



        pager = (ViewPager) findViewById(R.id.pager);

        adapter = new UserInfoViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        currentPage = 0;

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






    String raceSpinner[];
    public void firstRaceSpinner(){


        raceSpinner = new String[5];
        raceSpinner[0] = "桜花賞";
        raceSpinner[1] = "日本ダービー";
        raceSpinner[2] ="菊花賞";
        raceSpinner[3] ="天皇賞・秋";
        raceSpinner[4] ="有馬記念";

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


    public void onStart() {
        super.onStart();


//        レースのspinnerが押された時の対応
        idRaceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner nowRaceSpinner = (Spinner) parent;
                String item = (String) nowRaceSpinner.getSelectedItem();

                //クラス変数に入れる。今選択されていたspinnerを後で指定できるように
                int nowRaceSpinnerPosition = position;


//                spinner初回起動
                if (idRaceSpinner.isFocusable() == false) {
                    idRaceSpinner.setFocusable(true);
                    String activity = getIntent().getStringExtra("Activity");
                    if (item.equals("桜花賞")) {

                        Log.e(TAG, "1/6:初期化のspinnerで桜花賞が選択された");
                    }
                    return;
                }

//                選択を検知したspinnerごとの対応
                if (item.equals("日本ダービー")) {
                    String activity = getIntent().getStringExtra("Activity");

                    Log.e(TAG, "1/6:初期化のspinnerで日本ダービーが選択された");
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



        @Override
    public void onClick(View view) {

            Intent intent;

        switch (view.getId()) {
            case R.id.pushChatButton:

                //次のデータ入力画面にいくボタンが押されたので、処理する
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;

            //トータルスコアをみる
            case R.id.pushTotalButton:
                intent = new Intent(this, TotalActivity.class);
                startActivity(intent);
                break;

            case R.id.pushRaceOrderButton:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.pushAccountButton:
                intent= new Intent(this,AccountActivity.class);
                startActivity(intent);

        }
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


