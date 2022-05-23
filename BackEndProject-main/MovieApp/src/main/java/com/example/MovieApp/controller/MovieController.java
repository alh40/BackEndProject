package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.MovieRepository;

import java.util.List;
import java.util.Optional;


@RestController
public class MovieController {

    @Autowired

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies/{title}")
    public ResponseEntity<Movie> getByTitle(@PathVariable String title){
        Movie movie1 = movieRepository.findByTitle(title);
        return ResponseEntity
                .ok()
                .body(movie1);
    }
    @GetMapping("/movies/{id}")
        public Optional<Movie> getMovieById(@PathVariable Long id){
            return movieRepository.findById(id);
        }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = movieRepository.save(movie);
        return ResponseEntity
                .ok()
                .body(createdMovie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
    }


}
