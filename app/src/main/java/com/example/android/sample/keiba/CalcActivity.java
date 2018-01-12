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

import java.util.ArrayList;


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


    //10択ボタンの変数
    Button pushCalc_button_1;
    Button pushCalc_button_2;
    Button pushCalc_button_3;
    Button pushCalc_button_4;
    Button pushCalc_button_5;
    Button pushCalc_button_6;
    Button pushCalc_button_7;
    Button pushCalc_button_8;
    Button pushCalc_button_9;
    Button pushCalc_button_10;


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

        pushCalc_button_1=(Button)findViewById(R.id.calc_button_1);
        pushCalc_button_2=(Button)findViewById(R.id.calc_button_2);
        pushCalc_button_3=(Button)findViewById(R.id.calc_button_3);
        pushCalc_button_4=(Button)findViewById(R.id.calc_button_4);
        pushCalc_button_5=(Button)findViewById(R.id.calc_button_5);
        pushCalc_button_6=(Button)findViewById(R.id.calc_button_6);
        pushCalc_button_7=(Button)findViewById(R.id.calc_button_7);
        pushCalc_button_8=(Button)findViewById(R.id.calc_button_8);
        pushCalc_button_9=(Button)findViewById(R.id.calc_button_9);
        pushCalc_button_10=(Button)findViewById(R.id.calc_button_10);

        pushChatButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);

        pushCalc_button_1.setOnClickListener(this);
        pushCalc_button_2.setOnClickListener(this);
        pushCalc_button_3.setOnClickListener(this);
        pushCalc_button_4.setOnClickListener(this);
        pushCalc_button_5.setOnClickListener(this);
        pushCalc_button_6.setOnClickListener(this);
        pushCalc_button_7.setOnClickListener(this);
        pushCalc_button_8.setOnClickListener(this);
        pushCalc_button_9.setOnClickListener(this);
        pushCalc_button_10.setOnClickListener(this);



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


            case R.id.calc_button_1:
                //ボタン１が押された時は、spinnerから今の馬とレース名を取得して、そこに1をセットする
                //それの繰り返し。
                //テキストじゃない、listにaddして、次の画面にスライドさせる
                //まず、このlistが偽物になってるから、動的に変更できるものに変える

                //ここで値を送って、メソッドでspinnerの値を取得してlistに追加するコードを作る

                getSpinnerAddNumber(1);

            case R.id.calc_button_2:

            case R.id.calc_button_3:

            case R.id.calc_button_4:

            case R.id.calc_button_5:

            case R.id.calc_button_6:

            case R.id.calc_button_7:

            case R.id.calc_button_8:

            case R.id.calc_button_9:

            case R.id.calc_button_10:

        }
    }

    public void getSpinnerAddNumber(int number){

        // Spinnerオブジェクトを取得
        Spinner raceSpinner = (Spinner)findViewById(R.id.raceSpinner);

        // 選択されているアイテムのIndexを取得
        int raceSpinnerIdx = raceSpinner.getSelectedItemPosition();

        // 選択されているアイテムを取得
        String raceSppinerItem = (String)raceSpinner.getSelectedItem();



        // Spinnerオブジェクトを取得
        Spinner hourseSpinner = (Spinner)findViewById(R.id.hourseSpinner);

        // 選択されているアイテムのIndexを取得
        int hourseSpinnerIdx = hourseSpinner.getSelectedItemPosition();

        // 選択されているアイテムを取得
        String hourseSpinnerItem = (String)hourseSpinner.getSelectedItem();


        //hourseで、選択されている値をnumberと連結して、textにセットする。


                String numberString=String.valueOf(number);

        String hoursename_and_number=hourseSpinnerItem+numberString;

        //この値を、配列に追加する。
        // その配列をforで回して、表示している

        //これらのデータの識別には、まずレース名が必要で、次にuser名が必要(自分が何を入力したかを把握する必要があるから)、そして、hoursename_and_numberが必要
        //とりあえずusernameはtaichi
        //項目名も必要。これは、今はfragmentのどこにいるかどうか？を把握する必要がある。
        //

       // ArrayList<String>

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


