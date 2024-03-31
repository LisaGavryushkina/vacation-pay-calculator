package ru.neostudy.vacationpaycalculator.validation;

import java.time.Duration;
import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DaysAmountValidator implements ConstraintValidator<DaysAmountValid, HasDatesInfo> {

    @Override
    public void initialize(DaysAmountValid annotation) {
    }

    @Override
    public boolean isValid(HasDatesInfo bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getStartDate();
        final LocalDate endDate = bean.getEndDate();
        final int daysAmount = bean.getDaysAmount();

        if (startDate == null || endDate == null) {
            return true;
        }
        return Duration.between(startDate, endDate).toDays() == daysAmount;
    }
}
