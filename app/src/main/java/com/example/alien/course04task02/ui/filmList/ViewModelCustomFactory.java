package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.alien.course04task02.data.IRepository;

public class ViewModelCustomFactory implements ViewModelProvider.Factory {
    private IRepository mRepository;

    public ViewModelCustomFactory(IRepository repository) {
        mRepository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(modelClass == SearchByNameViewModel.class) {
            return (T) new SearchByNameViewModel(mRepository);
        }
        if(modelClass == SearchByDirectorViewModel.class) {
            return (T) new SearchByDirectorViewModel(mRepository);
        }
        if(modelClass == SearchByYearViewModel.class) {
            return (T) new SearchByYearViewModel(mRepository);
        }
        return (T) new ListAllViewModel(mRepository);
    }
}
