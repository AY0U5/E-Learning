package ma.zs.alc.unit.ws.facade.admin.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.service.impl.admin.salary.WorkloadBonusProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.salary.WorkloadBonusProfRestAdmin;
import ma.zs.alc.ws.converter.salary.WorkloadBonusProfConverter;
import ma.zs.alc.ws.dto.salary.WorkloadBonusProfDto;
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
public class WorkloadBonusProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private WorkloadBonusProfAdminServiceImpl service;
    @Mock
    private WorkloadBonusProfConverter converter;

    @InjectMocks
    private WorkloadBonusProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllWorkloadBonusProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<WorkloadBonusProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<WorkloadBonusProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveWorkloadBonusProfTest() throws Exception {
        // Mock data
        WorkloadBonusProfDto requestDto = new WorkloadBonusProfDto();
        WorkloadBonusProf entity = new WorkloadBonusProf();
        WorkloadBonusProf saved = new WorkloadBonusProf();
        WorkloadBonusProfDto savedDto = new WorkloadBonusProfDto();

        // Mock the converter to return the workloadBonusProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved workloadBonusProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<WorkloadBonusProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        WorkloadBonusProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved workloadBonusProf DTO
        assertEquals(savedDto.getMois(), responseBody.getMois());
        assertEquals(savedDto.getAnnee(), responseBody.getAnnee());
    }

}
