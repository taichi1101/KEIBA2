package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainActivity extends Activity implements View.OnClickListener {



    private static final String TAG ="MainActivity";
    Button pushCalcButton;
    Button pushTotalButton;
    Button pushChatButton;
    Button pushAccountButton;

    //    レースのspinner
    Spinner idRaceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ここでやることは、ボタンを押したときにその項目の文字を入れたEditTextを表示して、
        //上下左右のスワイプへの対応として、その方向の文字を表示させる。
        //そのときにめくるようなUIはいらない。あえて、文字だけ変えさせたい
        //文字サイズは考慮しなくていい

        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushAccountButton=(Button)findViewById(R.id.pushAccountButton);

        pushCalcButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        pushChatButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);


        //        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);
        firstRaceSpinner();
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



    @Override
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

    }


        @Override
    public void onClick(View view) {


            Intent intent;

        switch (view.getId()) {
            case R.id.pushCalcButton:


                //次のデータ入力画面にいくボタンが押されたので、処理する
                intent = new Intent(this, CalcActivity.class);
                startActivity(intent);
                break;

                //トータルスコアをみる
            case R.id.pushTotalButton:
                intent = new Intent(this, TotalActivity.class);
                startActivity(intent);
                break;

            case R.id.pushChatButton:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;


            case R.id.pushAccountButton:
                intent = new Intent(this,AccountActivity.class);
                startActivity(intent);
                break;



        }
    }

}
