package com.example.android.sample.keiba;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScorePageFragment extends android.support.v4.app.Fragment{


    public ScorePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_score_page, container, false);
        TextView textView = (TextView) view.findViewById(R.id.score_textview);
        textView.setText("Iine");

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_score_page, container, false);
    }

}
