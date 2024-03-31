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
@Constraint(validatedBy = DaysAmountValidator.class)
@Documented
public @interface DaysAmountValid {

    String message() default "{There must be a transmitted vacation days amount between the start and end dates}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
