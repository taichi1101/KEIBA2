package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class ChatActivity extends Activity implements View.OnClickListener {


    Button pushCalcButton;
    Button pushTotalButton;



    private static final String[] texts = {
            "abc ", "bcd", "cde", "def", "efg",
            "fgh", 	"ghi", "hij", "ijk", "jkl",
            "klm"
    };

    //この上で作った配列を下でArrayAdapterを作ってセットしている
    //そのため、EditTextから、この配列にaddするコードにする
    //ただし、ただ配列をセットしても、あのxmlには当てはまらない。どうするのか？

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        pushCalcButton=(Button)findViewById(R.id.pushCalcButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);

        pushCalcButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);




        ArrayList<User> adapterlist;

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


        //この下の2行はなぞ
//        ListView listView = new ListView(this);
//        setContentView(listView);

        // simple_list_item_1 は、 もともと用意されている定義済みのレイアウトファイルのID
//        ArrayAdapter<String> arrayAdapter =
//                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, texts);
        //listView.setAdapter(arrayAdapter);
        //↑多分ここで動的に追加してるから、場所が指定できずに、上に付け足されているのではないか？


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
