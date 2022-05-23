package controller;


import model.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.TimetableRepository;

import java.util.List;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    @GetMapping("/timetable")
    public List<Timetable> findAllTimetable(){
        return timetableRepository.findAll();
    }

    @PostMapping




}
