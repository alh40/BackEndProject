package com.example.MovieApp.TimetableTest;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.model.Venue;
import com.example.MovieApp.repository.MovieRepository;
import com.example.MovieApp.repository.TimetableRepository;
import com.example.MovieApp.repository.VenueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TimetableRepositoryTest {

    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private VenueRepository venueRepository;

    @Autowired
    private MovieRepository movieRepository;



    //find all
    @Test
    void testAll(){
        List<Timetable> timetables= timetableRepository.findAll();
        assertEquals(100, timetables.size());
    }


    // find all by date
    @Test
    void testFindAllByDate(){
        String date1 = "Monday";
        List<Timetable> mondayTimetable = timetableRepository.findAllByDate(date1);
        assertEquals(date1,mondayTimetable.get(0).getDate());

    }


    //find timetable by venue name
    @Test
    void testFindTimetableByVenue(){

        String venueName = "ODEON";
        Venue venue1 = (Venue) venueRepository.searchVenue(venueName);
        List<Timetable> venueNameTimetable = timetableRepository.findTimetableByVenue(venue1);
        assertEquals(venueName, venueNameTimetable.get(0).getVenue().getName());

    }

    //find timetable by movie name
    @Test
    void testFindTimetableByMovie(){

        String movieName = "Maniac";
        Movie movie1 = movieRepository.findByTitle(movieName);
        List<Timetable> movieNameTimetable = timetableRepository.findTimetableByMovie(movie1);
        assertEquals(movieName, movieNameTimetable.get(0).getMovie().getTitle());
    }






}