package com.example.alien.course04task02.ui;

import android.support.v4.app.Fragment;

import com.example.alien.course04task02.common.SingleFragmentActivity;
import com.example.alien.course04task02.di.MainActivityModule;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class MainActivity extends SingleFragmentActivity {

    @Inject
    MainFragment fragment;

    @Override
    protected Fragment getFragment() {
        Scope scope = Toothpick.openScopes("Application", "MainActivity");
        scope.installModules(new MainActivityModule());
        Toothpick.inject(this, scope);
        return fragment;
    }

    @Override
    protected void onDestroy() {
        Toothpick.closeScope("MainActivity");
        super.onDestroy();
    }
}
