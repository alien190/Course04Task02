package com.example.alien.course04task02.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.filmList.SearchByTopViewModel;
import com.example.alien.course04task02.ui.filmList.SearchByYearViewModel;
import com.example.alien.course04task02.ui.filmList.ViewModelCustomFactory;

import javax.inject.Inject;
import javax.inject.Provider;

class SearchByTopViewModelProvider implements Provider<SearchByTopViewModel> {
    @Inject
    protected AppCompatActivity mActivity;
    @Inject
    protected ViewModelCustomFactory mFactory;


    @Override
    public SearchByTopViewModel get() {
        return ViewModelProviders.of(mActivity, mFactory).get(SearchByTopViewModel.class);
    }
}