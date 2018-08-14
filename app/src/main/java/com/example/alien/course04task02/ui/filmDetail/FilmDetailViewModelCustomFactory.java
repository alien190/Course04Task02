package com.example.alien.course04task02.ui.filmDetail;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.filmList.ListAllViewModel;
import com.example.alien.course04task02.ui.search.SearchByDirectorViewModel;
import com.example.alien.course04task02.ui.search.SearchByNameViewModel;
import com.example.alien.course04task02.ui.search.SearchByTopViewModel;
import com.example.alien.course04task02.ui.search.SearchByYearViewModel;
import com.google.gson.Gson;

import javax.inject.Named;

public class FilmDetailViewModelCustomFactory implements ViewModelProvider.Factory {
    private IRepository mRepository;
    private Gson mGson;
    private Long mFilmId;

    public FilmDetailViewModelCustomFactory(IRepository repository, Gson gson, Long filmId) {

        this.mRepository = repository;
        this.mGson = gson;
        this.mFilmId = filmId;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FilmDetailViewModel(mRepository, mGson, mFilmId);

    }
}
