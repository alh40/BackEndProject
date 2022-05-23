package model;

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
            joinColumns = { @JoinColumn(name = "movie_id") },
            inverseJoinColumns = { @JoinColumn(name = "venue_id") }
    )
    @JsonIgnoreProperties(value = {"movies"})
    private Set<Venue> venues;

    public Movie() {
    }


}
