package com.example.alien.course04task02.di;

import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailFragment;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModel;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModelCustomFactory;

import toothpick.config.Module;

public class FilmDetailActivityModule extends Module {

    private AppCompatActivity mActivity;
    private long mFilmId;

    public FilmDetailActivityModule(AppCompatActivity activity, long filmId) {
        mActivity = activity;
        mFilmId = filmId;
        bind(AppCompatActivity.class).toInstance(mActivity);
        bind(FilmDetailFragment.class).toProvider(FilmDetailFragmentProvider.class);
        bind(FilmDetailViewModel.class).toProvider(FilmDetailViewModelProvider.class);
        bind(Long.class).withName("FilmId").toInstance(mFilmId);
        bind(FilmDetailViewModelCustomFactory.class).toProvider(FilmDetailViewModelCustomFactoryProvider.class);
    }
}
