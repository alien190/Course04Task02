package com.example.alien.course04task02.ui.search;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.alien.course04task02.BR;
import com.example.alien.course04task02.R;
import com.example.alien.course04task02.databinding.SearchByDirectorBinding;
import com.example.alien.course04task02.databinding.SearchByNameBinding;
import com.example.alien.course04task02.ui.common.BaseFragment;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmList.SearchByNameViewModel;

import javax.inject.Inject;

public class SearchFragment extends BaseFragment {

    @Inject
    protected BaseViewModel mViewModel;


    private int mSearchType;
    private ViewDataBinding mViewDataBinding;

    private int mTitleId;


    public static SearchFragment newInstance() {

        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mSearchType = mSearchType != 0 ? mSearchType : SearchActivity.TYPE_SEARCH_BY_NAME;
        // int layoutId;

        switch (mSearchType) {
            case SearchActivity.TYPE_SEARCH_BY_DIRECTOR: {
                mViewDataBinding = SearchByDirectorBinding.inflate(inflater, container, false);
                mTitleId = R.string.name_search;
                break;
            }
            default: {
                mViewDataBinding = SearchByNameBinding.inflate(inflater, container, false);
                mTitleId = R.string.name_search;
                break;
            }
        }

        return mViewDataBinding.getRoot();
    }

    public void setSearchType(int mSearchType) {
        this.mSearchType = mSearchType;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.setVariable(BR.vm, mViewModel);
        if (getActivity() != null) getActivity().setTitle(mTitleId);

    }
}
