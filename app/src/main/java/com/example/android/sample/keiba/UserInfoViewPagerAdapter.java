package com.example.android.sample.keiba;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class UserInfoViewPagerAdapter extends FragmentPagerAdapter {
    private static final int PAGE_NUM = 3;

    public UserInfoViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new JuunanseiFragment();
                break;
            case 1:
                fragment = new KireaziFragment();
                break;

            default:
                fragment = new Fragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return PAGE_NUM;
    }
}