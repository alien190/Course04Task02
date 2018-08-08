package com.example.alien.course04task02.ui.filmList;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FilmListFragment extends Fragment {
    View view;
    @BindView(R.id.rvFilmList)
    RecyclerView mRecyclerView;

    public static FilmListFragment newInstance() {

        Bundle args = new Bundle();

        FilmListFragment fragment = new FilmListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_film_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}
