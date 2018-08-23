package com.ferry.movielibraryassignment.services;

import com.ferry.movielibraryassignment.domain.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ferry on 23/08/18.
 */
@Service
public interface MovieService {

    Movie create(Movie movie);

    Movie delete(int id);

    List<Movie> findAll();

    Movie findById(int id);

    Movie update(Movie movie);
}
