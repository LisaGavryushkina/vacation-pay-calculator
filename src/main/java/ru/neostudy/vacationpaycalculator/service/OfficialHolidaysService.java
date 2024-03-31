package ru.neostudy.vacationpaycalculator.service;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class OfficialHolidaysService {
    private final Set<LocalDate> officialHolidays;

    public OfficialHolidaysService(int year) {
        officialHolidays = new HashSet<>();
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 1));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 2));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 3));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 4));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 5));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 6));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 7));
        officialHolidays.add(LocalDate.of(year, Month.JANUARY, 8));
        officialHolidays.add(LocalDate.of(year, Month.FEBRUARY, 23));
        officialHolidays.add(LocalDate.of(year, Month.MARCH, 8));
        officialHolidays.add(LocalDate.of(year, Month.MAY, 1));
        officialHolidays.add(LocalDate.of(year, Month.MAY, 9));
    }
}
