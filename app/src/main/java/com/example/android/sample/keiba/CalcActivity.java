package com.example.android.sample.keiba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class CalcActivity extends AppCompatActivity implements View.OnClickListener {


    Map<String, String> nowSpinnerArrayList = new HashMap<>();
    private ViewPager pager;



    Button pushChatButton;
    Button pushTotalButton;
    Button pushMainButton;
    Button pushAccountButton;

    //    レースのspinner
    Spinner idRaceSpinner;
    //    馬のspinner
    Spinner idHourseSpinner;


    //10択ボタンの変数
    Button pushCalc_button_1;
    Button pushCalc_button_2;
    Button pushCalc_button_3;
    Button pushCalc_button_4;
    Button pushCalc_button_5;
    Button pushCalc_button_6;
    Button pushCalc_button_7;
    Button pushCalc_button_8;
    Button pushCalc_button_9;
    Button pushCalc_button_10;


    private FragmentPagerAdapter adapter;

    private int currentPage;
    private String TAG="CalcActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);


        pushChatButton=(Button)findViewById(R.id.pushChatButton);
        pushTotalButton=(Button)findViewById(R.id.pushTotalButton);
        pushMainButton=(Button)findViewById(R.id.pushRaceOrderButton);
        pushAccountButton=(Button)findViewById(R.id.pushAccountButton);

        pushCalc_button_1=(Button)findViewById(R.id.calc_button_1);
        pushCalc_button_2=(Button)findViewById(R.id.calc_button_2);
        pushCalc_button_3=(Button)findViewById(R.id.calc_button_3);
        pushCalc_button_4=(Button)findViewById(R.id.calc_button_4);
        pushCalc_button_5=(Button)findViewById(R.id.calc_button_5);
        pushCalc_button_6=(Button)findViewById(R.id.calc_button_6);
        pushCalc_button_7=(Button)findViewById(R.id.calc_button_7);
        pushCalc_button_8=(Button)findViewById(R.id.calc_button_8);
        pushCalc_button_9=(Button)findViewById(R.id.calc_button_9);
        pushCalc_button_10=(Button)findViewById(R.id.calc_button_10);

        pushChatButton.setOnClickListener(this);
        pushTotalButton.setOnClickListener(this);
        pushMainButton.setOnClickListener(this);
        pushAccountButton.setOnClickListener(this);

        pushCalc_button_1.setOnClickListener(this);
        pushCalc_button_2.setOnClickListener(this);
        pushCalc_button_3.setOnClickListener(this);
        pushCalc_button_4.setOnClickListener(this);
        pushCalc_button_5.setOnClickListener(this);
        pushCalc_button_6.setOnClickListener(this);
        pushCalc_button_7.setOnClickListener(this);
        pushCalc_button_8.setOnClickListener(this);
        pushCalc_button_9.setOnClickListener(this);
        pushCalc_button_10.setOnClickListener(this);



//        spinner
        idRaceSpinner = (Spinner) findViewById(R.id.raceSpinner);
        idHourseSpinner=(Spinner) findViewById(R.id.hourseSpinner);

        firstRaceSpinner();
        firstHourseSpinner();



        pager = (ViewPager) findViewById(R.id.pager);

        adapter = new UserInfoViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);
        currentPage = 0;

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


    public void onStart() {
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
                    if (item.equals("桜花賞")) {

                        Log.e(TAG, "1/6:初期化のspinnerで桜花賞が選択された");
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



        @Override
    public void onClick(View view) {

            Intent intent;

        switch (view.getId()) {
            case R.id.pushChatButton:

                //次のデータ入力画面にいくボタンが押されたので、処理する
                intent = new Intent(this, ChatActivity.class);
                startActivity(intent);
                break;

            //トータルスコアをみる
            case R.id.pushTotalButton:
                intent = new Intent(this, TotalActivity.class);
                startActivity(intent);
                break;

            case R.id.pushRaceOrderButton:
                intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;

            case R.id.pushAccountButton:
                intent= new Intent(this,AccountActivity.class);
                startActivity(intent);


            case R.id.calc_button_1:
                //ボタン１が押された時は、spinnerから今の馬とレース名を取得して、そこに1をセットする
                //それの繰り返し。
                //テキストじゃない、listにaddして、次の画面にスライドさせる
                //まず、このlistが偽物になってるから、動的に変更できるものに変える

                //ここで値を送って、メソッドでspinnerの値を取得してlistに追加するコードを作る

                getSpinnerAddNumber(1);
                break;

            case R.id.calc_button_2:
                getSpinnerAddNumber(2);
                break;

            case R.id.calc_button_3:
                getSpinnerAddNumber(3);
                break;

            case R.id.calc_button_4:
                getSpinnerAddNumber(4);
                break;

            case R.id.calc_button_5:
                getSpinnerAddNumber(5);
                break;

            case R.id.calc_button_6:
                getSpinnerAddNumber(6);
                break;

            case R.id.calc_button_7:
                getSpinnerAddNumber(7);
                break;

            case R.id.calc_button_8:
                getSpinnerAddNumber(8);
                break;

            case R.id.calc_button_9:
                getSpinnerAddNumber(9);
                break;

            case R.id.calc_button_10:
                getSpinnerAddNumber(10);
                break;

        }
    }

    public void getSpinnerAddNumber(int number){




        // Spinnerオブジェクトを取得
        Spinner raceSpinner = (Spinner)findViewById(R.id.raceSpinner);

        // 選択されているアイテムのIndexを取得
        int raceSpinnerIdx = raceSpinner.getSelectedItemPosition();

        // 選択されているアイテムを取得
        String raceSppinerItem = (String)raceSpinner.getSelectedItem();



        // Spinnerオブジェクトを取得
        Spinner hourseSpinner = (Spinner)findViewById(R.id.hourseSpinner);

        // 選択されているアイテムのIndexを取得
        int hourseSpinnerIdx = hourseSpinner.getSelectedItemPosition();

        // 選択されているアイテムを取得
        String hourseSpinnerItem = (String)hourseSpinner.getSelectedItem();


        //hourseで、選択されている値をnumberと連結して、textにセットする。

        //配列の設計だけど、一つの馬に対して、いろんな要素(二の足とかを入れて行くことになる)
        //だから、天皇賞 エアスビネル という配列に、二の足:5、スタート:5とかでセットして行く、key valueにするか
        //まず、配列が、すでにない場合は、配列を作る


        //どうやったら、動的にlistを作れるのか？
        //spinnerで変更されるたびにlistを切り替えるのか？
        //とりあえず、毎回ボタンが押されるたびに、ifで、配列がからだったら、new させればいいか



        //どうしよう、今取得したspinnerと、配列の1爪の値が同じなら、それでok
        //違うなら、新しく、配列を作る。




        String keyRaceSppinerItemhourseSpinnerItem=nowSpinnerArrayList.get("keyRaceSppinerItemhourseSpinnerItem");
        Log.e(TAG,"keyRaceSppinerItemhourseSpinnerItem"+keyRaceSppinerItemhourseSpinnerItem);
        //先頭にKeyをつける  https://www.sejuku.net/blog/16055

        //nullだったら、作るようにする


            if (nowSpinnerArrayList== null) {

                //nullの場合は、作る
//            if(!nowSpinnerArrayList.get("keyRaceSppinerItemhourseSpinnerItem").equals(raceSppinerItem+hourseSpinnerItem)){

                //配列のvalueと、今のspinnerが揃ってれば、newしない
                //揃ってない場合は、更新が必要だから、newする
                //将来的には、newというより、databaseに、別のレース、もしくは別の馬ということで、配列を作る
                //今はそれは大変だから後で、

                //spinnerと違う場合は新しく作る。本来はdatabaseにaddにする

                Log.e(TAG," new HashMap<>()をした");
                nowSpinnerArrayList = new HashMap<>();

            }

        //それで、もう既にlistができてる、buttonが2コメ以上でspinnerを買えてない場合は、ここで、配列にセットさせる。

        //普通に、まず、stateから、今のfragementを取って来て、それをkeyにして、押されたボタンをvalueにセットする


        //レース名と、馬名を表すのは、keyRaceSppinerItem+hourseSpinnerItemというkeyのみで十分

        String numberString=String.valueOf(number);

        //ここで、現在選択されてるnowSpinnerArrayListに対して、putを行う

        //この下のkey1のところを、stateから持ってくる
        //この下のコードで、buttonが押された時に、選択されているspinnerの配列に対して、今のfragment名と、押されたボタンの値が足されて行く

        //State state=new State();
        //Stateクラスの変数をstaticにすることで、newしなくてよくなったからnullでもなくなったかも

        String calcActivity_fragment_state= State.getCalcActivity_fragment_state();



        //ここで、putする前に、比率を調整しておきたい

        //fragment名と、値を入力
        String numberString_ratioed=nowSpinnerArrayListSetRatio(calcActivity_fragment_state,numberString);



        nowSpinnerArrayList.put(calcActivity_fragment_state, numberString_ratioed);

        Log.e(TAG,"nowSpinnerArrayListに値を追加した:"+nowSpinnerArrayList);
        //全データが入力されないと、最終スコアは出さない

        //現在のViewPageAdapterの次のページに動的にセット
       //UserInfoViewPagerAdapter.getItem()+1


         ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
//        呼び出されるたび次のページに切り替え
        int nowPage=viewPager.getCurrentItem()+1;
        Log.e(TAG,"今のページ数は:"+nowPage);
        viewPager.setCurrentItem(nowPage);



        //ここで、ratioされた数値(String)が帰ってくるから、それを配列にセットして、
        //今度は、その配列を全てforで表示して、←いや、メンドくさい？
        //でも、今後途中で違う馬に行った場合、そっちの方がいい。

        //ここでは、配列に入れてるけど、実際はデータベース？まあいいや、どっちかわからないけど、
        //スコアを出す時にも本来はデータベースだよね。




        //最後の画面に行った時に、今選択されているspinnerのレース&馬のスコアを算出する
        //一つの配列から、keyとvalueを取得して、keyに応じて、比率を変える関数を作っておく
        //そして、for文で、回して、比率を調整しながら、全ての総合スコアを出して、とりあえず、画面にtextViewを作って、そこにセットする



        //ここで現在選択されている、hoursenameとnumberを取得してる。

        //この値を、配列に追加する。
        // その配列をforで回して、表示している

        //これらのデータの識別には、まずレース名が必要で、次にuser名が必要(自分が何を入力したかを把握する必要があるから)、そして、hoursename_and_numberが必要
        //とりあえずusernameはtaichi
        //項目名も必要。これは、今はfragmentのどこにいるかどうか？を把握する必要がある。
        //

       // ArrayList<String>


        /////////////とりあえず、最後にだけ呼ばれるやつ


        //最後の画面で全部足しても遅い、最後の画面に表示するなら、最後のデータの画面でやらないと
        if(calcActivity_fragment_state.equals("fragment_finish_score_input")) {

            //全データの入力が終わった。全ての数値をたす


            //ここでエラーが起こる。つまり、この配列から全ての値を取得して、足し算するとこでエラーが起こる


//                       for (int i=0; i<=nowSpinnerArrayList.size(); i++){
//
//                //iが1ずつ加算されていき、nowSpinnerArrayListのsizeになるまで、繰り返される
//                //その要素のkeyやvalueを取得する
//
//              //  nowSpinnerArrayList(1);
//
//
//            }

            Integer totalNowSpinnerArrayListScore=0;

            //https://www.sejuku.net/blog/16055
            //これを使えば全データを足し算できる
            // for(String val : nowSpinnerArrayList.values()){


            //とりあえずコメントアウト keyも取得したいから
             for(String val : nowSpinnerArrayList.values()){


                 //別にkeyを取得しなくてもいいから、とりあえず先に進める
//            for (int i = 0; i < nowSpinnerArrayList.size(); i++) {
//                String val =nowSpinnerArrayList.get(i).values().toString();

                // System.out.println(val);



                 int intVal = Integer.parseInt(val);

                Log.e(TAG, "Integer.parseInt(val)は:" + intVal);

                //ここで、totalが増えてないのは問題。

//                 int score=Integer.parseInt(totalNowSpinnerArrayListScore);

                 Log.e(TAG,"totalNowSpinnerArrayListScore たす前:"+totalNowSpinnerArrayListScore);
                totalNowSpinnerArrayListScore =totalNowSpinnerArrayListScore+ intVal;


                Log.e(TAG, "totalNowSpinnerArrayListScore 足したあと:" + totalNowSpinnerArrayListScore);

                TextView finish_score_input_text = findViewById(R.id.finish_score_input_text);


                finish_score_input_text.setText(totalNowSpinnerArrayListScore.toString());


            }

        }


//            //これは正しいのかわからない
//            Integer totalNowSpinnerArrayListScore;
//
//            Iterator it = nowSpinnerArrayList.keySet().iterator();
//            while (it.hasNext()) {
//                Object o = it.next();
//                totalNowSpinnerArrayListScore=+Integer.parseInt(nowSpinnerArrayList.get(o));
//
//                Log.e(TAG,"while(it.hasNext()で回す:"+totalNowSpinnerArrayListScore);
//
//
//
//                TextView finish_score_input_text=findViewById(R.id.finish_score_input_text);
//
//                finish_score_input_text.setText(totalNowSpinnerArrayListScore);
//            }

            //これで、totalには、全てのデータが足された数値がセットされた
            //この下で、最後のlayout(fragmentにセットするようにする)

            //競馬場のデータも作らないといけないし、自動でヤフーから取ってくるレース情報もとりあえず、式に入れないといけない




        }


//
//    //ここはhttps://qiita.com/kentosasa/items/a556f8d12d3f689352be  1/15
//    ViewPager mViewPager;
//
//
//    public ViewPager getViewPager() {
//        if (null == mViewPager) {
//            mViewPager = (ViewPager) findViewById(R.id.pager);
//        }
//        return mViewPager;
//    }



//    Bundle bundle = new Bundle();
//
//
//    KireaziFragment fragment = new KireaziFragment();
//    //fragment.setArguments(bundle);
//
//    ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
////    ExampleFragmentPagerAdapter adapter = new ExampleFragmentPagerAdapter(manager);
//FragmentManager manager = getSupportFragmentManager();
//    UserInfoViewPagerAdapter adapter=new  UserInfoViewPagerAdapter(manager);
//
//    //viewPager.setAdapter(adapter);


    //最後の画面に行った時に、今選択されているspinnerのレース&馬のスコアを算出する
    //一つの配列から、keyとvalueを取得して、keyに応じて、比率を変える関数を作っておく
    //そして、for文で、回して、比率を調整しながら、全ての総合スコアを出して、とりあえず、画面にtextViewを作って、そこにセットする

    //最後に呼び出される。



    public String  nowSpinnerArrayListSetRatio(String calcActivity_fragment_state,String numberString_ratioed) {

        switch (calcActivity_fragment_state) {



            case "fragment_juunansei":
                numberString_ratioed = String.valueOf(Integer.parseInt(numberString_ratioed) * 3);//3
                break;

            case "fragment_kireazi":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*3);//3
                break;


            case "fragment_stamina":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*3);//3
                break;


            case "fragment_start":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*2);//2
                break;

            case "fragment_kishitu":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*2);//2
                break;


            case "fragment_ninoashi":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*2);//2
                break;


            case "fragment_jokie_ability":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*3);//3
                break;



            case "DistanceAppropriateFragment":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*2);//2
                break;


            case "fragment_tiredness":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*3);//3
                break;


            case "fragment_in_course_state":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*1);
                break;


            case "fragment_out_course_state":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*1);
                break;


            case "fragment_large_outer_course_state":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*1);
                break;


            case "fragment_hourse_type":
                numberString_ratioed=String.valueOf(Integer.parseInt(numberString_ratioed)*3);//3
                break;


        }
        //これで、ratioされた数値を返す。
        return numberString_ratioed;

    }




//ここをなくすと、余計なボタンがなくなっていい
//    public void onClickNext(View view) {
//        currentPage ++;
//        pager.setCurrentItem(currentPage);
//    }
//
//    public void onClickGoToTop(View view) {
//        currentPage = 0;
//        pager.setCurrentItem(currentPage);
//    }
}


