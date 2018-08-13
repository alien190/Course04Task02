package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;

import java.util.List;

public class SearchByYearViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByYearQuery = new MutableLiveData<>();

    public SearchByYearViewModel(IRepository repository) {
        super(repository);
        searchByYear();
    }

    public void searchByYear() {
        //todo разобратся с падением при изменении списка объектов
        mFilmList.setValue(null);
        List<Film> filmList = mRepository.searchByDirector(mSearchByYearQuery.getValue());
        mFilmList.setValue(filmList);
    }

    public MutableLiveData<String> getSearchByYearQuery() {
        return mSearchByYearQuery;
    }

    public void setSearchByYearQuery(CharSequence query) {
        this.mSearchByYearQuery.setValue(query.toString());
        searchByYear();
    }

}
