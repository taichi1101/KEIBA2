package com.example.android.sample.keiba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class JuunanseiFragment extends Fragment {


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

    public String  TAG = "JuunanseiFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//
//        pushCalc_button_1=(Button)getActivity().findViewById(R.id.calc_button_1);
//        pushCalc_button_2=(Button)getActivity().findViewById(R.id.calc_button_2);
//        pushCalc_button_3=(Button)getActivity().findViewById(R.id.calc_button_3);
//        pushCalc_button_4=(Button)getActivity().findViewById(R.id.calc_button_4);
//        pushCalc_button_5=(Button)getActivity().findViewById(R.id.calc_button_5);
//        pushCalc_button_6=(Button)getActivity().findViewById(R.id.calc_button_6);
//        pushCalc_button_7=(Button)getActivity().findViewById(R.id.calc_button_7);
//        pushCalc_button_8=(Button)getActivity().findViewById(R.id.calc_button_8);
//        pushCalc_button_9=(Button)getActivity().findViewById(R.id.calc_button_9);
//        pushCalc_button_10=(Button)getActivity().findViewById(R.id.calc_button_10);
//
//
//        pushCalc_button_1.setOnClickListener(this);
//        pushCalc_button_2.setOnClickListener(this);
//        pushCalc_button_3.setOnClickListener(this);
//        pushCalc_button_4.setOnClickListener(this);
//        pushCalc_button_5.setOnClickListener(this);
//        pushCalc_button_6.setOnClickListener(this);
//        pushCalc_button_7.setOnClickListener(this);
//        pushCalc_button_8.setOnClickListener(this);
//        pushCalc_button_9.setOnClickListener(this);
//        pushCalc_button_10.setOnClickListener(this);


        //ここで、指定した次のページが表示される。これをボタンが押された時に呼び出せればいい。
//        ((CalcActivity)getActivity()).getViewPager().setCurrentItem(3);

        //ViewPager#setCurrentItem

        State.setCalcActivity_fragment_state("fragment_juunansei");
        return inflater.inflate(R.layout.fragment_juunansei, container, false);
    }

//    @Override
//    public void onClick(View view) {
//
////        if(view.getId()==R.id.pager){
//
//       // Log.e(TAG,"ここやで");
//            //このfragmentで、pagerがクリックされた時、
//            //((CalcActivity)getActivity()).getViewPager().setCurrentItem(3);
//
//      //  }
//    }
}

