package com.mbada.tourguideapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

class mFragmentPagerAdapter extends FragmentStatePagerAdapter{

    private final ArrayList<Fragment> fragments;
    private final String[] tabs;

    public mFragmentPagerAdapter(Context context, FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
        tabs = context.getResources().getStringArray(R.array.categyTabs);
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public int getCount() {
        return fragments.size();
    }


}
