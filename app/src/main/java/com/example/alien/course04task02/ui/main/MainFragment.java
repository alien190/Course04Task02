package com.example.alien.course04task02.ui.main;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.BR;
import com.example.alien.course04task02.databinding.MainBinding;
import com.example.alien.course04task02.databinding.SearchByDirectorBinding;
import com.example.alien.course04task02.databinding.SearchByNameBinding;
import com.example.alien.course04task02.databinding.SearchByTopBinding;
import com.example.alien.course04task02.databinding.SearchByYearBinding;
import com.example.alien.course04task02.ui.common.BaseFragment;
import com.example.alien.course04task02.ui.common.BaseViewModel;

import javax.inject.Inject;

public class MainFragment extends BaseFragment {


    private static final String KEY_TYPE = "KeyType";

    @Inject
    protected BaseViewModel mViewModel;


    private int mSearchType;
    private ViewDataBinding mViewDataBinding;


    public static MainFragment newInstance(String parentScopeName, int type) {

        Bundle args = new Bundle();
        args.putString(KEY_PARENT_SCOPE_NAME, parentScopeName);
        args.putInt(KEY_TYPE, type);

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // mSearchType = mSearchType != 0 ? mSearchType : MainActivity.TYPE_SEARCH_BY_NAME;
        // int layoutId;

        mSearchType = getArguments().getInt(KEY_TYPE, 0);

        switch (mSearchType) {
            case MainActivity.TYPE_SEARCH_BY_DIRECTOR: {
                mViewDataBinding = SearchByDirectorBinding.inflate(inflater, container, false);
                break;
            }
            case MainActivity.TYPE_SEARCH_BY_NAME: {
                mViewDataBinding = SearchByNameBinding.inflate(inflater, container, false);
                break;
            }
            case MainActivity.TYPE_SEARCH_BY_YEAR: {
                mViewDataBinding = SearchByYearBinding.inflate(inflater, container, false);
                break;
            }
            case MainActivity.TYPE_SEARCH_BY_TOP: {
                mViewDataBinding = SearchByTopBinding.inflate(inflater, container, false);
                break;
            }
            default: {
                mViewDataBinding = MainBinding.inflate(inflater, container, false);
                mSearchType = 0;
                break;
            }
        }

        return mViewDataBinding.getRoot();
    }

//    public void setSearchType(int mSearchType) {
//        this.mSearchType = mSearchType;
//    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewDataBinding.setVariable(BR.vm, mViewModel);

    }
}
