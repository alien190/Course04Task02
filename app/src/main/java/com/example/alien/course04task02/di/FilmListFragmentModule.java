package com.example.alien.course04task02.di;



import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.filmList.FilmListAdapter;
import com.example.alien.course04task02.ui.filmList.FilmListViewModel;

import javax.inject.Provider;

import toothpick.config.Module;

public class FilmListFragmentModule extends Module {
    private Fragment mFragment;

    public FilmListFragmentModule(Fragment fragment) {
        mFragment = fragment;
        bind(FilmListAdapter.class).to(FilmListAdapter.class);
        bind(FilmListViewModel.class).toProvider(FilmListViewModelProvider.class);
    }

    class FilmListViewModelProvider implements Provider<FilmListViewModel> {
        @Override
        public FilmListViewModel get() {
            return ViewModelProviders.of(mFragment).get(FilmListViewModel.class);
        }
    }
}
