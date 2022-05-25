package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.VenueRepository;

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


    @GetMapping("/venue")
    public ResponseEntity<List<Venue>> getAll() {
        List<Venue> all = venueRepository.findAll();
        return ResponseEntity
                .ok()
                .body(all);
    }

    @DeleteMapping("/venue/{id}")
    public void deleteVenue(@PathVariable Long id) {
        venueRepository.deleteById(id);
    }

}