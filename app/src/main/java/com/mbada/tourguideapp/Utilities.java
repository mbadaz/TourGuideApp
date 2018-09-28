package com.mbada.tourguideapp;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * {@link Utilities} is a container for application-wide utility functions
 */
class Utilities {

    /**
     * {@link Utilities#getSpanCount(Context)} calculates the span count used
     * by the {@link android.support.v7.widget.GridLayoutManager}
     * @param context is the activity {@link Context}
     * @return the span count calculated relative to the device screen size
     */
    public static int getSpanCount(Context context){
        DisplayMetrics mDisplayMetrics = context.getResources().getDisplayMetrics();
        float density = mDisplayMetrics.density;
        float itemWidth;
        float itemMargin = context.getResources().getDimension(R.dimen.list_item_margin) / density;
        float physicalScreenWidth;
        float logicalScreenWidth = mDisplayMetrics.widthPixels / density;
        int orientation = context.getResources().getConfiguration().orientation;

        //Get the screen width
        if (orientation == Configuration.ORIENTATION_PORTRAIT){
            physicalScreenWidth = mDisplayMetrics.widthPixels/density;
        }else{
            physicalScreenWidth = mDisplayMetrics.heightPixels/density;
        }

        // Select appropriate resource for screen size type.
        if(physicalScreenWidth > 600){
            // Select resource for large (tablet size) screen devices
            itemWidth = context.getResources().getDimension(R.dimen.list_item_width_Large) / density;
        }else {
            // Select the resource for normal screen devices
            itemWidth = context.getResources().getDimension(R.dimen.list_item_width_small) / density;
        }

        return (int) Math.floor((logicalScreenWidth - itemMargin * 4) / itemWidth);
    }


}
