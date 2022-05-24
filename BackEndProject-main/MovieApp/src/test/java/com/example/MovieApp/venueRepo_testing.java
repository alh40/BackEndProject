package com.example.MovieApp;

import com.example.MovieApp.model.Venue;
import com.example.MovieApp.repository.VenueRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
public class venueRepo_testing {
    @Autowired
    VenueRepository venueRepository;

    @Test
    void findVenue() {

        List<Venue> venueList = venueRepository.findAll();

        assertEquals(5, venueList.size());
    }



}
