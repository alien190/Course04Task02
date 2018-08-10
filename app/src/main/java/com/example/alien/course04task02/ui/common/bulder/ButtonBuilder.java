package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;

public class ButtonBuilder {

    private int id = 0;
    private int textId = 0;
    private MarginLayoutParams layoutParams = null;

    public ButtonBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public ButtonBuilder setTextId(int textId) {
        this.textId = textId;
        return this;
    }


    public ButtonBuilder setLayoutParams(MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public Button build(Context context) {
        Button button = new Button(context);

        if (layoutParams != null) {
            button.setLayoutParams(layoutParams);
        }

        if (id != 0) button.setId(id);
        if (textId != 0) button.setText(textId);
        return button;
    }
}
