package com.example.alien.course04task02;

import android.app.Application;

import io.realm.Realm;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        MemberInjectorRegistryLocator.setRootRegistry(new com.example.alien.course04task02.MemberInjectorRegistry());
        FactoryRegistryLocator.setRootRegistry(new com.example.alien.course04task02.FactoryRegistry());
        Toothpick.openScope("Application");
        Realm.init(this);
    }
}
