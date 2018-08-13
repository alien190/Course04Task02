package com.example.alien.course04task02.ui.filmDetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.di.FilmListFragmentModule;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class FilmDetailFragment extends Fragment {

    @Inject
    FilmDetailViewModel mViewModel;

    public static FilmDetailFragment newInstance() {

        Bundle args = new Bundle();

        FilmDetailFragment fragment = new FilmDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Scope scope = Toothpick.openScopes(getActivity().getClass().getSimpleName());
        Toothpick.inject(this, scope);
    }
}
