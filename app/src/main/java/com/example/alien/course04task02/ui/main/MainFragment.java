package com.example.alien.course04task02.ui.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.ui.common.BaseFragment;
import com.example.alien.course04task02.ui.filmList.ListAllViewModel;
import com.example.alien.course04task02.ui.search.SearchActivity;

import javax.inject.Inject;

public class MainFragment extends BaseFragment {

    View view;


    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fr_main_header, container, false);

        //temporarily
        Button btn = view.findViewById(R.id.btn_search);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SearchActivity.startActivity(getContext(), 1);
            }
        });
        return view;
    }
}
