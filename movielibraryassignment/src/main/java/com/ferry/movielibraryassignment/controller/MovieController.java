package com.ferry.movielibraryassignment.controller;

import com.ferry.movielibraryassignment.domain.Movie;
import com.ferry.movielibraryassignment.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferry on 23/08/18.
 */
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/allMovies",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.findAll(), HttpStatus.OK);
    }

    @PostMapping(path = "/addMovie",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.create(movie), HttpStatus.OK);
    }



}
