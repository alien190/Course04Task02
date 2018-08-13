package com.example.alien.course04task02.ui.filmDetail;

import android.arch.lifecycle.ViewModel;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

public class FilmDetailViewModel extends BaseViewModel {
    public FilmDetailViewModel(IRepository repository, Gson gson) {
        super(repository, gson);
    }
}
