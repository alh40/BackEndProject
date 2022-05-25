package com.example.MovieApp.controller;


import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Venue;
import com.example.MovieApp.repository.MovieRepository;
import com.example.MovieApp.repository.TimetableRepository;
import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.Soundbank;
import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private MovieRepository movieRepository;

    public TimetableController(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }


    //get all
    @GetMapping("/timetable")
    public ResponseEntity<List<Timetable>> getAll() {
        List<Timetable> timetables= timetableRepository.findAll();
        return ResponseEntity
                .ok()
                .body(timetables);
    }

    //get all by date
    @GetMapping("/timetable/{date}")
    public ResponseEntity<List<Timetable>> getAllByDate(@PathVariable String date){
        List<Timetable> timetables= timetableRepository.findAllByDate(date);
        return ResponseEntity
                .ok()
                .body(timetables);
    }


    @GetMapping("/timetable/venue/{venue_name}")
    public ResponseEntity<List<Timetable>> getTimetableByVenueName(@PathVariable("venue_name") String venue_name){
        //Venue venue1 = venueRepository.findByName(venueName);
        List<Timetable> timetables= timetableRepository.findTimetableByVenue(venue_name);
        return ResponseEntity
                .ok()
                .body(timetables);

    }

    //get all by movie
    @GetMapping("/timetable/movie/{movie_name}")
    public ResponseEntity<List<Timetable>> getTimetableByMovieName(@PathVariable("movie_name") String movie_name){
        //Movie movie1 = movieRepository.findByTitle(movieName);
        List<Timetable> timetables= timetableRepository.findTimetableByMovie(movie_name);
        return ResponseEntity
                .ok()
                .body(timetables);
    }

    @PostMapping("/timetable")
    public ResponseEntity<Timetable> createTimetable(@RequestBody Timetable timetable){
        Timetable timetable1 = timetableRepository.save(timetable);
        return ResponseEntity
                .ok()
                .body(timetable1);
    }

    @DeleteMapping("/timetable/{id}")
    public void deleteTimetable(@PathVariable Long id){
        timetableRepository.deleteById(id);

    }





}