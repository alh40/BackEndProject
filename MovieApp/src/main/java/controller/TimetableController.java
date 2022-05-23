package controller;


import model.Movie;
import model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.TimetableRepository;

import java.sql.Time;
import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    @GetMapping("/timetable/{movie_name}")
    public ResponseEntity<Timetable> getByTitle(@PathVariable String movie_name){
        Timetable = timetableRepository.f(movie_name);
        return ResponseEntity
                .ok()
                .body(movie);
    }

    @PostMapping("/timetable")
    public ResponseEntity<Timetable> createStudent(@RequestBody Timetable timetable){
        Timetable timetable1 = timetableRepository.save(timetable);
        return ResponseEntity
                .ok()
                .body(timetable1);
    }




}
