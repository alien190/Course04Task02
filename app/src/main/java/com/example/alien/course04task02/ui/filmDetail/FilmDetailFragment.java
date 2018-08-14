package com.example.alien.course04task02.ui.filmDetail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.databinding.FilmDetailBinding;
import com.example.alien.course04task02.di.FilmListFragmentModule;

import javax.inject.Inject;
import javax.inject.Named;

import toothpick.Scope;
import toothpick.Toothpick;

public class FilmDetailFragment extends Fragment {

    @Inject
    protected FilmDetailViewModel mViewModel;
    @Inject
    @Named("FilmId")
    protected Long mFilmId;


    private Scope mScope;

    private FilmDetailBinding mFilmDetailBinding;

    public static FilmDetailFragment newInstance() {

        Bundle args = new Bundle();

        FilmDetailFragment fragment = new FilmDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFilmDetailBinding = FilmDetailBinding.inflate(inflater, container, false);
        return mFilmDetailBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mScope = Toothpick.openScopes(getActivity().getClass().getSimpleName());
        Toothpick.inject(this, mScope);

        mFilmDetailBinding.setVm(mViewModel);
        mFilmDetailBinding.notifyChange();

        //Toast.makeText(getActivity(), String.valueOf(mFilmId), Toast.LENGTH_SHORT).show();

        mViewModel.getIsSaved().observe(this, saved -> {
            if (saved != null && saved) {
                getActivity().finish();
                Toothpick.closeScope(getActivity().getClass().getSimpleName());
            }
        });
    }
}
