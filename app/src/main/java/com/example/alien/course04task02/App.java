package com.example.alien.course04task02;

import android.app.Application;

import com.example.alien.course04task02.di.ApplicationModule;

import io.realm.Realm;
import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;
import toothpick.registries.FactoryRegistryLocator;
import toothpick.registries.MemberInjectorRegistryLocator;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes());
        MemberInjectorRegistryLocator.setRootRegistry(new com.example.alien.course04task02.MemberInjectorRegistry());
        FactoryRegistryLocator.setRootRegistry(new com.example.alien.course04task02.FactoryRegistry());
        Scope scope = Toothpick.openScope("Application");
        scope.installModules(new ApplicationModule());
        Realm.init(this);
    }
}
