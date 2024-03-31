package ru.neostudy.vacationpaycalculator;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.neostudy.vacationpaycalculator.controller.VacationPayController;
import ru.neostudy.vacationpaycalculator.error_handler.ErrorHandler;
import ru.neostudy.vacationpaycalculator.service.VacationPayService;

import static java.util.Objects.requireNonNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class VacationPayControllerTest {
    @Autowired
    private VacationPayController vacationPayController;
    @MockBean
    private VacationPayService vacationPayService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void start() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(vacationPayController)
                .setControllerAdvice(ErrorHandler.class)
                .build();
    }

    private static String getJson(String name) throws IOException {
        try (InputStream resourceAsStream =
                     requireNonNull(VacationPayControllerTest.class.getResourceAsStream(name))) {
            return new String(resourceAsStream.readAllBytes());
        }
    }

    @Test
    void whenAverageSalaryIsNegative_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/with_negative_average_salary.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/with_negative_average_salary.json"), true));
    }

    @Test
    void whenAverageSalaryIsZero_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/with_zero_average_salary.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/with_zero_average_salary.json"), true));
    }

    @Test
    void whenGetWithoutAverageSalary_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/without_average_salary.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/without_average_salary.json"), true));
    }

    @Test
    void whenDaysAmountIsNegative_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/with_negative_days_amount.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/with_negative_days_amount.json"), true));
    }

    @Test
    void whenDaysAmountIsZero_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/with_zero_days_amount.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/with_zero_days_amount.json"), true));
    }

    @Test
    void whenGetWithoutDaysAmount_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/without_days_amount.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/without_days_amount.json"), true));
    }

    @Test
    void whenGetWithDaysAmountGreaterThan80_thenStatus400() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/with_81_days_amount.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isBadRequest())
                .andExpect(content().json(getJson("/error_message/with_81_days_amount.json"), true));
    }

    @Test
    void whenGetWithoutStartDate_thenStatus200() throws Exception {

        mockMvc.perform(get("/vacation-pay/calculate")
                        .content(getJson("/vacation_info_dto/without_start_date.json"))
                        .characterEncoding(StandardCharsets.UTF_8)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk());
    }
}
