package com.example.MovieApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {


    Timetable findByDate(String date);



}
