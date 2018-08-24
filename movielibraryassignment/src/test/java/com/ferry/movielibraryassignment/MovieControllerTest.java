package com.ferry.movielibraryassignment;

import com.ferry.movielibraryassignment.controller.MovieController;
import com.ferry.movielibraryassignment.domain.Movie;
import com.ferry.movielibraryassignment.services.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by ferry on 24/08/18.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class, secure = false)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    Movie mockMovie = new Movie("Oceans 8", "Gary Ross", "13/06/2018", "action");

    String exampleMovieJson = "{\"title\":\"Oceans 8\",\"director\":\"Gary Ross\",\"releaseDate\":\"13/06/2018\",\"type\":\"action\"}";

    @Test
    public void deleteMoviebyId() throws Exception {

        Mockito.when(
                movieService.deleteMovie(Mockito.anyInt())).thenReturn(mockMovie);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                "/api/deleteMovie/0").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{title:Oceans 8,director:Gary Ross,releaseDate:13/06/2018,type:action}";

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}
