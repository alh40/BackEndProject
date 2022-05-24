package com.example.MovieApp.controller;

import com.example.MovieApp.BookingMovie;
import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import org.hibernate.persister.entity.SingleTableEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.MovieRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.*;


@RestController
public class MovieController {

    @Autowired

    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public static void writeToFile() {
        try {
            BookingMovie.writeFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Integer> setUniqueId() {
        LinkedHashSet<Integer> uniqueIdSet = new LinkedHashSet<>();
        Random uniqueId = new Random();

        while (uniqueIdSet.size() < 1000) {
            uniqueIdSet.add(uniqueId.nextInt(1000 - 0 + 1));
        }
        ArrayList<Integer> uniqueIdList = new ArrayList<>();
        uniqueIdList.addAll(uniqueIdSet);
        return uniqueIdList;
    }

    public static ArrayList<Integer> uniqueId() {
        ArrayList<Integer> userIdList = setUniqueId();
        return userIdList;
    }

    public static ArrayList<Integer> uniqueIdUser = uniqueId();
    public static List<Timetable> timetable = new ArrayList<>();
    public static List<Movie> movieBooking = new ArrayList<>();
    public static ArrayList<Timetable> newBooking = new ArrayList<>();
    public static List<String> newList = new ArrayList<>();


    @GetMapping(value = "/booking/{title}/{date}/{time}/{user}", produces = {"application/json"})
    public void bookMovie (@PathVariable String title, @PathVariable String time, @PathVariable String date, @PathVariable String user) throws IOException {
        ArrayList<Integer> uniqueId = uniqueIdUser;
        Movie movie1 = movieRepository.findByTitle(title);
        Set<Timetable> set = movie1.getTimetables();
        timetable.addAll(set);


        for(int i = 0; i < timetable.size(); i++){
            if(timetable.get(i).getTime().equals(time) && timetable.get(i).getDate().equals(date)){
                newBooking.add(timetable.get(i));
                newList.add("User: " + user + " UniqueID: " + uniqueId.get(0) + ": " + movie1.toString() + " " + timetable.get(i).toString());
            }
        }
        uniqueId.remove(0);
        newBooking.remove(0);
        writeToFile();

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

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Movie>> getMovieByRating(@PathVariable Long rating){
        List<Movie> movieWithRating = movieRepository.getMovieByRating(rating);
        return ResponseEntity.ok().body(movieWithRating);
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
