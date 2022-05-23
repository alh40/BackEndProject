package com.example.MovieApp.repository;

import com.example.MovieApp.model.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue, Long> {
  Venue findByName (String name);


}
