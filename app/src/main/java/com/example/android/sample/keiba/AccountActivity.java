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
import java.util.List;


public class AccountActivity extends Activity implements View.OnClickListener {



    //listのidとか、変数の名前だけ違うが、ArrayListAdapterを使うとこは同じで、同じrowdataを使う

    ArrayList<User> userCommentAdapterlist;

    User user;

    ArrayListAdapter setUserCommentAdapterlist;

    ListView idUserCommentListView;


    private String TAG="AccountActivity";


    Button pushChatButton;
    Button pushTotalButton;
    Button pushMainButton;
    Button pushCalcButton;

    //    レースのspinner
    Spinner idRaceSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);


//        下から持ってきた。毎度listを作ると文が更新されないため、user名もこのようにする
        userCommentAdapterlist = new ArrayList<>();
        user = new User();


        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        pushMainButton=(Button)findViewById(R.id.pushRaceOrderButton);


        pushChatButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushCalcButton.setOnClickListener(this);


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
        raceSpinner[1] = "桜花賞";
        raceSpinner[2] ="菊花賞";
        raceSpinner[3] ="天皇賞・秋";
        raceSpinner[4] ="有馬記念";
        raceSpinner[5] ="日本ダービー";

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

            //トータルスコアをみる
            case R.id.pushTotalButton:
                intent = new Intent(this, TotalActivity.class);
                startActivity(intent);
                break;

            case R.id.pushChatButton:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;


        }
    }
}
