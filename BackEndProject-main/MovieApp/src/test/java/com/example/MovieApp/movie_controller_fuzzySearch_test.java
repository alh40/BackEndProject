package com.example.MovieApp;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.repository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class movie_controller_fuzzySearch_test {
    @Autowired
    MovieRepository movieRepository;


    @Test
    public void canFindName(){
        List<Movie> found = movieRepository.findByTitleLike("of");
        assertThat(found.size()).isEqualTo(8);
    }

    @Test
    public void canGetRating(){
        List<Movie> found = movieRepository.getMovieByRating(1);
        assertThat(found.size()).isEqualTo(3);
    }
}
