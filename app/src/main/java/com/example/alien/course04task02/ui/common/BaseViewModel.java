package com.example.alien.course04task02.ui.common;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;

import java.util.List;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<List<Film>> mFilmList = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsEmpty = new MutableLiveData<>();

    protected IRepository mRepository;

    public BaseViewModel(IRepository repository) {
        this.mRepository = repository;
        mFilmList.observeForever(list -> mIsEmpty.setValue(!(list != null && !list.isEmpty())));
    }
    public MutableLiveData<List<Film>> getFilmList() {
        return mFilmList;
    }
    public MutableLiveData<Boolean> getIsEmpty() {
        return mIsEmpty;
    }

    public void generateData(){



        mRepository.createFilmAndSave("Фильм", "Режиссер", 2012, 7.5);
    }

}
