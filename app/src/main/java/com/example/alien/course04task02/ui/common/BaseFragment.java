package com.example.alien.course04task02.ui.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.alien.course04task02.di.FilmListFragmentModule;
import com.example.alien.course04task02.ui.filmList.ListAllViewModel;
import com.example.alien.course04task02.ui.search.SearchActivity;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public abstract class BaseFragment extends Fragment {

    private String mScopeName;
    private String mParentScopeName;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mParentScopeName = ((SearchActivity)context).getScopeName();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mScopeName = mParentScopeName + "." + this.getClass().getSimpleName();
        Scope scope = Toothpick.openScopes(mParentScopeName, mScopeName);
        scope.installModules(new FilmListFragmentModule(this));
        Toothpick.inject(this, scope);
    }

    @Override
    public void onDestroy() {
       // Toothpick.closeScope(mScopeName);
        super.onDestroy();
    }
}
