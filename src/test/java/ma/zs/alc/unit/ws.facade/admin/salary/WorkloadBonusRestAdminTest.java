package ma.zs.alc.unit.ws.facade.admin.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.service.impl.admin.salary.WorkloadBonusAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.salary.WorkloadBonusRestAdmin;
import ma.zs.alc.ws.converter.salary.WorkloadBonusConverter;
import ma.zs.alc.ws.dto.salary.WorkloadBonusDto;
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
public class WorkloadBonusRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private WorkloadBonusAdminServiceImpl service;
    @Mock
    private WorkloadBonusConverter converter;

    @InjectMocks
    private WorkloadBonusRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllWorkloadBonusTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<WorkloadBonusDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<WorkloadBonusDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveWorkloadBonusTest() throws Exception {
        // Mock data
        WorkloadBonusDto requestDto = new WorkloadBonusDto();
        WorkloadBonus entity = new WorkloadBonus();
        WorkloadBonus saved = new WorkloadBonus();
        WorkloadBonusDto savedDto = new WorkloadBonusDto();

        // Mock the converter to return the workloadBonus object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved workloadBonus DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<WorkloadBonusDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        WorkloadBonusDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved workloadBonus DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getNombreSession(), responseBody.getNombreSession());
        assertEquals(savedDto.getPrix(), responseBody.getPrix());
    }

}
