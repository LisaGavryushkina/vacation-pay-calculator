package ru.neostudy.vacationpaycalculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.springframework.stereotype.Service;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;
import ru.neostudy.vacationpaycalculator.model.Date;

@Service
public class VacationPayService {
    private static final BigDecimal AVERAGE_DAYS_IN_MONTH = new BigDecimal("29.3");

    public BigDecimal getVacationPay(VacationInfoDto vacationInfoDto) {
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

    private BigDecimal calculate(BigDecimal averageSalary, int daysAmount) {
        return averageSalary.setScale(2, RoundingMode.HALF_UP)
                .divide(AVERAGE_DAYS_IN_MONTH, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(daysAmount));
    }

}
