package com.example.alien.course04task02.ui.search;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IFilmRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

public class SearchByDirectorViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByDirectorQuery = new MutableLiveData<>();

    public SearchByDirectorViewModel(IFilmRepository repository, Gson gson) {
        super(repository, gson);
        searchByDirector();
    }

    private void searchByDirector() {
        mFilmList.postValue(mRepository.searchByDirector(mSearchByDirectorQuery.getValue()));
    }

    public MutableLiveData<String> getSearchByDirectorQuery() {
        return mSearchByDirectorQuery;
    }

    public void setSearchByDirectorQuery(CharSequence query) {
        this.mSearchByDirectorQuery.setValue(query.toString());
        searchByDirector();
    }

}
