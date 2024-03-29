package org.example.service;

import java.time.LocalDate;

public interface CalculableService {
    public String getSalary(Double averageSalary, LocalDate startDateOfVacation, LocalDate endDateOfVacation);
}
