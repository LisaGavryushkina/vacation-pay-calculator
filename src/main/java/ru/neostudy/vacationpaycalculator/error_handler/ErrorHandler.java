package ru.neostudy.vacationpaycalculator.error_handler;

import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ErrorHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder str = new StringBuilder();
        for (ObjectError error : e.getAllErrors()) {
            str.append(error.getDefaultMessage());
        }
        String errorMessage = str.toString();
        log.error(errorMessage);
        return new ErrorResponse(errorMessage);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException e) {
        log.error(e.getMessage());
        return new ErrorResponse(e.getMessage());
    }

}
