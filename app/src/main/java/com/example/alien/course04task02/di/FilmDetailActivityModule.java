package com.example.alien.course04task02.di;

import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailFragment;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModel;

import toothpick.config.Module;

public class FilmDetailActivityModule extends Module {

    AppCompatActivity mActivity;

    public FilmDetailActivityModule(AppCompatActivity activity) {
        mActivity = activity;
        bind(AppCompatActivity.class).toInstance(mActivity);
        bind(FilmDetailFragment.class).toInstance(FilmDetailFragment.newInstance());
        bind(FilmDetailViewModel.class).toProvider(FilmDetailViewModelProvider.class).providesSingletonInScope();
    }
}
