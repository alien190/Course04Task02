package com.example.alien.course04task02.ui.filmList;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.data.model.Film;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;


public class FilmListRealmAdapter extends RealmRecyclerViewAdapter<Film, FilmListViewHolder> {

    private IOnItemClickListener mOnItemClickListener;

    public FilmListRealmAdapter(IOnItemClickListener onItemClickListener) {
        super(null, true);
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public FilmListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.li_film_list, viewGroup, false);
        return new FilmListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmListViewHolder filmListViewHolder, int i) {
        filmListViewHolder.bind(getItem(i));
        filmListViewHolder.setOnItemClickListener(mOnItemClickListener);
    }


}
