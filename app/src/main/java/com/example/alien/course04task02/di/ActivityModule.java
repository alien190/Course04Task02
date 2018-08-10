package com.example.alien.course04task02.di;


import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.main.MainFragment;
import toothpick.config.Module;


public class ActivityModule extends Module {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;

        bind(MainFragment.class).toInstance(MainFragment.newInstance());
        bind(AppCompatActivity.class).toInstance(mActivity);
    }

}
