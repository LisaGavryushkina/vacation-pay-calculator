package ru.neostudy.vacationpaycalculator.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;

@Service
public class VacationPayService {
    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;

    public double getVacationPay(VacationInfoDto vacationInfoDto) {
        LocalDate startDate = vacationInfoDto.getStartDate();
        LocalDate endDate = vacationInfoDto.getEndDate();
        int daysAmount = vacationInfoDto.getDaysAmount();
        if (startDate != null && endDate != null) {
            daysAmount = getDaysAmountWithoutHolidays(startDate, endDate, daysAmount);
        }
        return calculate(vacationInfoDto.getAverageSalary(), daysAmount);
    }

    private int getDaysAmountWithoutHolidays(LocalDate startDate, LocalDate endDate, int daysAmount) {
        OfficialHolidaysService officialHolidaysService = new OfficialHolidaysService(startDate.getYear());
        for (LocalDate date : officialHolidaysService.getOfficialHolidays()) {
            if (date.isEqual(startDate) || date.isEqual(endDate) ||
                    date.isAfter(startDate) && date.isBefore(endDate)) {
                daysAmount--;
            }
        }
        return daysAmount;
    }

    private double calculate(double averageSalary, int daysAmount) {
        return averageSalary / AVERAGE_DAYS_IN_MONTH * daysAmount;
    }

}
