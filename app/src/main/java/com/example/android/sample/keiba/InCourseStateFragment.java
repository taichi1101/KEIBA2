package com.example.android.sample.keiba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class InCourseStateFragment extends android.support.v4.app.Fragment {



    public InCourseStateFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        State.setCalcActivity_fragment_state("fragment_in_course_state");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_in_course_state, container, false);
    }

}
