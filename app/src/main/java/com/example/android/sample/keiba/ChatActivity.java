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

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;


public class ChatActivity extends Activity implements View.OnClickListener {


    private static final String TAG ="ChatActivity" ;
    Button pushCalcButton;
    Button pushTotalButton;
    Button sentencePushbutton;




    ArrayList<User> adapterlist;
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


        adapterlist = new ArrayList<>();


        User user = new User();
        user.setData("1/4 2:10");
        user.setUsername("taichi");
        user.setComment("武豊が一番悔しかったのは、有馬記念で最後刺されたことらしい。");
        //user.setIdnumber("idnumber");
        adapterlist.add(user);
        // 出力結果をリストビューに表示


        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayListAdapter adapter = new ArrayListAdapter(ChatActivity.this, adapterlist);
        listView.setAdapter(adapter);






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
        adapterlist.add(user);

        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayListAdapter adapter = new ArrayListAdapter(ChatActivity.this, adapterlist);
        listView.setAdapter(adapter);
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
