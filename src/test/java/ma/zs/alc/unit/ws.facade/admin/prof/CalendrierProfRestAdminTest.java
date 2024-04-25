package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.service.impl.admin.prof.CalendrierProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.CalendrierProfRestAdmin;
import ma.zs.alc.ws.converter.prof.CalendrierProfConverter;
import ma.zs.alc.ws.dto.prof.CalendrierProfDto;
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
public class CalendrierProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CalendrierProfAdminServiceImpl service;
    @Mock
    private CalendrierProfConverter converter;

    @InjectMocks
    private CalendrierProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCalendrierProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CalendrierProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CalendrierProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCalendrierProfTest() throws Exception {
        // Mock data
        CalendrierProfDto requestDto = new CalendrierProfDto();
        CalendrierProf entity = new CalendrierProf();
        CalendrierProf saved = new CalendrierProf();
        CalendrierProfDto savedDto = new CalendrierProfDto();

        // Mock the converter to return the calendrierProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved calendrierProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CalendrierProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CalendrierProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved calendrierProf DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getStartTime(), responseBody.getStartTime());
        assertEquals(savedDto.getEndTime(), responseBody.getEndTime());
        assertEquals(savedDto.getStartRecur(), responseBody.getStartRecur());
        assertEquals(savedDto.getEndRecur(), responseBody.getEndRecur());
    }

}
