package ru.neostudy.vacationpaycalculator.service;

import java.time.Month;
import java.util.Set;

import org.springframework.stereotype.Service;
import ru.neostudy.vacationpaycalculator.model.Date;

@Service
public class OfficialHolidaysService {
    public final static Set<Date> OFFICIAL_HOLIDAYS = Set.of(
            new Date(Month.JANUARY, 1),
            new Date(Month.JANUARY, 2),
            new Date(Month.JANUARY, 3),
            new Date(Month.JANUARY, 4),
            new Date(Month.JANUARY, 5),
            new Date(Month.JANUARY, 6),
            new Date(Month.JANUARY, 7),
            new Date(Month.JANUARY, 8),
            new Date(Month.FEBRUARY, 23),
            new Date(Month.MARCH, 8),
            new Date(Month.MAY, 1),
            new Date(Month.MAY, 9),
            new Date(Month.JUNE, 12),
            new Date(Month.NOVEMBER, 4));

}
