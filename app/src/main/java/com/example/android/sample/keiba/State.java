package com.example.android.sample.keiba;

/**
 * Created by endoutaichi on 2018/01/12.
 */


public class State {


    public static boolean calcFinish;

    public static boolean isCalcFinish() {
        return calcFinish;
    }

    public static void setCalcFinish(boolean calcFinish) {
        State.calcFinish = calcFinish;
    }

    public static String calcActivity_fragment_state;

    public  static String getCalcActivity_fragment_state() {
        return calcActivity_fragment_state;
    }

    public static void  setCalcActivity_fragment_state(String calcActivity_fragment_state) {
       State.calcActivity_fragment_state = calcActivity_fragment_state;
    }




}



