package com.example.android.sample.keiba;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    private static final int PAGE_NUM = 3;

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[]{"Iine", "Score", "Friend"};
    private Context context;



    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    //UserInfoViewPagerAdapterに合わせる
//    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
//        super(fm);
//        this.context = context;
//    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }

    @Override
    public Fragment getItem(int position) {
        // fragmentを切り替える

        Fragment fragment=null;
        switch(position){
            case 0:
                fragment= new IinePageFragment();
                break;
            case 1:
                fragment = new ScorePageFragment();
                break;
            case 2:
                fragment = new FriendPageFragment();
                break;
        }
        return fragment;
    }

    //これは多分titleのページ切り替えを作るやつだからコメントアウト
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }


    public static int getPageCount() {
        return PAGE_NUM;
    }

}


