package com.example.alien.course04task02.ui.filmList;

import com.example.alien.course04task02.data.IFilmRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ListAllViewModel extends BaseViewModel {

    public ListAllViewModel(IFilmRepository repository, Gson gson) {
        super(repository, gson);
        updateFromRepository();
    }

    @Override
    protected void updateFromRepository() {
        mFilmList.postValue(mRepository.getAll());
    }
}
