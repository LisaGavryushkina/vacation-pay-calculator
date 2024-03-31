package ru.neostudy.vacationpaycalculator.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class StartBeforeEndDateValidator implements ConstraintValidator<StartBeforeEndDateValid, HasStartEndDate> {

    @Override
    public void initialize(StartBeforeEndDateValid annotation) {
    }

    @Override
    public boolean isValid(HasStartEndDate bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getStartDate();
        final LocalDate endDate = bean.getEndDate();

        if (startDate == null || endDate == null) {
            return true;
        }
        return startDate.isBefore(endDate);
    }
}
