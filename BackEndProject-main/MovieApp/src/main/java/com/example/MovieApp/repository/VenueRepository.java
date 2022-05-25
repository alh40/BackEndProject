package com.example.MovieApp.repository;

import com.example.MovieApp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Long> {
  @Query(value = "SELECT * FROM VENUE ORDER BY NAME ", nativeQuery = true)
  List<Venue> findALL();

  @Query(value = "SELECT * FROM VENUE WHERE LOWER(NAME) LIKE %:Name%", nativeQuery = true)
  List<Venue> findByName(@Param("Name")String name);

  @Query(value = "SELECT * FROM VENUE WHERE NAME = ?1", nativeQuery = true)
  List<Venue> searchVenue(@Param("Venue") String name);
}