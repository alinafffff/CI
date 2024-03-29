package org.example.controller;

import org.example.service.CalculableService;
import org.example.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@CrossOrigin
@RequestMapping
public class CalculateController{
    @Autowired
    private CalculableService calculateService;

    @GetMapping(value = "/calculacte/{averageSalary}/{startDateOfVacation}/{endDateOfVacation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String salary(@PathVariable Double averageSalary, @PathVariable String startDateOfVacation, @PathVariable String endDateOfVacation){
        return calculateService.getSalary(averageSalary, parseToDate(startDateOfVacation), parseToDate(endDateOfVacation));
    }

    @GetMapping(value = "/api/hello", produces = MediaType.APPLICATION_JSON_VALUE)
    public String get(){
        return "300";
    }

    private LocalDate parseToDate(String date){
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
