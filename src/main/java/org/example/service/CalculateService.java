package org.example.service;

import org.springframework.stereotype.Service;
import org.example.model.Calculator;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

@Service
public class CalculateService implements CalculableService{
    public static final double AVERAGE_NUMBER_DAY_PER_MONTH = 29.3;
    private final Calculator calculator = new Calculator();

    public String getSalary(Double averageSalary, LocalDate startDateOfVacation, LocalDate endDateOfVacation){
        String res = "Введите корректные значения";

        if(validStartDate(startDateOfVacation) && validEndDate(startDateOfVacation, endDateOfVacation) && validSalary(averageSalary)){
            calculator.setAverageSalary(averageSalary);
            calculator.setStartDateOfVacation(startDateOfVacation);
            calculator.setEndDateOfVacation(endDateOfVacation);

            res = new DecimalFormat("#0.00").format(
                    calculator.getAverageSalary()/ AVERAGE_NUMBER_DAY_PER_MONTH * getVacationDays()
            );
        }

        return res;
    }

    private int getVacationDays(){
        int countVacationDays = 0;

        for(LocalDate i = calculator.getStartDateOfVacation(); !i.isAfter(calculator.getEndDateOfVacation()); i = i.plusDays(1)){
            if(!isHoliday(i)) countVacationDays ++;
        }

        return countVacationDays;
    }

    private boolean validStartDate(LocalDate startDateOfVacation){
        return startDateOfVacation != null;
    }

    private boolean validEndDate(LocalDate startDateOfVacation, LocalDate endDateOfVacation){
        return endDateOfVacation != null &&
                endDateOfVacation.isAfter(startDateOfVacation);
    }

    private boolean validSalary(Double averageSalary){
        return averageSalary != null &&
                averageSalary > 0;
    }

    private boolean isHoliday(LocalDate date){
        return isWeekend(date) || Holiday.holidays.contains(parseToMonthDay(date));
    }

    private boolean isWeekend(LocalDate date){
        final DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY;
    }

    private MonthDay parseToMonthDay(LocalDate date){
        return MonthDay.of(date.getMonth(), date.getDayOfMonth());
    }

    private static class Holiday {
        public final static Set<MonthDay> holidays = new HashSet<>();

        static {
            holidays.add(MonthDay.of(Month.JANUARY, 1));
            holidays.add(MonthDay.of(Month.JANUARY, 2));
            holidays.add(MonthDay.of(Month.JANUARY, 3));
            holidays.add(MonthDay.of(Month.JANUARY, 4));
            holidays.add(MonthDay.of(Month.JANUARY, 5));
            holidays.add(MonthDay.of(Month.JANUARY, 6));
            holidays.add(MonthDay.of(Month.JANUARY, 7));
            holidays.add(MonthDay.of(Month.JANUARY, 8));
            holidays.add(MonthDay.of(Month.FEBRUARY, 23));
            holidays.add(MonthDay.of(Month.MARCH, 8));
            holidays.add(MonthDay.of(Month.MAY, 8));
            holidays.add(MonthDay.of(Month.MAY, 8));
            holidays.add(MonthDay.of(Month.JUNE, 12));
            holidays.add(MonthDay.of(Month.NOVEMBER, 4));
        }
    }
}
