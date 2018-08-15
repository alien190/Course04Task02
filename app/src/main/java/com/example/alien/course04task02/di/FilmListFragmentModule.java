package com.example.alien.course04task02.di;


import android.support.v4.app.Fragment;

import com.example.alien.course04task02.ui.filmList.FilmListAdapter;
import com.example.alien.course04task02.ui.filmList.FilmListRealmAdapter;
import com.example.alien.course04task02.ui.filmList.IOnItemClickListener;

import toothpick.config.Module;

public class FilmListFragmentModule extends Module {
    private Fragment mFragment;

    public FilmListFragmentModule(Fragment fragment) {
        mFragment = fragment;

        if (mFragment instanceof IOnItemClickListener) {
            bind(FilmListRealmAdapter.class).toInstance(new FilmListRealmAdapter((IOnItemClickListener) mFragment));
            bind(FilmListAdapter.class).toInstance(new FilmListAdapter((IOnItemClickListener) mFragment));
        } else {
            bind(FilmListRealmAdapter.class).toInstance(new FilmListRealmAdapter(null));
            bind(FilmListAdapter.class).toInstance(new FilmListAdapter(null));
        }
    }


}
