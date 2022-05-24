package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {


    List<Timetable> findAllByDate(String date);


    @Query(value = "SELECT * FROM timetable JOIN VENUE ON venue.id = timetable.venue_id JOIN movie ON movie.id = timetable.movie_id WHERE venue.name = ?1",nativeQuery = true )
    List<Timetable> findTimetableByVenue(@Param("venue_name") String venue_name);


    @Query(value = "SELECT * FROM timetable JOIN MOVIE ON movie.id = timetable.movie_id WHERE movie.title = ?1",nativeQuery = true)
    List<Timetable> findTimetableByMovie(@Param("movie_name") String movie_name);



}
