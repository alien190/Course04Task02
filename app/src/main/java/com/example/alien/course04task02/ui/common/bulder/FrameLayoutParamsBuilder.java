package com.example.alien.course04task02.ui.common.bulder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class FrameLayoutParamsBuilder {
    private int layoutWidth = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int layoutHeight = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int marginLeftPx = 0;
    private int marginTopPx = 0;
    private int marginRightPx = 0;
    private int marginBottomPx = 0;
    private int marginStartPx = 0;
    private int gravity = 0;

    public FrameLayoutParamsBuilder setMarginLeftPx(int marginLeftPx) {
        this.marginLeftPx = marginLeftPx;
        return this;
    }

    public FrameLayoutParamsBuilder setMarginTopPx(int marginTopPx) {
        this.marginTopPx = marginTopPx;
        return this;
    }

    public FrameLayoutParamsBuilder setMarginRightPx(int marginRightPx) {
        this.marginRightPx = marginRightPx;
        return this;
    }

    public FrameLayoutParamsBuilder setMarginBottomPx(int marginBottomPx) {
        this.marginBottomPx = marginBottomPx;
        return this;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public FrameLayoutParamsBuilder setMarginStartPx(int marginStartPx) {
        this.marginStartPx = marginStartPx;
        return this;
    }

    public FrameLayoutParamsBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public FrameLayoutParamsBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public FrameLayoutParamsBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public FrameLayout.LayoutParams build() {

        FrameLayout.LayoutParams layoutParams = gravity != 0 ?
                new FrameLayout.LayoutParams(layoutWidth, layoutHeight, gravity)
                : new FrameLayout.LayoutParams(layoutWidth, layoutHeight);


        layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && marginStartPx != 0) {
            layoutParams.setMarginStart(marginStartPx);
        }
        return layoutParams;
    }
}
