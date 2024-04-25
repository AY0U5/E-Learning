package ma.zs.alc.unit.ws.facade.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialConfigurationAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.freetrial.FreeTrialConfigurationRestAdmin;
import ma.zs.alc.ws.converter.freetrial.FreeTrialConfigurationConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialConfigurationDto;
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
public class FreeTrialConfigurationRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private FreeTrialConfigurationAdminServiceImpl service;
    @Mock
    private FreeTrialConfigurationConverter converter;

    @InjectMocks
    private FreeTrialConfigurationRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllFreeTrialConfigurationTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<FreeTrialConfigurationDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<FreeTrialConfigurationDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveFreeTrialConfigurationTest() throws Exception {
        // Mock data
        FreeTrialConfigurationDto requestDto = new FreeTrialConfigurationDto();
        FreeTrialConfiguration entity = new FreeTrialConfiguration();
        FreeTrialConfiguration saved = new FreeTrialConfiguration();
        FreeTrialConfigurationDto savedDto = new FreeTrialConfigurationDto();

        // Mock the converter to return the freeTrialConfiguration object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved freeTrialConfiguration DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<FreeTrialConfigurationDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        FreeTrialConfigurationDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved freeTrialConfiguration DTO
        assertEquals(savedDto.getDateApplicationDebut(), responseBody.getDateApplicationDebut());
        assertEquals(savedDto.getDateApplicationFin(), responseBody.getDateApplicationFin());
        assertEquals(savedDto.getNombreStudentMax(), responseBody.getNombreStudentMax());
        assertEquals(savedDto.getNombreStudentMin(), responseBody.getNombreStudentMin());
    }

}
