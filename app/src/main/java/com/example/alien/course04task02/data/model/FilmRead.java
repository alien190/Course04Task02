package com.example.alien.course04task02.data.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class FilmRead  {

    private long id;
    private String name;
    private int year;
    private String director;
    private double rating;

    public FilmRead(long id, String name, int year, String director, double rating) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
