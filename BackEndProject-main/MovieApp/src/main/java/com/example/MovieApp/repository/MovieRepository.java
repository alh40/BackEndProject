package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

    @Query(value = "SELECT * FROM MOVIE WHERE LOWER(TITLE) LIKE %:searchName%", nativeQuery = true)
    List<Movie> findByTitleLike(@Param("searchName") String title);

    @Query(value = "SELECT * FROM MOVIE WHERE RATING = ?1", nativeQuery = true)
    List<Movie> getMovieByRating(@Param("rating") int rating);


    @Query(value = "SELECT * FROM MOVIE WHERE GENRE = 'Drama'", nativeQuery = true)
    List<Movie> dramaMovie();

}
