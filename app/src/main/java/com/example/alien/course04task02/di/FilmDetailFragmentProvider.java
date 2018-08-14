package com.example.alien.course04task02.di;

import com.example.alien.course04task02.ui.filmDetail.FilmDetailFragment;

import javax.inject.Inject;
import javax.inject.Provider;

class FilmDetailFragmentProvider implements Provider<FilmDetailFragment> {

    @Inject
    public FilmDetailFragmentProvider() {
    }

    @Override
    public FilmDetailFragment get() {
        return FilmDetailFragment.newInstance();
    }
}