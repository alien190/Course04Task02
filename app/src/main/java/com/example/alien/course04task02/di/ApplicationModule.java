package com.example.alien.course04task02.di;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.RealmRepository;

import toothpick.config.Module;

public class ApplicationModule extends Module{
    public ApplicationModule() {
        bind(IRepository.class).toInstance(new RealmRepository());
    }
}
