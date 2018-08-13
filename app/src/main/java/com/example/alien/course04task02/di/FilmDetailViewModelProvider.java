package com.example.alien.course04task02.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.common.ViewModelCustomFactory;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModel;
import com.example.alien.course04task02.ui.search.SearchByYearViewModel;

import javax.inject.Inject;
import javax.inject.Provider;

class FilmDetailViewModelProvider implements Provider<FilmDetailViewModel> {
    @Inject
    protected AppCompatActivity mActivity;
    @Inject
    protected ViewModelCustomFactory mFactory;


    @Override
    public FilmDetailViewModel get() {
        return ViewModelProviders.of(mActivity, mFactory).get(FilmDetailViewModel.class);
    }
}