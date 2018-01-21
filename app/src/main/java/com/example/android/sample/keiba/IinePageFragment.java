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
public class IinePageFragment extends android.support.v4.app.Fragment{


    public IinePageFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_iine_page, container, false);
    }


//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment_iine_page, container, false);
//        TextView textView = (TextView) view.findViewById(R.id.iine_textview);
//        textView.setText("Iine");
//        // Inflate the layout for this fragment
//        return view;
//        // Inflate the layout for this fragment
//        //return inflater.inflate(R.layout.fragment_iine_page, container, false);
//    }

}
