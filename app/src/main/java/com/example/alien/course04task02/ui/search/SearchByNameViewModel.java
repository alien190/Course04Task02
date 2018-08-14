package com.example.alien.course04task02.ui.search;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IFilmRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

public class SearchByNameViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByNameQuery = new MutableLiveData<>();

    public SearchByNameViewModel(IFilmRepository repository, Gson gson) {
        super(repository, gson);
        searchByName();
    }

    private void searchByName() {
        mFilmList.postValue(mRepository.search(mSearchByNameQuery.getValue()));
    }

    public MutableLiveData<String> getSearchByNameQuery() {
        return mSearchByNameQuery;
    }

    public void setSearchByNameQuery(CharSequence query) {
        this.mSearchByNameQuery.setValue(query.toString());
        searchByName();
    }

}
