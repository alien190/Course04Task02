package com.example.alien.course04task02.di;

import com.example.alien.course04task02.ui.filmList.FilmListAdapter;

import toothpick.config.Module;

public class FilmListFragmentModule extends Module {
    public FilmListFragmentModule() {
        bind(FilmListAdapter.class).to(FilmListAdapter.class);
    }
}
