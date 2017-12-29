package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ここでやることは、ボタンを押したときにその項目の文字を入れたEditTextを表示して、
        //上下左右のスワイプへの対応として、その方向の文字を表示させる。
        //そのときにめくるようなUIはいらない。あえて、文字だけ変えさせたい
        //文字サイズは考慮しなくていい

        Button pushbutton=(Button)findViewById(R.id.push);


        pushbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        //次の画面にいくボタンが押されたので、処理する
        Intent intent =new Intent(this,CalcActivity.class);
        startActivity(intent);

    }
}
