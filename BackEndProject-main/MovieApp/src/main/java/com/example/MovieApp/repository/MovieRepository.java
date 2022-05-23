package com.example.MovieApp.repository;

import com.example.MovieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Movie findByTitle(String title);

}