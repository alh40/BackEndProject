package com.example.MovieApp.controller;

import com.example.MovieApp.BookingMovie;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.MovieRepository;

import java.io.*;
import java.util.*;

import static com.example.MovieApp.BookingMovie.readFile;


@RestController
public class MovieController {

    @Autowired

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }




    @GetMapping(value = "/booking/{title}/{date}/{time}/{user}", produces = {"application/json"})
    public void bookMovie (@PathVariable String title, @PathVariable String time, @PathVariable String date, @PathVariable String user) throws IOException {
        ArrayList<Integer> uniqueId = BookingMovie.uniqueIdUser;
        Movie movie1 = movieRepository.findByTitle(title);
        Set<Timetable> set = movie1.getTimetables();
        BookingMovie.timetable.addAll(set);

        for(int i = 0; i < BookingMovie.timetable.size(); i++){
            if(BookingMovie.timetable.get(i).getTime().equals(time) && BookingMovie.timetable.get(i).getDate().equals(date)){
                BookingMovie.newBooking.add(BookingMovie.timetable.get(i));
                BookingMovie.newList.add("User: " + user + " UniqueID: " + uniqueId.get(0) + ", " + "\n" + movie1.toString() + " " + "\n" + BookingMovie.timetable.get(i).toString() + " " + "\n" + BookingMovie.timetable.get(i).getVenue());
                uniqueId.remove(0);
                BookingMovie.newBooking.remove(0);
                BookingMovie.writeFile();;
                readFile();
            }
        }


    }

    @DeleteMapping("/booking/{id}")
    public void deleteMovieBookingByUniqueId(@PathVariable Long id) throws IOException {
        String integerToString = String.valueOf(id);

        for(int i = 0; i < BookingMovie.newList.size(); i++){
            if(BookingMovie.newList.get(i).contains(integerToString)){
                BookingMovie.newList.remove(i);
                File deleteFile = new File("/Users/Alex/Documents/MovieBookings.txt");
                deleteFile.delete();
                BookingMovie.writeToFile();
                readFile();
            }
        }

    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAll(){
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovieById(@PathVariable Long id){
        return movieRepository.findById(id);
    }


    @GetMapping("/movies/{title}")
    public ResponseEntity<Movie> getByTitle(@PathVariable String title){
        Movie movie1 = movieRepository.findByTitle(title);
        return ResponseEntity
                .ok()
                .body(movie1);
    }

    @GetMapping("/fuzzysearch/{searchName}")
    public ResponseEntity<List<Movie>> searchName(
            @PathVariable String searchName){
        if(searchName != null){
            return new ResponseEntity<List<Movie>>(
                    movieRepository.findByTitleLike(searchName),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(movieRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/movies/rating/{rating}")
    public ResponseEntity<List<Movie>> getMovieByRating(@PathVariable("rating")int rating){
        List<Movie> movieWithRating = movieRepository.getMovieByRating(rating);
        return ResponseEntity.ok().body(movieWithRating);
    }

    @GetMapping("/movies/genre/{genre}")
    public ResponseEntity<List<Movie>> getDramaMovie(@PathVariable("genre") String genre){
        List<Movie> movieWithRating = movieRepository.dramaMovie(genre);
        return ResponseEntity.ok().body(movieWithRating);
    }

    @PostMapping(value = "/movies", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie){
        Movie createdMovie = movieRepository.save(movie);
        return ResponseEntity
                .ok()
                .body(createdMovie);
    }

    @PutMapping(value = "/update/movies/{id}", produces = {"application/json"})
    public Movie updateMovie(@RequestBody Movie movies, @PathVariable Long id){
        return movieRepository.save(movies);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieRepository.deleteById(id);
    }



}
