package com.example.android.sample.keiba;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
public class FinishScoreInputFragment extends android.support.v4.app.Fragment {


    public FinishScoreInputFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        State state=new State();
        state.setCalcActivity_fragment_state("fragment_finish_score_input");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_finish_score_input, container, false);
    }

}