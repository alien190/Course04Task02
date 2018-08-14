package com.example.alien.course04task02.ui.filmDetail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.EditText;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import timber.log.Timber;

public class FilmDetailViewModel extends BaseViewModel {
    private MutableLiveData<String> mName = new MutableLiveData<>();
    private MutableLiveData<String> mYear = new MutableLiveData<>();
    private MutableLiveData<String> mDirector = new MutableLiveData<>();
    private MutableLiveData<String> mRating = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsSaved = new MutableLiveData<>();
    private Long mFilmId;

    public FilmDetailViewModel(IRepository repository, Gson gson, Long filmId) {
        super(repository, gson);
        mIsSaved.postValue(false);
        mFilmId = filmId;
        if (mFilmId >= 0) {
            loadFilm();
        }
    }

    private void loadFilm() {
        Film film = mRepository.getItem(mFilmId);
        mName.postValue(film.getName());
        mDirector.postValue(film.getDirector());
        mYear.postValue(String.valueOf(film.getYear()));
        mRating.postValue(String.valueOf(film.getRating()));
    }

    public MutableLiveData<String> getName() {
        return mName;
    }

    public void setName(CharSequence mName) {
        this.mName.postValue(mName.toString());
    }

    public MutableLiveData<String> getYear() {
        return mYear;
    }

    public void setYear(CharSequence mYear) {
        this.mYear.postValue(mYear.toString());
    }

    public MutableLiveData<String> getDirector() {
        return mDirector;
    }

    public void setDirector(CharSequence mDirector) {
        this.mDirector.postValue(mDirector.toString());
    }

    public MutableLiveData<String> getRating() {
        return mRating;
    }

    public void setRating(CharSequence mRating) {
        this.mRating.postValue(mRating.toString());
    }

    public void apply() {
        int year = 0;
        double rating = 0;
        try {
            year = Integer.valueOf(mYear.getValue());
            rating = Double.valueOf(mRating.getValue());
        } catch (Throwable t) {
            Timber.d(t);
        }
        if (mFilmId < 0) {
            mRepository.createFilmAndSave(mName.getValue(), mDirector.getValue(), year, rating);
        } else {
            mRepository.createFilmAndUpdate(mFilmId, mName.getValue(), mDirector.getValue(), year, rating);
        }
        mIsSaved.postValue(true);
    }

    public MutableLiveData<Boolean> getIsSaved() {
        return mIsSaved;
    }
}
