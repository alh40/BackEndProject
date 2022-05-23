package com.example.MovieApp.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
class TimetableKey implements Serializable  {
    @Column(name = "venue_id")
    Long venueId;

    @Column(name = "movie_id")
    Long movieId;

    public TimetableKey(Long venueid, Long movieid) {
        this.venueId = venueid;
        this.movieId = movieid;
    }

    public TimetableKey() {

    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }


}



@Entity
public class Timetable {

    @EmbeddedId
    TimetableKey id;

    @ManyToOne
    @MapsId("venueId")
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne
    @MapsId("movieId")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private String date;
    private String time;

    public Timetable() {
    }

    public Timetable(TimetableKey id, Venue venue, Movie movie, String date, String time) {
        this.id = id;
        this.venue = venue;
        this.movie = movie;
        this.date = date;
        this.time = time;
    }

    public TimetableKey getId() {
        return id;
    }

    public void setId(TimetableKey id) {
        this.id = id;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}