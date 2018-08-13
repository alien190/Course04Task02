package com.example.alien.course04task02.ui.search;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import java.util.List;

public class SearchByNameViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByNameQuery = new MutableLiveData<>();

    public SearchByNameViewModel(IRepository repository, Gson gson) {
        super(repository, gson);
        searchByName();
    }

    public void searchByName() {
        //todo разобратся с падением при изменении списка объектов
        //mFilmList.setValue(null);
        List<Film> filmList = mRepository.search(mSearchByNameQuery.getValue());
        mFilmList.postValue(filmList);
    }

    public MutableLiveData<String> getSearchByNameQuery() {
        return mSearchByNameQuery;
    }

    public void setSearchByNameQuery(CharSequence query) {
        this.mSearchByNameQuery.setValue(query.toString());
        searchByName();
    }

}