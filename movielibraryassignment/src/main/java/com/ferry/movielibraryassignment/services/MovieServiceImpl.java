package com.ferry.movielibraryassignment.services;

import com.ferry.movielibraryassignment.domain.Movie;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ferry on 23/08/18.
 */

@Service
public class MovieServiceImpl implements MovieService {

    @Override
    public Movie create(Movie movie) {

        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));

            JSONObject newMovie = new JSONObject();
            newMovie.put("title", movie.getTitle());
            newMovie.put("director", movie.getDirector());
            newMovie.put("releaseDate", movie.getReleaseDate());
            newMovie.put("type", movie.getType());

            jsonArray.add(newMovie);

            try (FileWriter file = new FileWriter(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath())) {

                System.out.println("Start to write in file");
                file.write(jsonArray.toJSONString());
                file.close();
                System.out.println("Successfully Copied JSON Object to File...");
                System.out.println("\nJSON Object: " + jsonArray);

            }catch (Exception ex){
                ex.printStackTrace();
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

        return movie;
    }

    @Override
    public Movie delete(int id) {
        return null;
    }

    @Override
    public List<Movie> findAll() {
        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));

            List<Movie> movieList = new ArrayList<>();
            for (Object o : jsonArray) {
                JSONObject movieJson = (JSONObject) o;
                Movie movie = new Movie();

                movie.setTitle((String) movieJson.get("title"));
                movie.setDirector((String) movieJson.get("director"));
                movie.setReleaseDate((String) movieJson.get("releaseDate"));
                movie.setType((String) movieJson.get("type"));

                movieList.add(movie);
            }
            return movieList;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public Movie findById(int id) {
        return null;
    }

    @Override
    public Movie update(Movie movie) {
        return null;
    }
}
