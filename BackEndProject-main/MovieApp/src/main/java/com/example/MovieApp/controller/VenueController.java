package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.VenueRepository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@RestController
public class VenueController {


    @Autowired
    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }


    @GetMapping("/venue/name")
    public List<Venue> findVenueAlphabetically() {
        return venueRepository.findALL();
    }

    @GetMapping("/venue/{name}")
    public ResponseEntity<List<Venue>> findVenue(@PathVariable String name) {
        List<Venue> VenueList = venueRepository.searchVenue(name);

        return ResponseEntity
                .ok()
                .body(VenueList);
    }

//    Gets the venue name based on ID from database
    @GetMapping("/venue{id}")
    public ResponseEntity<List<Venue>> getAll() {
        List<Venue> all = venueRepository.findAll();
        return ResponseEntity
                .ok()
                .body(all);
    }

//    gets Venue based on the Venue NAME from database
    @GetMapping("/search/venue/{Name}")
    public ResponseEntity<List<Venue>> Name(
            @PathVariable String Name) {
        if (Name != null) {
            return new ResponseEntity<List<Venue>>(
                    venueRepository.findByName(Name),
                    HttpStatus.OK);
        }
        return new ResponseEntity<>(venueRepository.findAll(), HttpStatus.OK);
    }

//    POST request that allows the creation of new venues.
    @PostMapping("/venue")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue venue){
        Venue venue1 = venueRepository.save(venue);
        return ResponseEntity
                .ok()
                .body(venue1);
    }

//    UPDATE request that updates venue based on ID from database
    @PutMapping ("/venue/{id}")
    public Venue updateVenue(@RequestBody Venue venue, @PathVariable Long id){
        return venueRepository.save(venue);


    }

}