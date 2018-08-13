package com.example.alien.course04task02.ui.filmList;

import android.arch.lifecycle.MutableLiveData;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;

import java.util.List;

public class SearchByTopViewModel extends BaseViewModel {

    private MutableLiveData<String> mSearchByTopQuery = new MutableLiveData<>();

    public SearchByTopViewModel(IRepository repository) {
        super(repository);
        searchByYear();
    }

    public void searchByYear() {
        //todo разобратся с падением при изменении списка объектов
        mFilmList.setValue(null);
        List<Film> filmList = mRepository.searchByDirector(mSearchByTopQuery.getValue());
        mFilmList.setValue(filmList);
    }

    public MutableLiveData<String> getSearchByTopQuery() {
        return mSearchByTopQuery;
    }

    public void setSearchByTopQuery(CharSequence query) {
        this.mSearchByTopQuery.setValue(query.toString());
        searchByYear();
    }

}
