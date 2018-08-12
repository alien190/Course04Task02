package com.example.alien.course04task02.di;


import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmList.ListAllViewModel;
import com.example.alien.course04task02.ui.main.MainFragment;
import com.example.alien.course04task02.ui.search.SearchFragment;

import toothpick.config.Module;


public class MainActivityModule extends Module {

    private AppCompatActivity mActivity;

    public MainActivityModule(AppCompatActivity activity) {
        mActivity = activity;

        bind(MainFragment.class).toInstance(MainFragment.newInstance());
        bind(SearchFragment.class).toInstance(SearchFragment.newInstance());
        bind(AppCompatActivity.class).toInstance(mActivity);
        //todo сделать интерфейсы
        bind(BaseViewModel.class).toProvider(ListAllViewModelProvider.class).providesSingletonInScope();
        bind(Integer.class).withName("TitleId").toInstance(R.string.main_activity_title);
    }

}
