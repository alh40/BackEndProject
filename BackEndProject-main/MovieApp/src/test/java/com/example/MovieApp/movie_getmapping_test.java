package com.example.MovieApp;

import com.example.MovieApp.controller.MovieController;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
public class movie_getmapping_test {

    @Autowired
    MovieController movieController;
    @Autowired
    MovieRepository movieRepository;

    @Test
    public void getAllMovieTest() {
        // given
        List<Movie> movieCount = (List<Movie>) movieController.getAll();
        // when

        // then
//        assertThat(movieCount.size()).isEqualto(20);
}
