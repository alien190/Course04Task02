package com.example.alien.course04task02.ui.common;

import android.app.Fragment;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.content.res.AssetManager;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.data.model.FilmRead;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.InputStream;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.inject.Inject;

import timber.log.Timber;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<List<Film>> mFilmList = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsEmpty = new MutableLiveData<>();

    protected IRepository mRepository;

    protected Gson mGson;

    public BaseViewModel(IRepository repository, Gson gson) {
        this.mRepository = repository;
        this.mGson = gson;
        mFilmList.observeForever(list -> mIsEmpty.setValue(!(list != null && !list.isEmpty())));
    }

    public MutableLiveData<List<Film>> getFilmList() {
        return mFilmList;
    }

    public MutableLiveData<Boolean> getIsEmpty() {
        return mIsEmpty;
    }

    public void generateData(String json) {
        Type type = new TypeToken<List<Film>>() {}.getType();
        List<Film> films = mGson.fromJson(json, type);
        mRepository.insertItems(films);
    }

}
