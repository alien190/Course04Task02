package com.example.alien.course04task02.data;

import com.example.alien.course04task02.data.model.Film;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import io.realm.Case;
import io.realm.OrderedCollectionChangeSet;
import io.realm.OrderedRealmCollection;
import io.realm.OrderedRealmCollectionChangeListener;
import io.realm.Realm;
import io.realm.RealmChangeListener;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

public class RealmRepository implements IRepository {
    public static final int MIN_LENGTH_FOR_NAME_SEARCH = 3;
    public static final int MIN_LENGTH_FOR_DIRECTOR_SEARCH = 4;
    private AtomicLong currentId = new AtomicLong();
    private Realm mRealm;

    RealmResults<Film> realmResults;

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
    public void insertItems(List<Film> films) {
        for (Film film : films) {
            insertItem(film);
        }
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
        Film film = new Film(0, name, year, director, rating);
        return insertItem(film);
    }

    @Override
    public List<Film> search(String query) {
        if (query != null && query.length() >= MIN_LENGTH_FOR_NAME_SEARCH) {
            query = "*" + query + "*";
        } else {
            query = "";
        }
        return mRealm.where(Film.class).like("name", query, Case.INSENSITIVE).findAll();
    }

    @Override
    public List<Film> searchInBounds(int startYear, int endYear) {
        if (endYear == 0) {
            return mRealm.where(Film.class).equalTo("year", startYear).findAll();
        } else {
            return mRealm.where(Film.class).between("year", startYear, endYear).findAll();
        }
    }

    @Override
    public List<Film> searchByDirector(String name) {
        if (name == null || name.length() < MIN_LENGTH_FOR_DIRECTOR_SEARCH) {
            //todo вот с этии нужно что-то придумать :)
            name = "bla-bla-bla";
        }
        return mRealm.where(Film.class).beginsWith("director", name, Case.INSENSITIVE).findAll();
    }

    @Override
    public List<Film> getTopFilms(int count) {

        List<Film> retList = new ArrayList<>();

        List<Film> results = mRealm.copyFromRealm(mRealm.where(Film.class).sort("rating", Sort.DESCENDING).findAll());
        for (Film film : results) {
            if (retList.size() >= count) {
                break;
            }
            retList.add(film);
        }
        return retList;
    }


    @Override
    public void createFilmAndUpdate(long id, String name, String director, int year, double rating) {
        Film film = new Film(id, name, year, director, rating);
        updateItem(film);
    }

}
