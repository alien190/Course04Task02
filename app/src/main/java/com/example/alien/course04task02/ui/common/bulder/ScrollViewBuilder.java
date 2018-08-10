package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ScrollView;

public class ScrollViewBuilder {

    private int id = 0;
      private MarginLayoutParams layoutParams = null;

    public ScrollViewBuilder setId(int id) {
        this.id = id;
        return this;
    }


    public ScrollViewBuilder setLayoutParams(MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public ScrollView build(Context context) {
        ScrollView scrollView = new ScrollView(context);

        if (layoutParams != null) {
            scrollView.setLayoutParams(layoutParams);
        }

        if (id != 0) scrollView.setId(id);
        scrollView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        return scrollView;
    }
}
