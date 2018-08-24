package com.ferry.movielibraryassignment.controller;

import com.ferry.movielibraryassignment.domain.Movie;
import com.ferry.movielibraryassignment.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ferry on 23/08/18.
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping(path = "/addMovie",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.createMovie(movie), HttpStatus.OK);
    }

    @DeleteMapping(path = "/deleteMovie/{movieId}",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Movie> deleteMovie(@PathVariable int movieId){
        return new ResponseEntity<Movie>(movieService.deleteMovie(movieId), HttpStatus.OK);
    }

    @GetMapping(path = "/allMovies",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping(path = "/findMovieById/{movieId}",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Movie> findMovieById(@PathVariable int movieId){
        return new ResponseEntity<Movie>(movieService.findMovieById(movieId), HttpStatus.OK);
    }

    @PutMapping(path = "/updateMovie/{movieId}",
            produces={MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity<Movie> updateMovie(@PathVariable int movieId, @RequestBody Movie movie){
        return new ResponseEntity<Movie>(movieService.updateMovie(movieId, movie), HttpStatus.OK);
    }

}
