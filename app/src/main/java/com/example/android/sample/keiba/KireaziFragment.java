package com.example.android.sample.keiba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class KireaziFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        State.setCalcActivity_fragment_state("fragment_kireazi");
        return inflater.inflate(R.layout.fragment_kireazi, container, false);
    }
}