package com.example.alien.course04task02.ui.main;

import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.common.DoubleFragmentActivity;

import javax.inject.Inject;

import toothpick.Toothpick;

public class MainActivity extends DoubleFragmentActivity {

    @Inject
    MainFragment fragment;

    @Override
    protected Fragment getFragment() {
        return fragment;
    }

}
