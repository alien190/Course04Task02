package com.example.alien.course04task02.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.common.ViewModelCustomFactory;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModel;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModelCustomFactory;
import com.example.alien.course04task02.ui.search.SearchByYearViewModel;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

class FilmDetailViewModelProvider implements Provider<FilmDetailViewModel> {
    @Inject
    protected AppCompatActivity mActivity;
    @Inject
    protected FilmDetailViewModelCustomFactory mFactory;
    @Inject
    @Named("FilmId")
    Long mFilmId;


    @Override
    public FilmDetailViewModel get() {
        return ViewModelProviders.of(mActivity, mFactory).get(String.valueOf(mFilmId),FilmDetailViewModel.class);
    }
}