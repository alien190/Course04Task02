package com.example.alien.course04task02.di;

import android.telephony.gsm.GsmCellLocation;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.RealmRepository;
import com.example.alien.course04task02.ui.filmList.ViewModelCustomFactory;
import com.google.gson.Gson;

import javax.inject.Inject;

import toothpick.config.Module;

public class ApplicationModule extends Module{

    public ApplicationModule() {
        bind(IRepository.class).toInstance(new RealmRepository());
        bind(Gson.class).toInstance(new Gson());
        bind(ViewModelCustomFactory.class).toProvider(ViewModelCustomFactoryProvider.class).providesSingletonInScope();
    }
}
