package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {


    List<Timetable> findAllByDate(String date);
    //value = "SELECT timetable.date, timetable. time, venue.name, movie.name " +
    //            "FROM Timetable join Venue On Venue.id = Timetable.venue_id " +
    //            "JOIN movie ON movie.id = Timetable.movie_id" +
    //            "WHERE Timetable.venue_id = ?1
    //@Query(value = "SELECT TIMETABLE.DATE, TIMETABLE.TIME, MOVIE.TITLE FROM TIMETABLE INNER JOIN VENUE ON VENUE.ID = TIMETABLE.VENUE_ID INNER JOIN MOVIE ON MOVIE.ID = TIMETABLE.MOVIE_ID WHERE VENUE.NAME = ‘ODEON’",
            //nativeQuery = true)
    List<Timetable> findTimetableByVenue(Venue venue);


    //@Query(value = "SELECT * FROM TIMETABLE INNTER JOIN MOVIE ON movie.id = timetable.movie_id")
    List<Timetable> findTimetableByMovie(Movie movie);



}
