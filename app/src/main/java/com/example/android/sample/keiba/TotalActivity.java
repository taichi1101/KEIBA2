package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TotalActivity extends Activity implements View.OnClickListener {



    Button pushCalcButton;
    Button pushMainButton;
    Button  pushChatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);



        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushMainButton=(Button)findViewById(R.id.pushMainButton);
        pushChatButton=(Button)findViewById(R.id.pushChatButton);

        pushCalcButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushChatButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.pushCalcButton:


                //次のデータ入力画面にいくボタンが押されたので、処理する
                Intent intent = new Intent(this, CalcActivity.class);
                startActivity(intent);
                break;


            case R.id.pushMainButton:

                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;



            case R.id.pushChatButton:
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;




        }
    }

}
