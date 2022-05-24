package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query(value = "SELECT * FROM car_brand ORDER BY car_brand.car_brand",nativeQuery = true)
    List<Movie> findMoviesByVenue();

    Movie findByTitle(String title);

}
