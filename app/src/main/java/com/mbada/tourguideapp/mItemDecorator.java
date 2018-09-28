package com.mbada.tourguideapp;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

class mItemDecorator extends RecyclerView.ItemDecoration {
    private final int margin;

    public mItemDecorator(float margin) {
        this.margin = (int) margin;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.set(margin,margin,margin,margin);
    }
}
