package com.example.alien.course04task02.di;


import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmList.SearchByNameViewModel;
import com.example.alien.course04task02.ui.main.MainFragment;
import com.example.alien.course04task02.ui.search.SearchFragment;

import toothpick.config.Module;


public class SearchByNameActivityModule extends Module {

    private AppCompatActivity mActivity;

    public SearchByNameActivityModule(AppCompatActivity activity) {
        mActivity = activity;

        bind(SearchFragment.class).toInstance(SearchFragment.newInstance());
        bind(AppCompatActivity.class).toInstance(mActivity);
        //todo сделать интерфейсы
        bind(BaseViewModel.class).toProvider(SearchByNameViewModelProvider.class).providesSingletonInScope();
        bind(SearchByNameViewModel.class).toProvider(SearchByNameViewModelProvider.class).providesSingletonInScope();
    }

}