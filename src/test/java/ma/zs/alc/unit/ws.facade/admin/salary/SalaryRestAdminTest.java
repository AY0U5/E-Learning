package ma.zs.alc.unit.ws.facade.admin.salary;

import ma.zs.alc.bean.core.salary.Salary;
import ma.zs.alc.service.impl.admin.salary.SalaryAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.salary.SalaryRestAdmin;
import ma.zs.alc.ws.converter.salary.SalaryConverter;
import ma.zs.alc.ws.dto.salary.SalaryDto;
import org.aspectj.lang.annotation.Before;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SalaryRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SalaryAdminServiceImpl service;
    @Mock
    private SalaryConverter converter;

    @InjectMocks
    private SalaryRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSalaryTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SalaryDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SalaryDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSalaryTest() throws Exception {
        // Mock data
        SalaryDto requestDto = new SalaryDto();
        Salary entity = new Salary();
        Salary saved = new Salary();
        SalaryDto savedDto = new SalaryDto();

        // Mock the converter to return the salary object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved salary DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SalaryDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SalaryDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved salary DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getMois(), responseBody.getMois());
        assertEquals(savedDto.getAnnee(), responseBody.getAnnee());
        assertEquals(savedDto.getNbrSessionMensuel(), responseBody.getNbrSessionMensuel());
        assertEquals(savedDto.getPayer(), responseBody.getPayer());
        assertEquals(savedDto.getTotalPayment(), responseBody.getTotalPayment());
        assertEquals(savedDto.getTotalBonusClassAverage(), responseBody.getTotalBonusClassAverage());
        assertEquals(savedDto.getTotalBonusWorkload(), responseBody.getTotalBonusWorkload());
    }

}
