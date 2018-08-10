package com.example.alien.course04task02.ui.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.ui.common.BaseFragment;

public class SearchFragment extends BaseFragment {

    private int mSearchType;

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mSearchType == 1) {
            //RelativeLayout
        }
        return inflater.inflate(R.layout.fr_search_header, container, false);
    }

    public void setSearchType(int mSearchType) {
        this.mSearchType = mSearchType;
    }
}
