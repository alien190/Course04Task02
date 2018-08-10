package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.widget.FrameLayout;

public class FrameLayoutBuilder {

    private int paddingLeftPx = 0;
    private int paddingTopPx = 0;
    private int paddingRightPx = 0;
    private int paddingBottomPx = 0;
    private int layoutWidth = -2;
    private int layoutHeight = -2;
    private int gravity = 0;

    public FrameLayoutBuilder setPaddingLeftPx(int paddingLeftPx) {
        this.paddingLeftPx = paddingLeftPx;
        return this;
    }

    public FrameLayoutBuilder setPaddingTopPx(int paddingTopPx) {
        this.paddingTopPx = paddingTopPx;
        return this;
    }

    public FrameLayoutBuilder setPaddingRightPx(int paddingRightPx) {
        this.paddingRightPx = paddingRightPx;
        return this;
    }

    public FrameLayoutBuilder setPaddingBottomPx(int paddingBottomPx) {
        this.paddingBottomPx = paddingBottomPx;
        return this;
    }

    public FrameLayoutBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public FrameLayoutBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    public FrameLayoutBuilder setPaddingPx(int padding) {
        paddingLeftPx = padding;
        paddingTopPx = padding;
        paddingRightPx = padding;
        paddingBottomPx = padding;
        return this;
    }

    public FrameLayoutBuilder setGravity(int gravity) {
        this.gravity = gravity;
        return this;
    }

    public FrameLayout build(Context context) {
        FrameLayout layout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(layoutWidth,
                        layoutHeight);


        layout.setLayoutParams(layoutParams);
        layout.setPadding(paddingLeftPx, paddingTopPx, paddingRightPx, paddingBottomPx);
        layout.setForegroundGravity(gravity);

        return layout;
    }
}
