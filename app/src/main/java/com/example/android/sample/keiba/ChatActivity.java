package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends Activity implements View.OnClickListener {


    private static final String TAG ="ChatActivity" ;
    Button pushCalcButton;
    Button pushTotalButton;
    Button sentencePushbutton;



    ArrayListAdapter setCommentAdapterlist;


    Spinner idRaceSpinner;

    ArrayList<User> commentAdapterlist;

    ListView idCommentListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        sentencePushbutton=(Button)findViewById(R.id.sentencePushbutton);

        pushCalcButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        sentencePushbutton.setOnClickListener(this);



//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);



        ListViewSet();

//        commentAdapterlist = new ArrayList<>();
//
//
//        User user = new User();
//        user.setData("1/4 2:10");
//        user.setUsername("taichi");
//        user.setComment("武豊が一番悔しかったのは、有馬記念で最後刺されたことらしい。");
//        //user.setIdnumber("idnumber");
//        commentAdapterlist.add(user);
//        // 出力結果をリストビューに表示
//
////        listView
//        idCommentListView=(ListView)findViewById(R.id.comment_list_view);
//        ArrayListAdapter adapter = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
//        idCommentListView.setAdapter(adapter);



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


        idCommentListView=(ListView)findViewById(R.id.comment_list_view);
        setCommentAdapterlist = new ArrayListAdapter(ChatActivity.this, commentAdapterlist);
        idCommentListView.setAdapter(setCommentAdapterlist);
        idCommentListView.setSelection(idCommentListView.getCount());
    }

    @Override
    public void onClick(View view) {


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

                //入力されたたびに、Listを下まで下げる


                break;

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
    }

    public String nowTime(){

        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        String nowTime = month + "/" + day + ":" + hour + ":" + minute + ">";
        return nowTime;
    }

}
