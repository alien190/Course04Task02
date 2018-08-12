package com.example.alien.course04task02.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.di.MainActivityModule;
import com.example.alien.course04task02.di.SearchByDirectorActivityModule;
import com.example.alien.course04task02.di.SearchByNameActivityModule;

import javax.inject.Inject;
import javax.inject.Named;

import toothpick.Scope;
import toothpick.Toothpick;
import toothpick.config.Module;

public class MainActivity extends AppCompatActivity {

    public static final int TYPE_SEARCH_BY_NAME = 1;
    public static final int TYPE_SEARCH_BY_DIRECTOR = 2;
    private static final String TYPE_KEY = "SearchActivityTypeKey";

    @Inject
    MainFragment mMainFragment;

    private int mSearchType;

    @Inject
    @Named("TitleId")
    protected Integer mTitleId;

    private String mScopeName;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        toothpickInject();

        setContentView(R.layout.ac_double_fragment);
        if (savedInstanceState == null) {
            changeFragment(getFragment());
        }

        setTitle(mTitleId);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public static void startActivity(Context context, int type) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        intent.putExtra(TYPE_KEY, type);
        context.startActivity(intent);
    }


    protected Fragment getFragment() {
        mMainFragment.setSearchType(getIntent().getIntExtra(TYPE_KEY, 0));
        return mMainFragment;
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

    private void toothpickInject() {

        Module module;
        mScopeName = this.getClass().getSimpleName() + ".";

        switch (getIntent().getIntExtra(TYPE_KEY, 0)) {
            case TYPE_SEARCH_BY_DIRECTOR: {
                module = new SearchByDirectorActivityModule(this);
                mScopeName = "SEARCH_BY_DIRECTOR_SCOPE";
                break;
            }
            case TYPE_SEARCH_BY_NAME: {
                module = new SearchByNameActivityModule(this);
                mScopeName = "SEARCH_BY_NAME_SCOPE";
                break;
            }
            default: {
                module = new MainActivityModule(this);
                mScopeName = "MAIN_SCOPE";
                break;
            }
        }

        Scope scope = Toothpick.openScopes("Application", mScopeName);
        scope.installModules(module);
        Toothpick.inject(this, scope);

    }

    public String getScopeName() {
        return mScopeName;
    }
}
