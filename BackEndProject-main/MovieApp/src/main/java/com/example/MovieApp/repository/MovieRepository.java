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


    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE 'Drama'", nativeQuery = true)
    List<Movie> dramaMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE '%Documentary%'", nativeQuery = true)
    List<Movie> documentaryMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE '%Adventure%'", nativeQuery = true)
    List<Movie> adventureMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE '%Action%'", nativeQuery = true)
    List<Movie> actionMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE '%Comedy%'", nativeQuery = true)
    List<Movie> comedyMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE LIKE '%Western%'", nativeQuery = true)
    List<Movie> westernMovie();

    @Query(value = "SELECT * FROM MOVIE WHERE GENRE = 'Crime'", nativeQuery = true)
    List<Movie> crimeMovie();

}
