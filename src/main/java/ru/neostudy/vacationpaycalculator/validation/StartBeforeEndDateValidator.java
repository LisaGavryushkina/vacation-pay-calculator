package ru.neostudy.vacationpaycalculator.validation;

import java.time.LocalDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class StartBeforeEndDateValidator implements ConstraintValidator<StartBeforeEndDateValid, HasDatesInfo> {

    @Override
    public void initialize(StartBeforeEndDateValid annotation) {
    }

    @Override
    public boolean isValid(HasDatesInfo bean, ConstraintValidatorContext context) {
        final LocalDate startDate = bean.getStartDate();
        final LocalDate endDate = bean.getEndDate();

        if (startDate == null || endDate == null) {
            return true;
        }
        return startDate.isBefore(endDate);
    }
}
