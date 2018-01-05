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
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends Activity implements View.OnClickListener{


    private static final String TAG ="ChatActivity" ;
    Button pushCalcButton;
    Button pushTotalButton;
    Button sentencePushButton;


    ArrayListAdapter setCommentAdapterlist;
    ListView idCommentListView;

    //この上で作った配列を下でArrayAdapterを作ってセットしている
    //そのため、EditTextから、この配列にaddするコードにする
    //ただし、ただ配列をセットしても、あのxmlには当てはまらない。どうするのか？



    Spinner idRaceSpinner;

    ArrayList<User> commentAdapterlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);



//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);

//        listView
        idCommentListView=(ListView)findViewById(R.id.comment_list_view);

//        button
        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        sentencePushButton=(Button)findViewById(R.id.sentencePushbutton);

        pushCalcButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        sentencePushButton.setOnClickListener(this);


//        サンプルのListViewを作ってる
        ListViewSet();


//        スピナーの初期化
        firstRaceSpinner();




        //ここでやることは、ボタンを押したときにその項目の文字を入れたEditTextを表示して、
        //上下左右のスワイプへの対応として、その方向の文字を表示させる。
        //そのときにめくるようなUIはいらない。あえて、文字だけ変えさせたい
        //文字サイズは考慮しなくていい

    }



    @Override
    public void onStart(){
        super.onStart();


        idRaceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Spinner spinner = (Spinner) parent;
                String spinnerRaceItem = (String) spinner.getSelectedItem();

                //クラス変数に入れる。今選択されていたspinnerを後で指定できるように

//                わからなくなるからとりあえずローカル
                int spinnerRacePosition=position;


            }
            //アイテムが選択されなかった
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        raceSpinnerAdapterSet();
//        データベースから取得したぶんだけのfavoriteをどんどんspinnerに追加していくfavoriteクラス、とりあえずコメントアウト
        //spinnerItems = favorite.favorite(LocationActivity.this, username);//これでok


    }



    String raceSpinner[];
    public void firstRaceSpinner(){

        Log.e(TAG,"aaaaccccccccccfirstRaceSpinner");

        raceSpinner = new String[5];
        raceSpinner[0] = "桜花賞";
        raceSpinner[1] = "日本ダービー";
        raceSpinner[2] ="菊花賞";
        raceSpinner[3] ="天皇賞・秋";
        raceSpinner[4] ="有馬記念";
        //このしたが、キーボードが押されないようにしてる
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        // setSupportActionBar(toolbar);
        toolbar.setTitle("");
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



//    これは使うかわからない。多分spinnerの値を使って計算をするためのもの
    public static void setSelection(Spinner spinner, String item) {
        // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerItems);
        SpinnerAdapter adapter = spinner.getAdapter();
        int index = 0;
        for (int i = 0; i < adapter.getCount(); i++) {
            if (adapter.getItem(i).equals(item)) {
                index = i; break;
            }
        }
        spinner.setSelection(index);
    }




    //    ListViewSet
    public void ListViewSet() {

        Log.e(TAG,"aaaacccccccccclistViewSet");
        commentAdapterlist = new ArrayList<>();
        User user = new User();
        user.setData("1/4 2:10");
        user.setUsername("taichi");
        user.setComment("武豊が一番悔しかったのは、有馬記念で最後刺されたことらしい。");
        //user.setIdnumber("idnumber");
        commentAdapterlist.add(user);
        // 出力結果をリストビューに表示


        setCommentAdapterlist = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
        idCommentListView.setAdapter(setCommentAdapterlist);
        idCommentListView.setSelection(idCommentListView.getCount());
    }



    @Override
    public void onClick(View view) {

        Log.e(TAG,"aaaaaaaaaaaaaaaaaaaaa");

        switch (view.getId()) {
            case R.id.pushCalcButton:

                //次のデータ入力画面にいくボタンが押されたので、処理する
                Intent intent = new Intent(this, CalcActivity.class);
                startActivity(intent);
                break;

            //トータルスコアをみる
            case R.id.pushTotalButton:
                intent = new Intent(this, TotalActivity.class);
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
        }
    }


    public void comment(String text){

        User user = new User();
        user.setData(getNowTime());
        user.setUsername("taichi");
        user.setComment(text);
        commentAdapterlist.add(user);

//        サイド取得する必要はない
        //idCommentListView = (ListView) findViewById(R.id.comment_list_view);
        setCommentAdapterlist = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
        idCommentListView.setAdapter(setCommentAdapterlist);
        idCommentListView.setSelection(idCommentListView.getCount());
    }

    public String getNowTime(){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        String nowTime = month + "/" + day + ":" + hour + ":" + minute + ">";
        return nowTime;
    }

}

