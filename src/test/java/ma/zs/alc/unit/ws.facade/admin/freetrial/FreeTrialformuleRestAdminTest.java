package ma.zs.alc.unit.ws.facade.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialformuleAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.freetrial.FreeTrialformuleRestAdmin;
import ma.zs.alc.ws.converter.freetrial.FreeTrialformuleConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialformuleDto;
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
public class FreeTrialformuleRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private FreeTrialformuleAdminServiceImpl service;
    @Mock
    private FreeTrialformuleConverter converter;

    @InjectMocks
    private FreeTrialformuleRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllFreeTrialformuleTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<FreeTrialformuleDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<FreeTrialformuleDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveFreeTrialformuleTest() throws Exception {
        // Mock data
        FreeTrialformuleDto requestDto = new FreeTrialformuleDto();
        FreeTrialformule entity = new FreeTrialformule();
        FreeTrialformule saved = new FreeTrialformule();
        FreeTrialformuleDto savedDto = new FreeTrialformuleDto();

        // Mock the converter to return the freeTrialformule object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved freeTrialformule DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<FreeTrialformuleDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        FreeTrialformuleDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved freeTrialformule DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getDayspeerweek(), responseBody.getDayspeerweek());
        assertEquals(savedDto.getTimeperday(), responseBody.getTimeperday());
        assertEquals(savedDto.getTeacherGenderoption(), responseBody.getTeacherGenderoption());
        assertEquals(savedDto.getTeacherAgeRange(), responseBody.getTeacherAgeRange());
        assertEquals(savedDto.getTeacherPersonnality(), responseBody.getTeacherPersonnality());
        assertEquals(savedDto.getStatus(), responseBody.getStatus());
        assertEquals(savedDto.getDateConfirmation(), responseBody.getDateConfirmation());
    }

}
