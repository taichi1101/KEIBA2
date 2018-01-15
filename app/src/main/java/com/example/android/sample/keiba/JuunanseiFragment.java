package com.example.android.sample.keiba;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JuunanseiFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        State state=new State();
        state.setCalcActivity_fragment_state("fragment_juunansei");
        return inflater.inflate(R.layout.fragment_juunansei, container, false);
    }
}

