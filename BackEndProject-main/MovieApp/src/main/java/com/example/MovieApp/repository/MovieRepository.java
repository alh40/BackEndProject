package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

    @Query(value = "SELECT * FROM STUDENT WHERE FIRST_NAME LIKE %:title%", nativeQuery = true)
    List<Movie> findByFirstNameLike(@Param("title") String title);

//    @Query(value = "SELECT * FROM MOVIE WHERE RATING = rating", nativeQuery = true)
//    Movie getMovieByRating(@Param("rating") Integer rating);
}
