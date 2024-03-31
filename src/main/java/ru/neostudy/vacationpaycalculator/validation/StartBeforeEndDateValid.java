package ru.neostudy.vacationpaycalculator.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = StartBeforeEndDateValidator.class)
@Documented

public @interface StartBeforeEndDateValid {

    String message() default "{Start day must be before end day}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
