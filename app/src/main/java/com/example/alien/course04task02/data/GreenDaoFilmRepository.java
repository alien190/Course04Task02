package com.example.alien.course04task02.data;

import com.example.alien.course04task02.data.IFilmRepository;
import com.example.alien.course04task02.data.model.Film;

import java.util.List;

public class GreenDaoFilmRepository implements IFilmRepository {
    @Override
    public long insertItem(Film film) {
        return 0;
    }

    @Override
    public void insertItems(List<Film> films) {

    }

    @Override
    public Film getItem(long id) {
        return null;
    }

    @Override
    public boolean deleteItem(long id) {
        return false;
    }

    @Override
    public List<Film> getAll() {
        return null;
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
