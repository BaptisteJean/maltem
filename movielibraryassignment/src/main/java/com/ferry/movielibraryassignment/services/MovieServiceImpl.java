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
    public Movie createMovie(Movie movie) {

        JSONParser parser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));

            JSONObject newMovie = new JSONObject();
            newMovie.put("title", movie.getTitle());
            newMovie.put("director", movie.getDirector());
            newMovie.put("releaseDate", movie.getReleaseDate());
            newMovie.put("type", movie.getType());

            jsonArray.add(newMovie);

            System.out.println("Start to write in file");
            FileWriter file = new FileWriter(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath());
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully Copied JSON Object to File...");

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return movie;
    }

    @Override
    public Movie deleteMovie(int movieId) {

        JSONParser parser = new JSONParser();
        Movie movieDeleted = new Movie();
        try{

            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));
            JSONObject jsonObject = (JSONObject)jsonArray.get(movieId);
            jsonArray.remove(movieId);

            System.out.println("Start to Remove in file");
            FileWriter file = new FileWriter(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath());
            file.write(jsonArray.toJSONString());
            file.flush();
            file.close();
            System.out.println("Successfully Removed JSON Object to File...");

            if (jsonObject != null){
                movieDeleted.setTitle((String) jsonObject.get("title"));
                movieDeleted.setDirector((String) jsonObject.get("director"));
                movieDeleted.setReleaseDate((String) jsonObject.get("releaseDate"));
                movieDeleted.setType((String) jsonObject.get("type"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return movieDeleted;
    }

    @Override
    public List<Movie> findAllMovies() {
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
    public Movie findMovieById(int movieId) {

        JSONParser parser = new JSONParser();
        Movie movie = new Movie();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));
            JSONObject jsonObject = (JSONObject)jsonArray.get(movieId);

            if (jsonObject != null){
                movie.setTitle((String) jsonObject.get("title"));
                movie.setDirector((String) jsonObject.get("director"));
                movie.setReleaseDate((String) jsonObject.get("releaseDate"));
                movie.setType((String) jsonObject.get("type"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return movie;
    }

    @Override
    public Movie updateMovie(int movieId, Movie movie) {

        JSONParser parser = new JSONParser();
        try{

            if (movie != null){
                JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath()));
                JSONObject jsonObject = (JSONObject)jsonArray.get(movieId);

                jsonObject.replace("title", movie.getTitle());
                jsonObject.replace("director", movie.getDirector());
                jsonObject.replace("releaseDate", movie.getReleaseDate());
                jsonObject.replace("type", movie.getType());

                System.out.println("Start to update in file");
                FileWriter file = new FileWriter(ResourceUtils.getFile("classpath:dataSource/movies.json").getAbsolutePath());
                file.write(jsonArray.toJSONString());
                file.flush();
                file.close();
                System.out.println("Successfully Updated JSON Object to File...");
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return movie;
    }
}
