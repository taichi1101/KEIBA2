package com.example.android.sample.keiba;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class RacePaceFragment extends android.support.v4.app.Fragment {


    public RacePaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //ここで、returenする前に、stateに、fragment_race_paceをセットするのはどうか？1/14

        State.setCalcActivity_fragment_state("fragment_race_pace");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_race_pace, container, false);
    }

}
