package com.example.MovieApp.controller;


import com.example.MovieApp.repository.TimetableRepository;
import com.example.MovieApp.model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;


    @GetMapping("/timetable/{date}")
    public List<Timetable> getAll(@PathVariable String date){
        List<Timetable> timetables= timetableRepository.findAllByDate(date);
        return timetables;
    }

    @GetMapping("/timetable")
    public List<Timetable> getAllLabs() {
        List<Timetable> timetables= timetableRepository.findAll();
        return timetables;
    }

    @PostMapping("/timetable")
    public Timetable createStudent(@RequestBody Timetable timetable){
        Timetable timetable1 = timetableRepository.save(timetable);
        return timetable1;
    }




}
