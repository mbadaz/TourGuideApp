package com.mbada.tourguideapp;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new PlacesFragment());
        fragments.add(new NatureFragment());
        fragments.add(new CultureFragment());
        fragments.add(new ActivitiesFragment());
        ViewPager mViewPager = findViewById(R.id.categoryFragmentsPager);
        FragmentStatePagerAdapter fragmentPagerAdapter = new mFragmentPagerAdapter(this, getSupportFragmentManager(),
                fragments);
        mViewPager.setAdapter(fragmentPagerAdapter);
        TabLayout categoryTabs = findViewById(R.id.categoryTabs);
        categoryTabs.setupWithViewPager(mViewPager);
    }
}
