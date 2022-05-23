package model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "venue")
public class Venue {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;


    @Column(
            name = "name",
            nullable = false

    )
    private String name;

    @OneToMany(mappedBy = "venue")
    private List<Timetable> timetableList;

    @ManyToMany(mappedBy = "venue")
    private List<Movie> movieList;

    public Venue() {
    }

    public Venue(String name, List<Timetable> timetableList, List<Movie> movieList) {
        this.name = name;
        this.timetableList = timetableList;
        this.movieList = movieList;
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

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
