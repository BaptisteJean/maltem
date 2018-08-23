package com.ferry.movielibraryassignment.services;

import com.ferry.movielibraryassignment.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ferry on 23/08/18.
 */
@Service
public interface MovieService {

    Movie createMovie(Movie movie);

    Movie deleteMovie(int movieId);

    List<Movie> findAllMovies();

    Movie findMovieById(int movieId);

    Movie updateMovie(int movieId, Movie movie);
}
