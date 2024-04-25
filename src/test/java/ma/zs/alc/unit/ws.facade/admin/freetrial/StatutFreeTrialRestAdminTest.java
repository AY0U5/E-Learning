package ma.zs.alc.unit.ws.facade.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import ma.zs.alc.service.impl.admin.freetrial.StatutFreeTrialAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.freetrial.StatutFreeTrialRestAdmin;
import ma.zs.alc.ws.converter.freetrial.StatutFreeTrialConverter;
import ma.zs.alc.ws.dto.freetrial.StatutFreeTrialDto;
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
public class StatutFreeTrialRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private StatutFreeTrialAdminServiceImpl service;
    @Mock
    private StatutFreeTrialConverter converter;

    @InjectMocks
    private StatutFreeTrialRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllStatutFreeTrialTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<StatutFreeTrialDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<StatutFreeTrialDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveStatutFreeTrialTest() throws Exception {
        // Mock data
        StatutFreeTrialDto requestDto = new StatutFreeTrialDto();
        StatutFreeTrial entity = new StatutFreeTrial();
        StatutFreeTrial saved = new StatutFreeTrial();
        StatutFreeTrialDto savedDto = new StatutFreeTrialDto();

        // Mock the converter to return the statutFreeTrial object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved statutFreeTrial DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<StatutFreeTrialDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        StatutFreeTrialDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved statutFreeTrial DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getStyle(), responseBody.getStyle());
    }

}
