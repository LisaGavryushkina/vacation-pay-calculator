package ru.neostudy.vacationpaycalculator.model;

import java.time.LocalDate;
import java.time.Month;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@RequiredArgsConstructor
public class Date {
    Month month;
    int day;


    public Date(LocalDate localDate) {
        this(localDate.getMonth(), localDate.getDayOfMonth());
    }
}
