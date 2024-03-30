package ru.neostudy.vacationpaycalculator.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacation-pay")
public class VacationPayController {

    @GetMapping("/calculate")
    public double calculateVacationPay(@RequestParam double averageSalary, @RequestParam int daysAmount,
                                      @RequestParam(required = false) LocalDateTime startDate,
                                      @RequestParam(required = false) LocalDateTime endDate) {
        return 0.0;
    }
}
