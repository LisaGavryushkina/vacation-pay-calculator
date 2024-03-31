package ru.neostudy.vacationpaycalculator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;
import ru.neostudy.vacationpaycalculator.service.VacationPayService;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class VacationPayServiceTest {
    private static final BigDecimal AVERAGE_SALARY = new BigDecimal(50000);
    private VacationPayService vacationPayService;

    @BeforeEach
    public void start() {
        vacationPayService = new VacationPayService();
    }

    @Test
    public void whenOneDayVacation_thenReturnOneDayPay() {
        VacationInfoDto vacationInfoDto = new VacationInfoDto(AVERAGE_SALARY, 1, null);
        BigDecimal actual = vacationPayService.getVacationPay(vacationInfoDto);
        BigDecimal expected = new BigDecimal("1706.48");
        assertEquals(expected, actual);
    }

    @Test
    public void whenOneDayVacation_andItsHoliday_thenReturnZero() {
        VacationInfoDto vacationInfoDto = new VacationInfoDto(AVERAGE_SALARY, 1, LocalDate.of(2024, Month.JANUARY, 1));
        BigDecimal actual = vacationPayService.getVacationPay(vacationInfoDto);
        BigDecimal expected = new BigDecimal("0.00");
        assertEquals(expected, actual);
    }

    @Test
    public void whenVacationWithHolidays_thenReturnPayWithoutHolidays() {
        VacationInfoDto vacationInfoDto = new VacationInfoDto(AVERAGE_SALARY, 15, LocalDate.of(2024, Month.JANUARY, 1));
        VacationInfoDto vacationWithoutHolidaysInfoDto = new VacationInfoDto(AVERAGE_SALARY, 7, null);
        BigDecimal payWithoutHolidays = vacationPayService.getVacationPay(vacationWithoutHolidaysInfoDto);
        BigDecimal pay = vacationPayService.getVacationPay(vacationInfoDto);
        assertEquals(payWithoutHolidays, pay);
    }

    @Test
    public void whenEndDateInAnotherYear_thenReturnRightPay() {
        VacationInfoDto vacationInfoDto = new VacationInfoDto(AVERAGE_SALARY, 2, LocalDate.of(2024, Month.DECEMBER,
                31));
        BigDecimal expected = new BigDecimal("1706.48");
        BigDecimal actual = vacationPayService.getVacationPay(vacationInfoDto);
        assertEquals(expected, actual);
    }
}
