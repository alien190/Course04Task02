package com.example.alien.course04task02.di;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.common.ViewModelCustomFactory;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailViewModelCustomFactory;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

public class FilmDetailViewModelCustomFactoryProvider implements Provider<FilmDetailViewModelCustomFactory> {

    protected IRepository mRepository;
    private Gson mGson;
    private Long mFilmId;

    @Inject
    public FilmDetailViewModelCustomFactoryProvider(IRepository mRepository, Gson gson, @Named("FilmId") Long filmId) {
        this.mRepository = mRepository;
        this.mGson = gson;
        this.mFilmId = filmId;
    }

    @Override
    public FilmDetailViewModelCustomFactory get() {
        return new FilmDetailViewModelCustomFactory(mRepository, mGson, mFilmId);
    }
}
