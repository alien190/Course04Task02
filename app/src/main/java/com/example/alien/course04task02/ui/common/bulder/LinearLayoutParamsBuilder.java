package com.example.alien.course04task02.ui.common.bulder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class LinearLayoutParamsBuilder {
    private int layoutWidth = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int layoutHeight = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int marginLeftPx = 0;
    private int marginTopPx = 0;
    private int marginRightPx = 0;
    private int marginBottomPx = 0;
    private int marginStartPx = 0;
    private float weight = 0;


    public LinearLayoutParamsBuilder setMarginLeftPx(int marginLeftPx) {
        this.marginLeftPx = marginLeftPx;
        return this;
    }

    public LinearLayoutParamsBuilder setMarginTopPx(int marginTopPx) {
        this.marginTopPx = marginTopPx;
        return this;
    }

    public LinearLayoutParamsBuilder setMarginRightPx(int marginRightPx) {
        this.marginRightPx = marginRightPx;
        return this;
    }

    public LinearLayoutParamsBuilder setMarginBottomPx(int marginBottomPx) {
        this.marginBottomPx = marginBottomPx;
        return this;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public LinearLayoutParamsBuilder setMarginStartPx(int marginStartPx) {
        this.marginStartPx = marginStartPx;
        return this;
    }

    public LinearLayoutParamsBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public LinearLayoutParamsBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public LinearLayoutParamsBuilder setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    public LinearLayout.LayoutParams build() {

        LinearLayout.LayoutParams layoutParams;

        if (weight != 0) {
            layoutParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight, weight);
        } else {
            layoutParams = new LinearLayout.LayoutParams(layoutWidth, layoutHeight);
        }

        layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && marginStartPx != 0) {
            layoutParams.setMarginStart(marginStartPx);
        }

        return layoutParams;
    }
}
