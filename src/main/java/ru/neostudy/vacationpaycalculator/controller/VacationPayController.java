package ru.neostudy.vacationpaycalculator.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;

@RestController
@RequestMapping("/vacation-pay")
public class VacationPayController {

    @GetMapping("/calculate")
    public double calculateVacationPay(@RequestBody VacationInfoDto vacationInfoDto) {
        return 0.0;
    }
}
