package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import java.util.List;

import timber.log.Timber;

public class SearchByTopViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByTopQuery = new MutableLiveData<>();

    public SearchByTopViewModel(IRepository repository, Gson gson) {
        super(repository, gson);
        searchByTop();
    }

    public void searchByTop() {
        //todo разобратся с падением при изменении списка объектов
        //mFilmList.setValue(null);
        int count = 0;
        try {
            count = Integer.valueOf(mSearchByTopQuery.getValue());
        } catch (Throwable t) {
            Timber.d(t);
        }

        List<Film> filmList = mRepository.getTopFilms(count);
        mFilmList.setValue(filmList);
    }

    public MutableLiveData<String> getSearchByTopQuery() {
        return mSearchByTopQuery;
    }

    public void setSearchByTopQuery(CharSequence query) {
        this.mSearchByTopQuery.setValue(query.toString());
        searchByTop();
    }

}
