package com.example.android.sample.keiba;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StartFragment extends android.support.v4.app.Fragment
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        State state=new State();
        state.setCalcActivity_fragment_state("fragment_start");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false);
    }

}
