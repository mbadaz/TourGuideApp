package com.mbada.tourguideapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AttractionActivity extends AppCompatActivity {

    private String name;
    private String description;
    private int imageId;
    private DrawerLayout navDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        if(savedInstanceState == null){
            name = getIntent().getStringExtra(Tags.ATTRACTION_NAME);
            description = getIntent().getStringExtra(Tags.ATTRACTION_DESCRIPTION);
            imageId = getIntent().getIntExtra(Tags.IMAGE_URL,1);
        }else {
            name = savedInstanceState.getString(Tags.ATTRACTION_NAME);
            description = savedInstanceState.getString(Tags.ATTRACTION_DESCRIPTION);
            imageId = savedInstanceState.getInt(Tags.IMAGE_URL);
        }

        ImageView attractionImage = findViewById(R.id.attractionImage);
        attractionImage.setImageResource(imageId);
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle(name);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        TextView attractionName = findViewById(R.id.attractionName);
        attractionName.setText(name);
        TextView descriptionText = findViewById(R.id.description);
        descriptionText.setText(description);

        navDrawer = findViewById(R.id.drawer_layout);
        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                perfomNavItemAction(item);
                return true;
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(Tags.ATTRACTION_NAME, name);
        outState.putString(Tags.ATTRACTION_DESCRIPTION, description);
        outState.putInt(Tags.IMAGE_URL, imageId);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                navDrawer.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void perfomNavItemAction(MenuItem item){
        switch(item.getItemId()){
            case R.id.location:
                navDrawer.closeDrawer(GravityCompat.START);
                Toast.makeText(this, getResources()
                        .getString(R.string.locationResult), Toast.LENGTH_SHORT).show();
                break;
            case R.id.bookTour:
                navDrawer.closeDrawer(GravityCompat.START);
                Toast.makeText(this, getResources()
                        .getString(R.string.bookTourResult), Toast.LENGTH_SHORT).show();
                break;
            case R.id.accommodation:
                navDrawer.closeDrawer(GravityCompat.START);
                Toast.makeText(this, getResources()
                        .getString(R.string.findHotelsNearbyResult), Toast.LENGTH_SHORT).show();
                break;
            case R.id.guide:
                navDrawer.closeDrawer(GravityCompat.START);
                Toast.makeText(this, getResources()
                        .getString(R.string.findGuideResult), Toast.LENGTH_SHORT).show();
                break;
        }
    }


}
