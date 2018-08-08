package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.alien.course04task02.data.IRepository;

public class FilmListViewModelCustomFactory implements ViewModelProvider.Factory {
    private IRepository mRepository;

    public FilmListViewModelCustomFactory(IRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new FilmListViewModel(mRepository);
    }
}
