package com.example.android.sample.keiba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class JuunanseiFragment extends Fragment {


    public String  TAG = "JuunanseiFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //ここで、指定した次のページが表示される。これをボタンが押された時に呼び出せればいい。
//        ((CalcActivity)getActivity()).getViewPager().setCurrentItem(3);

        //ViewPager#setCurrentItem

        State.setCalcActivity_fragment_state("fragment_juunansei");
        return inflater.inflate(R.layout.fragment_juunansei, container, false);
    }

}

