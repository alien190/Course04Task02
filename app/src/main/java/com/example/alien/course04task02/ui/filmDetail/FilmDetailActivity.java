package com.example.alien.course04task02.ui.filmDetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.example.alien.course04task02.di.FilmDetailActivityModule;
import com.example.alien.course04task02.ui.common.SingleFragmentActivity;

import javax.inject.Inject;
import javax.inject.Named;

import toothpick.Scope;
import toothpick.Toothpick;

public class FilmDetailActivity extends SingleFragmentActivity {

    public static final String KEY_FILM_ID = "KeyFilmId";

    @Inject
    FilmDetailFragment mFilmDetailFragment;

    @Inject
    @Named("FilmId")
    Long mFilmId;

    private Scope mScope;

    @Override
    protected Fragment getFragment() {

        mScope = Toothpick.openScopes("Application", this.getClass().getSimpleName());
        mScope.installModules(new FilmDetailActivityModule(this, getIntent().getLongExtra(KEY_FILM_ID, 0)));
        Toothpick.inject(this, mScope);

        return mFilmDetailFragment;
    }

    public static void startActivity(Context context, long filmId) {
        Intent intent = new Intent();
        intent.putExtra(KEY_FILM_ID, filmId);
        intent.setClass(context, FilmDetailActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void closeScope() {
        Toothpick.closeScope(this.getClass().getSimpleName());
    }
}
