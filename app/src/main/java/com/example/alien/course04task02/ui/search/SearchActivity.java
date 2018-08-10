package com.example.alien.course04task02.ui.search;

import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.common.DoubleFragmentActivity;

public class SearchActivity extends DoubleFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return SearchFragment.newInstance();
    }
}
