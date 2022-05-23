package com.example.MovieApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
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
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "movie",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "venue_id")}
    )
    @JsonIgnoreProperties(value = {"movies"})
    private Set<Venue> venues;

    public Movie() {
    }

    public Movie(Long id, String title, int time_length, int rating, String genre, int price, Set<Venue> venues) {
        this.id = id;
        this.title = title;
        this.time_length = time_length;
        this.rating = rating;
        this.genre = genre;
        this.price = price;
        this.venues = venues;
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

    public Set<Venue> getVenues() {
        return venues;
    }

    public void setVenues(Set<Venue> venues) {
        this.venues = venues;
    }
}
