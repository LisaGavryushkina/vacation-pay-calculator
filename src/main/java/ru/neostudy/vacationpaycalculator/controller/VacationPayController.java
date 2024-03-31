package ru.neostudy.vacationpaycalculator.controller;

import java.math.BigDecimal;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neostudy.vacationpaycalculator.dto.VacationInfoDto;
import ru.neostudy.vacationpaycalculator.service.VacationPayService;

@RestController
@RequestMapping("/vacation-pay")
@RequiredArgsConstructor
public class VacationPayController {
    private final VacationPayService vacationPayService;

    @GetMapping("/calculate")
    public BigDecimal calculateVacationPay(@RequestBody @Valid VacationInfoDto vacationInfoDto) {
        return vacationPayService.getVacationPay(vacationInfoDto);
    }
}
