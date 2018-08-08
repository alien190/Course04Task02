package com.example.alien.course04task02;

import android.app.Application;

import io.realm.Realm;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        //will generate after one @Inject
        //MemberInjectorRegistryLocator.setRootRegistry(new com.example.alien.course04task02.MemberInjectorRegistry());
        //FactoryRegistryLocator.setRootRegistry(new com.example.alien.course04task02.FactoryRegistry());

        //sAppScope = Toothpick.openScope(App.class);
        //sAppScope.installModules(new SmoothieApplicationModule(this), new NetworkModule(), new AppModule(this));

        Realm.init(this);
    }
}
