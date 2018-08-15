package com.example.alien.course04task02.ui.filmDetail;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.example.alien.course04task02.R;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.di.FilmDetailActivityModule;
import com.example.alien.course04task02.di.FilmDetailDialogFragmentModule;

import javax.inject.Inject;

import toothpick.Scope;
import toothpick.Toothpick;

public class FilmDetailDialogFragment extends DialogFragment {

    private Scope mScope;
    private static final String KEY_FILM_ID = "FilmDetailDialogFragment.KeyFilmId";

    @Inject
    protected FilmDetailViewModel mViewModel;


    public static FilmDetailDialogFragment newInstance(long id) {

        Bundle args = new Bundle();
        args.putLong(KEY_FILM_ID, id);
        FilmDetailDialogFragment fragment = new FilmDetailDialogFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        toothpickInject();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.fr_detail_dialog_fragment, null))
                // Add action buttons
                .setPositiveButton("ok", null)
                .setNegativeButton("cancel", null);
        return builder.create();

    }

    private void toothpickInject() {
        long id = -1;
        if (getArguments() != null) {
            id = getArguments().getLong(KEY_FILM_ID, -1);
        }

        mScope = Toothpick.openScopes("Application", this.getClass().getSimpleName());
        mScope.installModules(new FilmDetailDialogFragmentModule(this, id));
        Toothpick.inject(this, mScope);
    }

    @Override
    public void onDetach() {
        Toothpick.closeScope(this.getClass().getSimpleName());
        super.onDetach();
    }
}
