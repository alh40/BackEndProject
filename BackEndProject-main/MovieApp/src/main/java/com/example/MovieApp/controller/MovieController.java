package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.MovieRepository;

import java.util.List;


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

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAll() {
        List<Movie> students= movieRepository.findAll();
        return ResponseEntity
                .ok()
                .body(students);
    }

    @GetMapping("/movies/searchName")
    public ResponseEntity<List<Movie>> searchName(
            @RequestParam String input){
        if(input != null){
            return new ResponseEntity<List<Movie>>(
                    movieRepository.findByFirstNameLike(input),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }


//    @GetMapping("/rating/{rating}")
//    public ResponseEntity<List<Movie>> getMovieByRating(@PathVariable Integer rating){
//        return new ResponseEntity<List<Movie>>((List<Movie>) movieRepository.getMovieByRating(rating),HttpStatus.OK);
//    }



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
