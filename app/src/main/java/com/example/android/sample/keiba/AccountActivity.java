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
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AccountActivity extends Activity implements View.OnClickListener {



    //listのidとか、変数の名前だけ違うが、ArrayListAdapterを使うとこは同じで、同じrowdataを使う

    ArrayList<User> userCommentAdapterlist;

    User user;

    ArrayListAdapter setUserCommentAdapterlist;

    ListView idUserCommentListView;


    private String TAG="AccountActivity";


    Button pushChatButton;
    Button pushMainButton;
    Button pushCalcButton;

    Button forecast_purchase;

    //    レースのspinner
    Spinner idRaceSpinner;


    //トータルのスコア
    int totalNowSpinnerArrayListScore;


    State state=new State();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //ここで、databaseから取得するようにしとけば、全てを出力できる。
        //Accountが呼ばれるたびに表示できる。

        //一番最後のレースを送るのは違う。
        //一番最後に入力したデータを送るようにする。
        //timeで、いつ入力したのかを記入する？
        //それか、とりあえずは、stateで、Calc==finishかどうか？をチェックする

        if(state.isCalcFinish()){

            //calcがfinishして、ここが呼び出された場合は、この中で処理をする

            Log.e(TAG,"AccountActivityのonCreate()");
            //ここで、Calcで、作られたfragmentと値のmapをintentで受け取って、HashMapに変換してる
            Intent i = getIntent();
            HashMap<String, String> nowSpinnerArrayList = (HashMap<String, String>) i.getSerializableExtra("nowSpinnerArrayList");

            //この下で、配列にして、それをリストにセット、このようにdatabaseからやり取りをしなくても、流れの中で使うなら、intentでもできる。
            for(String val : nowSpinnerArrayList.values()) {
                Log.e(TAG,"AccountActivityのonCreate()のfor文の中");

                //別にkeyを取得しなくてもいいから、とりあえず先に進める
//            for (int i = 0; i < nowSpinnerArrayList.size(); i++) {
//                String val =nowSpinnerArrayList.get(i).values().toString();

                // System.out.println(val);

                int intVal = Integer.parseInt(val);
                Log.e(TAG, "Integer.parseInt(val)は:" + intVal);
                Log.e(TAG, "totalNowSpinnerArrayListScore たす前:" + totalNowSpinnerArrayListScore);
                totalNowSpinnerArrayListScore = totalNowSpinnerArrayListScore + intVal;
                Log.e(TAG, "totalNowSpinnerArrayListScore 足したあと:" + totalNowSpinnerArrayListScore);
            }

            //終わったらfalseをsetする
            state.setCalcFinish(false);
        }






//        下から持ってきた。毎度listを作ると文が更新されないため、user名もこのようにする
        userCommentAdapterlist = new ArrayList<>();
        user = new User();


        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushMainButton=(Button)findViewById(R.id.pushRaceOrderButton);

        forecast_purchase=(Button)findViewById(R.id.forecast_purchase);


        pushChatButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushCalcButton.setOnClickListener(this);

        forecast_purchase.setOnClickListener(this);


//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);

        firstRaceSpinner();

        ListViewSet();
        ListViewSet();
        ListViewSet();
        ListViewSet();
        ListViewSet();
        ListViewSet();
        ListViewSet();
        ListViewSet();
    }




    String raceSpinner[];
    public void firstRaceSpinner(){


//        この下のspinnerの数は可変にするためにはNew3のコードを見る

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


    //    名前が変な気もするが、spinnerItemsを更新した時に呼び出す
    public void raceSpinnerAdapterSet() {
        ArrayAdapter<String> raceSpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,raceSpinner);
        raceSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idRaceSpinner.setAdapter(raceSpinnerAdapter);
        idRaceSpinner.setFocusable(false);

    }


    @Override
    public void onStart(){
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
                    if (item.equals("全レース")) {


                        Log.e(TAG, "1/6:初期化のspinnerで全レースが選択された");
                    }
                    return;
                }

//                選択を検知したspinnerごとの対応
                if (item.equals("日本ダービー 2018 10/4(土)")) {
                    String activity = getIntent().getStringExtra("Activity");

                    Log.e(TAG, "1/6:初期化のspinnerで日本ダービー 2018 10/4(土)が選択された");
                }
            }
            //アイテムが選択されなかった

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//        spinnerItems = favorite.favorite(LocationActivity.this, username);//もしかしたら役に立つから、コメントを残す

    }




    //    ListViewSet
    public void ListViewSet() {


        user.setData("1/4 2:10");
        user.setUsername("taichi");
        user.setComment("武豊が一番悔しかったのは、有馬記念で最後刺されたことらしい。");
        //user.setIdnumber("idnumber");
        userCommentAdapterlist.add(user);
        // 出力結果をリストビューに表示


        idUserCommentListView=(ListView)findViewById(R.id.user_comment_list_view);
        setUserCommentAdapterlist = new ArrayListAdapter(AccountActivity.this, userCommentAdapterlist);
        idUserCommentListView.setAdapter(setUserCommentAdapterlist);
        idUserCommentListView.setSelection(idUserCommentListView.getCount());
    }



    @Override
    public void onClick(View view) {


        Intent intent;

        switch (view.getId()) {

            case R.id.pushRaceOrderButton:

                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.pushCalcButton:


                //次のデータ入力画面にいくボタンが押されたので、処理する
                intent = new Intent(this, CalcActivity.class);
                startActivity(intent);
                break;

            case R.id.pushChatButton:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;


            case R.id.forecast_purchase:
                intent = new Intent(this,ForecastActivity.class);
                startActivity(intent);
                break;

        }
    }
}
