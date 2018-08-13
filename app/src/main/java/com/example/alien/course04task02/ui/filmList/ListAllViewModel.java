package com.example.alien.course04task02.ui.filmList;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

public class ListAllViewModel extends BaseViewModel {

    public ListAllViewModel(IRepository repository, Gson gson) {
        super(repository, gson);
        mRepository.getAllLive(list -> mFilmList.postValue(list));
    }

}
