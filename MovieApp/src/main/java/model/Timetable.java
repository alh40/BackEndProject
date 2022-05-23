package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private int time;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


    public Timetable() {
    }

    public Timetable(Long id, String date, int time) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.movie = new Movie();
        this.venue = new Venue();
    }

    enum days{
        Monday, tuesday, Wednesday, Thursday, Friday, Saturday, Sunday
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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
}