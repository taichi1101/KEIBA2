package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;




public class ChatActivity extends Activity implements View.OnClickListener {


    Button pushCalcButton;
    Button pushTotalButton;



    private static final String[] texts = {
            "abc ", "bcd", "cde", "def", "efg",
            "fgh", 	"ghi", "hij", "ijk", "jkl",
            "klm"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);

        pushCalcButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);



        ListView listView = new ListView(this);
        setContentView(listView);

        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, texts);

        listView.setAdapter(arrayAdapter);


        //ここでやることは、ボタンを押したときにその項目の文字を入れたEditTextを表示して、
        //上下左右のスワイプへの対応として、その方向の文字を表示させる。
        //そのときにめくるようなUIはいらない。あえて、文字だけ変えさせたい
        //文字サイズは考慮しなくていい


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


        }
    }

}
