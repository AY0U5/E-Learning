package ma.zs.alc.unit.ws.facade.admin.learning;

import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.service.impl.admin.learning.SessionCoursSectionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.learning.SessionCoursSectionRestAdmin;
import ma.zs.alc.ws.converter.learning.SessionCoursSectionConverter;
import ma.zs.alc.ws.dto.learning.SessionCoursSectionDto;
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
public class SessionCoursSectionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SessionCoursSectionAdminServiceImpl service;
    @Mock
    private SessionCoursSectionConverter converter;

    @InjectMocks
    private SessionCoursSectionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSessionCoursSectionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SessionCoursSectionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SessionCoursSectionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSessionCoursSectionTest() throws Exception {
        // Mock data
        SessionCoursSectionDto requestDto = new SessionCoursSectionDto();
        SessionCoursSection entity = new SessionCoursSection();
        SessionCoursSection saved = new SessionCoursSection();
        SessionCoursSectionDto savedDto = new SessionCoursSectionDto();

        // Mock the converter to return the sessionCoursSection object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved sessionCoursSection DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SessionCoursSectionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SessionCoursSectionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved sessionCoursSection DTO
    }

}
