package org.example;

import org.example.model.Calculator;
import org.example.service.CalculateService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CalculateServiceTest{
    private CalculateService calculateService;
    @Mock
    Calculator calculator;

    @BeforeEach
    void setUp(){
        calculateService = new CalculateService();
        Mockito.when(calculator.getAverageSalary()).thenReturn(20000D);
        Mockito.when(calculator.getStartDateOfVacation()).thenReturn(LocalDate.of(2024, 1, 1));
        Mockito.when(calculator.getEndDateOfVacation()).thenReturn(LocalDate.of(2024, 1, 20));
    }

    @Test
    public void getSalary(){
        String res = calculateService.getSalary(calculator.getAverageSalary(), calculator.getStartDateOfVacation(), calculator.getEndDateOfVacation());

        Assertions.assertNotNull(res);
        Assertions.assertEquals("6143,34", res);
    }
}
