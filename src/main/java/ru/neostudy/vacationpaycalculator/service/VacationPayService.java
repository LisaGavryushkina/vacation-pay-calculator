package ru.neostudy.vacationpaycalculator.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;
import ru.neostudy.vacationpaycalculator.model.Date;

@Service
public class VacationPayService {
    private static final double AVERAGE_DAYS_IN_MONTH = 29.3;

    public double getVacationPay(VacationInfoDto vacationInfoDto) {
        LocalDate startDate = vacationInfoDto.getStartDate();
        int daysAmount = vacationInfoDto.getDaysAmount();
        if (startDate != null) {
            LocalDate endDate = startDate.plusDays(daysAmount - 1);
            daysAmount -= getHolidaysAmount(startDate, endDate);
        }
        return calculate(vacationInfoDto.getAverageSalary(), daysAmount);
    }

    private int getHolidaysAmount(LocalDate startDate, LocalDate endDate) {
        int holidaysAmount = 0;
        for (LocalDate day = startDate; !day.isAfter(endDate); day = day.plusDays(1)) {
            if (OfficialHolidaysService.OFFICIAL_HOLIDAYS.contains(new Date(day))) {
                holidaysAmount++;
            }
        }
        return holidaysAmount;
    }

    private double calculate(double averageSalary, int daysAmount) {
        return averageSalary / AVERAGE_DAYS_IN_MONTH * daysAmount;
    }

}
