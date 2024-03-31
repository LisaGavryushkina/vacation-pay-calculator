package ru.neostudy.vacationpaycalculator.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VacationInfoDto {
    @Positive(message = "Average salary must be greater than 0")
    @NotNull(message = "Average salary is required")
    private BigDecimal averageSalary;
    @Positive(message = "Amount of days must be greater than 0")
    @Max(value = 80, message = "According to the Labor Code of the Russian Federation, vacation cannot be longer than" +
            " 80 days")
    private int daysAmount;
    private LocalDate startDate;
}
