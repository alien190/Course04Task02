package com.example.alien.course04task02.ui.search;

import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.common.DoubleFragmentActivity;

import javax.inject.Inject;

public class SearchActivity extends DoubleFragmentActivity {

    @Inject
    SearchFragment mSearchFragment;

    @Override
    protected Fragment getFragment() {
        return mSearchFragment;
    }
}
