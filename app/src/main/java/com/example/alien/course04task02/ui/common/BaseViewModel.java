package com.example.alien.course04task02.ui.common;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.realm.OrderedRealmCollection;
import io.realm.RealmChangeListener;
import io.realm.RealmResults;

public abstract class BaseViewModel extends ViewModel {
    protected MutableLiveData<List<Film>> mFilmList = new MutableLiveData<>();
    protected OrderedRealmCollection<Film> data;
    private MutableLiveData<Boolean> mIsEmpty = new MutableLiveData<>();

    protected IRepository mRepository;

    protected Gson mGson;

    public BaseViewModel(IRepository repository, Gson gson) {
        this.mRepository = repository;
        this.mGson = gson;
        mFilmList.observeForever(list ->
        {
            mIsEmpty.postValue(list != null && list.isEmpty());

            if (list instanceof RealmResults) {
                RealmResults<Film> filmRealmResults = (RealmResults<Film>) list;
                filmRealmResults.addChangeListener(films -> mIsEmpty.postValue(films.isEmpty()));
            }
        });
    }

    public MutableLiveData<List<Film>> getFilmList() {
        return mFilmList;
    }

    public MutableLiveData<Boolean> getIsEmpty() {
        return mIsEmpty;
    }

    public void generateData(String json) {
        Type type = new TypeToken<List<Film>>() {
        }.getType();
        List<Film> films = mGson.fromJson(json, type);
        mRepository.insertItems(films);
    }

    public void deleteItem(long id) {
        mRepository.deleteItem(id);
    }

    public OrderedRealmCollection<Film> getData() {
        return data;
    }
}
