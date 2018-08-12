package com.example.alien.course04task02.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.alien.course04task02.di.SearchByNameActivityModule;
import com.example.alien.course04task02.ui.common.DoubleFragmentActivity;

import javax.inject.Inject;

import toothpick.config.Module;

public class SearchActivity extends DoubleFragmentActivity {

    public static final int TYPE_SEARCH_BY_NAME = 1;
    private static final String TYPE_KEY = "SearchActivityTypeKey";

    @Inject
    SearchFragment mSearchFragment;

    private int mSearchType;

    public static void startActivity(Context context, int type) {
        Intent intent = new Intent();
        intent.setClass(context, SearchActivity.class);
        intent.putExtra(TYPE_KEY, type);
        context.startActivity(intent);
    }


    @Override
    protected Fragment getFragment() {
        mSearchFragment.setSearchType(getIntent().getIntExtra(TYPE_KEY, 0));
        return mSearchFragment;
    }

    @Override
    protected Module getToothPickModule() {
        switch (getIntent().getIntExtra(TYPE_KEY, 0)) {
            default: return new SearchByNameActivityModule(this);
        }
    }
}
