package com.example.alien.course04task02.ui.common.bulder;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class RelativeLayoutParamsBuilder {
    private int layoutWidth = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int layoutHeight = RelativeLayout.LayoutParams.WRAP_CONTENT;
    private int marginLeftPx = 0;
    private int marginTopPx = 0;
    private int marginRightPx = 0;
    private int marginBottomPx = 0;
    private int marginStartPx = 0;
    private List<Rule> rules = new ArrayList<>();

    public RelativeLayoutParamsBuilder setMarginLeftPx(int marginLeftPx) {
        this.marginLeftPx = marginLeftPx;
        return this;
    }

    public RelativeLayoutParamsBuilder setMarginTopPx(int marginTopPx) {
        this.marginTopPx = marginTopPx;
        return this;
    }

    public RelativeLayoutParamsBuilder setMarginRightPx(int marginRightPx) {
        this.marginRightPx = marginRightPx;
        return this;
    }

    public RelativeLayoutParamsBuilder setMarginBottomPx(int marginBottomPx) {
        this.marginBottomPx = marginBottomPx;
        return this;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public RelativeLayoutParamsBuilder setMarginStartPx(int marginStartPx) {
        this.marginStartPx = marginStartPx;
        return this;
    }

    public RelativeLayoutParamsBuilder setLayoutWidth(int layoutWidth) {
        this.layoutWidth = layoutWidth;
        return this;
    }

    public RelativeLayoutParamsBuilder setLayoutHeight(int layoutHeight) {
        this.layoutHeight = layoutHeight;
        return this;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public RelativeLayoutParamsBuilder toEndOf(int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            rules.add(new Rule(RelativeLayout.END_OF, id));
        }
        return this;
    }

    public RelativeLayoutParamsBuilder toRightOf(int id) {
        rules.add(new Rule(RelativeLayout.RIGHT_OF, id));
        return this;
    }

    public RelativeLayoutParamsBuilder alignTop(int id) {
        rules.add(new Rule(RelativeLayout.ALIGN_TOP, id));
        return this;
    }


    public RelativeLayoutParamsBuilder alignBottom(int id) {
        rules.add(new Rule(RelativeLayout.ALIGN_BOTTOM, id));
        return this;
    }

    public RelativeLayoutParamsBuilder alignLeft(int id) {
        rules.add(new Rule(RelativeLayout.ALIGN_LEFT, id));
        return this;
    }

    public RelativeLayoutParamsBuilder alignRight(int id) {
        rules.add(new Rule(RelativeLayout.ALIGN_RIGHT, id));
        return this;
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public RelativeLayoutParamsBuilder alignStart(int id) {
        rules.add(new Rule(RelativeLayout.ALIGN_START, id));
        return this;
    }

    public RelativeLayoutParamsBuilder below(int id) {
        rules.add(new Rule(RelativeLayout.BELOW, id));
        return this;
    }

    public RelativeLayoutParamsBuilder above(int id) {
        rules.add(new Rule(RelativeLayout.ABOVE, id));
        return this;
    }

    public RelativeLayout.LayoutParams build() {

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(layoutWidth,
                layoutHeight);

        layoutParams.setMargins(marginLeftPx, marginTopPx, marginRightPx, marginBottomPx);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1 && marginStartPx != 0) {
            layoutParams.setMarginStart(marginStartPx);
        }

        for (Rule rule : rules) {
            layoutParams.addRule(rule.verb, rule.subject);
        }

        return layoutParams;
    }

    private class Rule {
        private int verb;
        private int subject;

        private Rule(int verb, int subject) {
            this.verb = verb;
            this.subject = subject;
        }
    }
}
