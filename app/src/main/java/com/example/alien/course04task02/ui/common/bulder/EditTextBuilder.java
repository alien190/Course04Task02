package com.example.alien.course04task02.ui.common.bulder;

import android.content.Context;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

public class EditTextBuilder {
    private int id = 0;
    private int hintId = 0;
    private int inputType = EditorInfo.TYPE_CLASS_TEXT;
    private float textSizeSp = 0;
    private ViewGroup.MarginLayoutParams layoutParams = null;

    public EditTextBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public EditTextBuilder setHintId(int hintId) {
        this.hintId = hintId;
        return this;
    }

    public EditTextBuilder setInputType(int inputType) {
        this.inputType = inputType;
        return this;
    }

    public EditTextBuilder setLayoutParams(ViewGroup.MarginLayoutParams layoutParams) {
        this.layoutParams = layoutParams;
        return this;
    }

    public EditTextBuilder setTextSizeSp(float textSizeSp) {
        this.textSizeSp = textSizeSp;
        return this;
    }

    public EditText build(Context context) {
        EditText editText = new EditText(context);

        if (layoutParams != null) {
            editText.setLayoutParams(layoutParams);
        }

        if (id != 0) editText.setId(id);
        if (hintId != 0) editText.setHint(hintId);
        if (textSizeSp != 0) editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSizeSp);
        editText.setInputType(inputType);
        return editText;
    }
}
