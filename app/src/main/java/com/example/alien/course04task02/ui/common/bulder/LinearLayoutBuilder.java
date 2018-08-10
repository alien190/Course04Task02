package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutBuilder {

    private ViewGroup.MarginLayoutParams layoutParams = null;
    private int id = 0;

    public LinearLayoutBuilder setLayoutParams(ViewGroup.MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public LinearLayoutBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public LinearLayout build(Context context) {
        LinearLayout layout = new LinearLayout(context);

        if (layoutParams != null) {
            layout.setLayoutParams(layoutParams);
        }
        if (id != 0) layout.setId(id);
        return layout;
    }
}
