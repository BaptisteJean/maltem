package com.ferry.movielibraryassignment.domain;

/**
 * Created by ferry on 23/08/18.
 */
public class Movie {

    private String title;
    private String director;
    private String releaseDate;
    private String type;

    public Movie() {
    }

    public Movie(String title, String director, String releaseDate, String type) {
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
