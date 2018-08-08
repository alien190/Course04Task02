package com.example.alien.course04task02.data;

import com.example.alien.course04task02.data.model.Film;

import java.util.List;

public interface IRepository {

    long insertItem(Film film);

    Film getItem(long id);

    boolean deleteItem(long id);

    List<Film> getAll();

    void updateItem(Film film);

    List<Film> search(String query);

    List<Film> searchInBounds(int startYear, int endYear);

    List<Film> searchByDirector(String name);

    List<Film> getTopFilms(int count);

    public long createFilmAndSave(String name, String director, int year, double rating);

}
