package com.example.alien.course04task02.ui.filmList;

import com.example.alien.course04task02.data.IFilmRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

public class ListAllViewModel extends BaseViewModel {

    public ListAllViewModel(IFilmRepository repository, Gson gson) {
        super(repository, gson);
        //mRepository.getAllLive(list -> mFilmList.postValue(list));
        //data = mRepository.getAllRealm();
        mFilmList.postValue(mRepository.getAll());

    }

}
