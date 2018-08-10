package com.example.alien.course04task02.di;


import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.filmList.FilmListAdapter;
import com.example.alien.course04task02.ui.filmList.FilmListViewModel;

import toothpick.config.Module;

public class FilmListFragmentModule extends Module {
    private Fragment mFragment;

    public FilmListFragmentModule(Fragment fragment) {
        mFragment = fragment;
        if (mFragment instanceof FilmListAdapter.IOnItemClickListener) {
            bind(FilmListAdapter.class).toInstance(new FilmListAdapter((FilmListAdapter.IOnItemClickListener) mFragment));
        } else {
            bind(FilmListAdapter.class).toInstance(new FilmListAdapter(null));
        }
        bind(FilmListViewModel.class).toProvider(FilmListViewModelProvider.class).providesSingletonInScope();
        bind(Fragment.class).withName("FilmListFragment").toInstance(mFragment);
    }


}