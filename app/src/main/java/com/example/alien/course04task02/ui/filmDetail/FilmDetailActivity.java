package com.example.alien.course04task02.ui.filmDetail;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.alien.course04task02.di.FilmDetailActivityModule;
import com.example.alien.course04task02.ui.common.SingleFragmentActivity;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class FilmDetailActivity extends SingleFragmentActivity {
    @Inject
    FilmDetailFragment mFilmDetailFragment;


    @Override
    protected Fragment getFragment() {

        Scope scope = Toothpick.openScopes("Application", this.getClass().getSimpleName());
        scope.installModules(new FilmDetailActivityModule(this));
        Toothpick.inject(this, scope);

        return mFilmDetailFragment;
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, FilmDetailActivity.class);
        context.startActivity(intent);
    }

}
