package ru.neostudy.vacationpaycalculator.dto;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class VacationInfoDto {
    @Positive
    private double averageSalary;
    @Positive
    @Max(value = 80, message = "According to the Labor Code of the Russian Federation, vacation cannot be longer than" +
            " 80 days")
    private int daysAmount;
    private LocalDate startDate;
}
