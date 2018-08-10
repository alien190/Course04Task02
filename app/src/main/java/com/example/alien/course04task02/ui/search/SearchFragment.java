package com.example.alien.course04task02.ui.search;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.ui.common.BaseFragment;

public class SearchFragment extends BaseFragment {

    private int mSearchType;
    private View view;

    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // mSearchType = mSearchType != 0 ? mSearchType : SearchActivity.TYPE_SEARCH_BY_NAME;
        int layoutId;

        switch (mSearchType) {
            case SearchActivity.TYPE_SEARCH_BY_NAME: {
                layoutId = R.layout.fr_search_header;
                break;
            }
            default: {
                layoutId = R.layout.fr_search_header;
                break;
            }
        }

        view = inflater.inflate(layoutId, container, false);
        return view;
    }

    public void setSearchType(int mSearchType) {
        this.mSearchType = mSearchType;
    }
}
