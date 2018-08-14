package com.example.alien.course04task02.ui.main;

import android.content.res.AssetManager;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.alien.course04task02.BR;
import com.example.alien.course04task02.R;
import com.example.alien.course04task02.databinding.MainBinding;
import com.example.alien.course04task02.databinding.SearchByDirectorBinding;
import com.example.alien.course04task02.databinding.SearchByNameBinding;
import com.example.alien.course04task02.databinding.SearchByTopBinding;
import com.example.alien.course04task02.databinding.SearchByYearBinding;
import com.example.alien.course04task02.ui.common.BaseFragment;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.example.alien.course04task02.ui.filmDetail.FilmDetailActivity;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Scanner;

import javax.inject.Inject;

import timber.log.Timber;

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
                setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mi_generate: {

                String json = "";

                try {
                    AssetManager am = getContext().getAssets();
                    InputStream is = am.open("filmList.json");
                    try (Scanner s = new Scanner(is).useDelimiter("\\A")) {
                        json = s.hasNext() ? s.next() : "";
                    }
                } catch (Throwable t) {
                    Timber.d(t);
                }
                mViewModel.generateData(json);
                return true;
            }
            case R.id.mi_add: {
                FilmDetailActivity.startActivity(getContext(),-1);
                return true;
            }

            case R.id.mi_search_by_name: {
                MainActivity.startActivity(getContext(), MainActivity.TYPE_SEARCH_BY_NAME);
                return true;
            }
            case R.id.mi_search_by_year: {
                MainActivity.startActivity(getContext(), MainActivity.TYPE_SEARCH_BY_YEAR);
                return true;
            }
            case R.id.mi_search_by_director: {
                MainActivity.startActivity(getContext(), MainActivity.TYPE_SEARCH_BY_DIRECTOR);
                return true;
            }
            case R.id.mi_search_by_top: {
                MainActivity.startActivity(getContext(), MainActivity.TYPE_SEARCH_BY_TOP);
                return true;
            }
            default:
                return false;
        }
    }
}
