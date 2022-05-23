package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.TimetableRepository;

@RestController
public class TimetableController {

    @Autowired
    private TimetableRepository timetableRepository;

    @GetMapping
    public



}
