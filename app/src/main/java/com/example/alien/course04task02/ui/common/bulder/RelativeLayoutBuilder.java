package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class RelativeLayoutBuilder {

    private int paddingLeftPx = 0;
    private int paddingTopPx = 0;
    private int paddingRightPx = 0;
    private int paddingBottomPx = 0;
    private ViewGroup.MarginLayoutParams layoutParams = null;

    public RelativeLayoutBuilder setPaddingLeftPx(int paddingLeftPx) {
        this.paddingLeftPx = paddingLeftPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingTopPx(int paddingTopPx) {
        this.paddingTopPx = paddingTopPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingRightPx(int paddingRightPx) {
        this.paddingRightPx = paddingRightPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingBottomPx(int paddingBottomPx) {
        this.paddingBottomPx = paddingBottomPx;
        return this;
    }

    public RelativeLayoutBuilder setPaddingPx(int padding) {
        paddingLeftPx = padding;
        paddingTopPx = padding;
        paddingRightPx = padding;
        paddingBottomPx = padding;
        return this;
    }


    public RelativeLayoutBuilder setLayoutParams(ViewGroup.MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public RelativeLayout build(Context context) {
        RelativeLayout layout = new RelativeLayout(context);

        if (layoutParams != null) {
            layout.setLayoutParams(layoutParams);
        }

        layout.setPadding(paddingLeftPx, paddingTopPx, paddingRightPx, paddingBottomPx);
        return layout;
    }
}
