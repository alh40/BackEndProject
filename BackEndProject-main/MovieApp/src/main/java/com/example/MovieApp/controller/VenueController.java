package com.example.MovieApp.controller;

import com.example.MovieApp.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.MovieApp.repository.VenueRepository;

@RestController
public class VenueController {


    @Autowired

    private final VenueRepository venueRepository;

    public VenueController(VenueRepository venueRepository) {
        this.venueRepository = venueRepository;
    }

    @GetMapping("/venue/{name}")
    public ResponseEntity<Venue> getName(@PathVariable String name) {
        Venue venue = venueRepository.findByName(name);
        return ResponseEntity
                .ok()
                .body(venue);
    }

    @GetMapping("/venue/{id}")
        public void deleteVenue(@PathVariable Long id){
        venueRepository.deleteById(id);
    }


}
