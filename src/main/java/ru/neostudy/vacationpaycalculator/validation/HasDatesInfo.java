package ru.neostudy.vacationpaycalculator.validation;

import java.time.LocalDate;

public interface HasDatesInfo {

    int getDaysAmount();
    LocalDate getStartDate();

    LocalDate getEndDate();
}