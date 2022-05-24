package com.example.MovieApp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "venue")
    private Set<Timetable> timetables;

    @JsonIgnoreProperties(value = {"venue"})
    public Venue() {
    }

    public Venue(Long id, String name, Set<Timetable> timetables) {
        this.id = id;
        this.name = name;
        this.timetables = timetables;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Timetable> getTimetables() {
        return timetables;
    }

    public void setTimetables(Set<Timetable> timetables) {
        this.timetables = timetables;
    }
}
