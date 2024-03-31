package ru.neostudy.vacationpaycalculator.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import ru.neostudy.vacationpaycalculator.validation.DaysAmountValid;
import ru.neostudy.vacationpaycalculator.validation.HasDatesInfo;
import ru.neostudy.vacationpaycalculator.validation.StartBeforeEndDateValid;

@Data
@StartBeforeEndDateValid
@DaysAmountValid
public class VacationInfoDto implements HasDatesInfo {
    @Positive
    private double averageSalary;
    @Positive
    @Max(value = 80, message = "According to the Labor Code of the Russian Federation, vacation cannot be longer than" +
            " 80 days")
    private int daysAmount;
    @FutureOrPresent
    private LocalDate startDate;
    @FutureOrPresent
    private LocalDate endDate;
}
