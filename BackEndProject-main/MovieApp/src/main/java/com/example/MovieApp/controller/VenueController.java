package com.example.MovieApp.controller;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Venue;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Venue> findVenueAlphabetically(){
        return venueRepository.findALL();
    }

    @GetMapping("/venue/{name}")
public ResponseEntity <List<Venue>>findVenue (@PathVariable String name){
List<Venue>VenueList = venueRepository.searchVenue(name);

return  ResponseEntity
        .ok()
        .body(VenueList);
    }
    /* @GetMapping("/venue/{name}")
   public ResponseEntity<List<Venue>> getAllVenue(@RequestParam(required = false, defaultValue = "false")
                                                           boolean orderByName) {
        List<Venue> venue;
        if (orderByName) {
            venue = venueRepository.findAll();
        } else {
            venue = venueRepository.findAll();
        }
        return ResponseEntity
                .ok()
                .body(venue);
    }*/

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
