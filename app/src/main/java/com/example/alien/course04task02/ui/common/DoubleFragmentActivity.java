package com.example.alien.course04task02.ui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.di.DoubleFragmentActivityModule;

import toothpick.Scope;
import toothpick.Toothpick;

public abstract class DoubleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String scopeName = this.getClass().getSimpleName();
        Scope scope = Toothpick.openScopes("Application", this.getClass().getSimpleName());
        scope.installModules(new DoubleFragmentActivityModule(this));
        Toothpick.inject(this, scope);

        setContentView(R.layout.ac_double_fragment);
        if (savedInstanceState == null) {
            changeFragment(getFragment());
        }
    }

    protected abstract Fragment getFragment();

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    protected void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(fragment.getClass().getSimpleName())
                .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       // Toothpick.closeScope(this.getClass().getSimpleName());
    }
}
