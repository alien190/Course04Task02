package com.example.alien.course04task02.ui.filmDetail;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.widget.EditText;

import com.example.alien.course04task02.data.IRepository;
import com.example.alien.course04task02.ui.common.BaseViewModel;
import com.google.gson.Gson;

import timber.log.Timber;

public class FilmDetailViewModel extends BaseViewModel {
    private MutableLiveData<String> mName = new MutableLiveData<>();
    private MutableLiveData<String> mYear = new MutableLiveData<>();
    private MutableLiveData<String> mDirector = new MutableLiveData<>();
    private MutableLiveData<String> mRating = new MutableLiveData<>();
    private MutableLiveData<Boolean> mIsSaved = new MutableLiveData<>();

    public FilmDetailViewModel(IRepository repository, Gson gson) {
        super(repository, gson);
        mIsSaved.postValue(false);
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

    public void apply(){
        int year = 0;
        double rating = 0;
        try {
            year = Integer.valueOf(mYear.getValue());
            rating = Double.valueOf(mRating.getValue());
        }
         catch (Throwable t) {
             Timber.d(t);
         }
        mRepository.createFilmAndSave(mName.getValue(),mDirector.getValue(), year, rating);
        mIsSaved.postValue(true);
    }

    public MutableLiveData<Boolean> getIsSaved() {
        return mIsSaved;
    }
}
