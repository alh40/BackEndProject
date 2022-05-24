package com.example.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int time_length;
    private int rating;
    private String genre;
    private int price;
    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private Set<Timetable> timetables;


    public Movie() {
    }

    public Movie(Long id, String title, int time_length, int rating, String genre, int price, Set<Timetable> timetables) {
        this.id = id;
        this.title = title;
        this.time_length = time_length;
        this.rating = rating;
        this.genre = genre;
        this.price = price;
        this.timetables = timetables;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTime_length() {
        return time_length;
    }

    public void setTime_length(int time_length) {
        this.time_length = time_length;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }
}
