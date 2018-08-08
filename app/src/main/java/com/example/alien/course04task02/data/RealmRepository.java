package com.example.alien.course04task02.data;

import com.example.alien.course04task02.data.model.Film;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import io.realm.Realm;
import io.realm.Sort;

public class RealmRepository implements IRepository {
    private AtomicLong currentId = new AtomicLong();
    private Realm mRealm;

    public RealmRepository() {
        mRealm = Realm.getDefaultInstance();
        Number number = mRealm.where(Film.class).max("id");
        if (number != null) {
            currentId.set(number.longValue());
        } else {
            currentId.set(0);
        }

    }

    @Override
    public long insertItem(Film film) {
        film.setId(currentId.incrementAndGet());
        mRealm.beginTransaction();
        mRealm.copyToRealm(film);
        mRealm.commitTransaction();
        return film.getId();
    }

    @Override
    public Film getItem(long id) {
        Film film = getFilmById(id);
        return film != null ? mRealm.copyFromRealm(film) : null;
    }

    @Override
    public boolean deleteItem(long id) {
        boolean isSuccessful = false;
        Film film = getFilmById(id);
        mRealm.beginTransaction();
        if (film != null) {
            film.deleteFromRealm();
            isSuccessful = true;
        }
        mRealm.commitTransaction();
        return isSuccessful;
    }

    @Override
    public List<Film> getAll() {
        return mRealm.where(Film.class).findAll().sort("id", Sort.ASCENDING);
    }

    @Override
    public void updateItem(Film Film) {
        mRealm.beginTransaction();
        mRealm.copyToRealmOrUpdate(Film);
        mRealm.commitTransaction();
    }

    private Film getFilmById(long id) {
        return mRealm.where(Film.class).equalTo("id", id).findFirst();
    }

    public long createFilmAndSave(String name, String director, int year, double rating) {

        Film film = new Film();
        film.setName(name);
        film.setDirector(director);
        film.setYear(year);
        film.setRating(rating);

        return insertItem(film);
    }

    @Override
    public List<Film> search(String query) {
        return null;
    }

    @Override
    public List<Film> searchInBounds(int startYear, int endYear) {
        return null;
    }

    @Override
    public List<Film> searchByDirector(String name) {
        return null;
    }

    @Override
    public List<Film> getTopFilms(int count) {
        return null;
    }
}
