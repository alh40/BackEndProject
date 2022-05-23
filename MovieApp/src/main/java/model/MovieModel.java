package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int time_length;
    private int rating;
    private String genre;
    private int price;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JsonIgnoreProperties(value = {"movies"})
    private Set<Venue> venues;



}
