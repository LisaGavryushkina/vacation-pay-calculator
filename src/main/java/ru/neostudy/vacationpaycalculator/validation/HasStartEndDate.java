package ru.neostudy.vacationpaycalculator.validation;

import java.time.LocalDate;

public interface HasStartEndDate {
    LocalDate getStartDate();

    LocalDate getEndDate();
}