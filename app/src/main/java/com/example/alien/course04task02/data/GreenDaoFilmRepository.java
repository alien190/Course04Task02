package com.example.alien.course04task02.data;

import com.example.alien.course04task02.data.model.Film;
import com.example.alien.course04task02.data.model.FilmDao;

import java.util.List;

public class GreenDaoFilmRepository implements IFilmRepository {

    private FilmDao mFilmDao;

    private static final int MIN_LENGTH_FOR_NAME_SEARCH = 3;
    private static final int MIN_LENGTH_FOR_DIRECTOR_SEARCH = 4;

    public GreenDaoFilmRepository(FilmDao mFilmDao) {
        this.mFilmDao = mFilmDao;

    }

    @Override
    public long insertItem(Film film) {
        film.setId(null);
        return mFilmDao.insert(film);
    }

    @Override
    public void insertItems(List<Film> films) {
        for (Film film:films) {
            insertItem(film);
        }
    }

    @Override
    public Film getItem(long id) {
        List<Film> films = mFilmDao.queryBuilder()
                .where(FilmDao.Properties.Id.eq(id))
                .list();
        if (films.isEmpty()) {
            return null;
        } else {
            return films.get(0);
        }
    }

    @Override
    public boolean deleteItem(long id) {
        mFilmDao.queryBuilder()
                .where(FilmDao.Properties.Id.eq(id))
                .buildDelete()
                .executeDeleteWithoutDetachingEntities();

        //todo как получить резултат удаления?
        return true;
    }

    @Override
    public List<Film> getAll() {
        return mFilmDao.queryBuilder().list();
    }

    @Override
    public void updateItem(Film film) {

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

    @Override
    public long createFilmAndSave(String name, String director, int year, double rating) {
        return 0;
    }

    @Override
    public void createFilmAndUpdate(long id, String name, String director, int year, double rating) {

    }
}
