package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FilmListViewModel extends ViewModel {
    private MutableLiveData<List<Film>> mFilmList = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsEmpty = new MutableLiveData<>();
    private MutableLiveData<String> mSearchByNameQuery = new MutableLiveData<>();
    private IRepository mRepository;

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            mSearchByNameQuery.setValue(charSequence.toString());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    public FilmListViewModel(IRepository repository) {
        this.mRepository = repository;
        mFilmList.observeForever(list -> mIsEmpty.setValue(!(list != null && !list.isEmpty())));
        mFilmList.setValue(mRepository.getAll());
        mSearchByNameQuery.setValue("dsadas");

        // mRepository.createFilmAndSave("meg", "Джон Тёртелтауб", 2018, 5.0);
    }

    public MutableLiveData<List<Film>> getFilmList() {
        return mFilmList;
    }

    public void searchByName(String query) {
        mFilmList.setValue(null);
        mFilmList.setValue(mRepository.search(query));
        //mIsEmpty.setValue(true);
    }

    public MutableLiveData<Boolean> getIsEmpty() {
        return mIsEmpty;
    }

    public MutableLiveData<String> getSearchByNameQuery() {
        return mSearchByNameQuery;
    }

    public void setSearchByNameQuery(CharSequence query) {
        this.mSearchByNameQuery.setValue(query.toString());
        searchByName(query.toString());
    }

    public TextWatcher getWatcher() {
        return watcher;
    }
}
