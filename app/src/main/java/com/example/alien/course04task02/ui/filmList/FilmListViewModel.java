package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;

import java.util.List;

public class FilmListViewModel extends ViewModel {
    private MutableLiveData<List<Film>> mFilmList = new MutableLiveData<>();
    private IRepository mRepository;

    public FilmListViewModel(IRepository mRepository) {
        this.mRepository = mRepository;
        mFilmList.setValue(mRepository.getAll());
    }

    public MutableLiveData<List<Film>> getFilmList() {
        return mFilmList;
    }
}
