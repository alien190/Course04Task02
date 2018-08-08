package com.example.alien.course04task02.di;


import com.example.alien.course04task02.ui.MainFragment;
import toothpick.config.Module;


public class MainActivityModule extends Module {
    public MainActivityModule() {
        bind(MainFragment.class).toInstance(MainFragment.newInstance());
    }

}
