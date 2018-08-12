package com.example.alien.course04task02.di;


import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmList.SearchByDirectorViewModel;
import com.example.alien.course04task02.ui.search.SearchFragment;

import toothpick.config.Module;


public class SearchByDirectorActivityModule extends Module {

    private AppCompatActivity mActivity;

    public SearchByDirectorActivityModule(AppCompatActivity activity) {
        mActivity = activity;

        bind(SearchFragment.class).toInstance(SearchFragment.newInstance());
        bind(AppCompatActivity.class).toInstance(mActivity);
        //todo сделать интерфейсы

        bind(BaseViewModel.class).toProvider(SearchByDirectorViewModelProvider.class).providesSingletonInScope();
        bind(SearchByDirectorViewModel.class).toProvider(SearchByDirectorViewModelProvider.class).providesSingletonInScope();
        bind(Integer.class).withName("TitleId").toInstance(R.string.director_search_title);
    }

}
