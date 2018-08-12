package com.example.alien.course04task02.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.filmList.ListAllViewModel;
import com.example.alien.course04task02.ui.filmList.SearchByNameViewModel;
import com.example.alien.course04task02.ui.filmList.ViewModelCustomFactory;

import javax.inject.Inject;
import javax.inject.Provider;

class SearchByNameViewModelProvider implements Provider<SearchByNameViewModel> {
    @Inject
    protected AppCompatActivity mActivity;
    @Inject
    protected ViewModelCustomFactory mFactory;


    @Override
    public SearchByNameViewModel get() {
        return ViewModelProviders.of(mActivity, mFactory).get(SearchByNameViewModel.class);
    }
}