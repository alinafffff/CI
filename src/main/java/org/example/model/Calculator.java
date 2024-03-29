package org.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class Calculator {
    private Double averageSalary;
    private LocalDate startDateOfVacation;
    private LocalDate endDateOfVacation;

    public Double getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(Double averageSalary) {
        this.averageSalary = averageSalary;
    }

    public LocalDate getStartDateOfVacation() {
        return startDateOfVacation;
    }

    public void setStartDateOfVacation(LocalDate startDateOfVacation) {
        this.startDateOfVacation = startDateOfVacation;
    }

    public LocalDate getEndDateOfVacation() {
        return endDateOfVacation;
    }

    public void setEndDateOfVacation(LocalDate endDateOfVacation) {
        this.endDateOfVacation = endDateOfVacation;
    }
}
