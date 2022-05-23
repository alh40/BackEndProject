package com.example.MovieApp.repository;

import com.example.MovieApp.model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {


    Timetable findByDate(String date);



}
