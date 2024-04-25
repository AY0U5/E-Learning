package ma.zs.alc.unit.ws.facade.admin.learning;

import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.service.impl.admin.learning.SessionCoursAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.learning.SessionCoursRestAdmin;
import ma.zs.alc.ws.converter.learning.SessionCoursConverter;
import ma.zs.alc.ws.dto.learning.SessionCoursDto;
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
public class SessionCoursRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SessionCoursAdminServiceImpl service;
    @Mock
    private SessionCoursConverter converter;

    @InjectMocks
    private SessionCoursRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSessionCoursTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SessionCoursDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SessionCoursDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSessionCoursTest() throws Exception {
        // Mock data
        SessionCoursDto requestDto = new SessionCoursDto();
        SessionCours entity = new SessionCours();
        SessionCours saved = new SessionCours();
        SessionCoursDto savedDto = new SessionCoursDto();

        // Mock the converter to return the sessionCours object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved sessionCours DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SessionCoursDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SessionCoursDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved sessionCours DTO
        assertEquals(savedDto.getReference(), responseBody.getReference());
        assertEquals(savedDto.getDuree(), responseBody.getDuree());
        assertEquals(savedDto.getTotalheure(), responseBody.getTotalheure());
        assertEquals(savedDto.getMois(), responseBody.getMois());
        assertEquals(savedDto.getAnnee(), responseBody.getAnnee());
        assertEquals(savedDto.getDateFin(), responseBody.getDateFin());
        assertEquals(savedDto.getDateDebut(), responseBody.getDateDebut());
        assertEquals(savedDto.getPayer(), responseBody.getPayer());
    }

}
