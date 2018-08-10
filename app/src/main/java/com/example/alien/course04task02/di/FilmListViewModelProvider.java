package com.example.alien.course04task02.di;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.filmList.FilmListViewModel;
import com.example.alien.course04task02.ui.filmList.FilmListViewModelCustomFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

class FilmListViewModelProvider implements Provider<FilmListViewModel> {
    @Inject
    IRepository mRepository;
    @Inject
    AppCompatActivity mActivity;


    @Override
    public FilmListViewModel get() {
            FilmListViewModelCustomFactory factory = new FilmListViewModelCustomFactory(mRepository);
            return ViewModelProviders.of(mActivity, factory).get(FilmListViewModel.class);
    }
}