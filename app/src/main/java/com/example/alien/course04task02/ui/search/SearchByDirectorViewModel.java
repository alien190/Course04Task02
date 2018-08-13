package com.example.alien.course04task02.ui.search;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import java.util.List;

public class SearchByDirectorViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByDirectorQuery = new MutableLiveData<>();

    public SearchByDirectorViewModel(IRepository repository, Gson gson) {
        super(repository,gson);
        searchByDirector();
    }

    public void searchByDirector() {
        //todo разобратся с падением при изменении списка объектов
        //mFilmList.setValue(null);
        List<Film> filmList = mRepository.searchByDirector(mSearchByDirectorQuery.getValue());
        mFilmList.postValue(filmList);
    }

    public MutableLiveData<String> getSearchByDirectorQuery() {
        return mSearchByDirectorQuery;
    }

    public void setSearchByDirectorQuery(CharSequence query) {
        this.mSearchByDirectorQuery.setValue(query.toString());
        searchByDirector();
    }

}
