package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends Activity implements View.OnClickListener {


    private static final String TAG ="ChatActivity" ;
    Button pushCalcButton;
    Button sentencePushbutton;
    Button pushRaceOrderButton;
    Button pushAccountButton;


    ArrayListAdapter setCommentAdapterlist;


//    レースのspinner
    Spinner idRaceSpinner;
//    馬のspinner
    Spinner idHourseSpinner;

    ArrayList<User> commentAdapterlist;

    ListView idCommentListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        sentencePushbutton=(Button)findViewById(R.id.sentencePushbutton);
        pushRaceOrderButton=(Button)findViewById(R.id.pushRaceOrderButton);
        pushAccountButton=(Button)findViewById(R.id.pushAccountButton);

        pushCalcButton.setOnClickListener(this);
        sentencePushbutton.setOnClickListener(this);
        pushRaceOrderButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);


//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);
        idHourseSpinner=(Spinner) findViewById(R.id.hourseSpinner);

        ListViewSet();

        firstRaceSpinner();
        firstHourseSpinner();

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

    //    ListViewSet
    public void ListViewSet() {

        commentAdapterlist = new ArrayList<>();
        User user = new User();
        user.setData("1/4 2:10");
        user.setUsername("taichi");
        user.setComment("武豊が一番悔しかったのは、有馬記念で最後刺されたことらしい。");
        //user.setIdnumber("idnumber");
        commentAdapterlist.add(user);
        // 出力結果をリストビューに表示


        idCommentListView=(ListView)findViewById(R.id.comment_list_view);
        setCommentAdapterlist = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
        idCommentListView.setAdapter(setCommentAdapterlist);
        idCommentListView.setSelection(idCommentListView.getCount());
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


            case R.id.sentencePushbutton:
                //EditTextのidから文字列を取得して、それをListに追加する。
                EditText edit = (EditText)findViewById(R.id.sentence);
                String text=edit.getText().toString();
                comment(text);
                edit.setText("");
                //入力されたたびに、Listを下まで下げる
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


    public void comment(String text){

        User user = new User();
        user.setData(nowTime());
        user.setUsername("taichi");
        user.setComment(text);
        commentAdapterlist.add(user);

        idCommentListView=(ListView)findViewById(R.id.comment_list_view);
        ArrayListAdapter adapter = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
        idCommentListView.setAdapter(adapter);
        idCommentListView.setSelection(idCommentListView.getCount());
    }

    public String nowTime(){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String nowTime = month + "/" + day + ":" + hour + ":" + minute +":"+ second;
        return nowTime;
    }


}
