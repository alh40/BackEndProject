package com.example.MovieApp.controller;


import com.example.MovieApp.model.Timetable;
import com.example.MovieApp.repository.TimetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    public TimetableController(TimetableRepository timetableRepository) {
        this.timetableRepository = timetableRepository;
    }

    @GetMapping("/timetable/{dates}")
    public ResponseEntity<Timetable> getAll(@PathVariable String dates ){
        Timetable timetables= timetableRepository.findByDate(dates);
        return ResponseEntity
                .ok()
                .body(timetables);
    }

    @PostMapping("/timetable")
    public ResponseEntity<Timetable> createStudent(@RequestBody Timetable timetable){
        Timetable timetable1 = timetableRepository.save(timetable);
        return ResponseEntity
                .ok()
                .body(timetable1);
    }




}
