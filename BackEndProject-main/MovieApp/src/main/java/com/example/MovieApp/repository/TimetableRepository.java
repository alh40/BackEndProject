package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {


    List<Timetable> findAllByDate(String date);

    List<Timetable> findTimetableByVenue(Venue venue);

    List<Timetable> findTimetableByMovie(Movie movie);



}
