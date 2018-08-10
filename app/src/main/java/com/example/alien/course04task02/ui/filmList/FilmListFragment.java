package com.example.alien.course04task02.ui.filmList;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.di.FilmListFragmentModule;
import com.example.alien.course04task02.ui.common.BaseFragment;

import javax.inject.Inject;
import javax.inject.Named;

import butterknife.BindView;
import butterknife.ButterKnife;
import toothpick.Scope;
import toothpick.Toothpick;

public class FilmListFragment extends BaseFragment implements FilmListAdapter.IOnItemClickListener {
    View view;
    @BindView(R.id.rvFilmList)
    RecyclerView mRecyclerView;

    @Inject
    protected FilmListAdapter mAdapter;

    private String mScopeName;

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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mViewModel.getFilmList().observe(this, list -> mAdapter.submitList(list));
    }



    @Override
    public void OnItemClick(long id) {
        Toast.makeText(getContext(), "click id " + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean OnItemLongClick(long id) {
        Toast.makeText(getContext(), "long click id " + id, Toast.LENGTH_SHORT).show();
        return true;
    }
}
