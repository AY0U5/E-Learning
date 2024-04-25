package ma.zs.alc.unit.ws.facade.admin.course;

import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.service.impl.admin.course.CoursAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.course.CoursRestAdmin;
import ma.zs.alc.ws.converter.course.CoursConverter;
import ma.zs.alc.ws.dto.course.CoursDto;
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
public class CoursRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CoursAdminServiceImpl service;
    @Mock
    private CoursConverter converter;

    @InjectMocks
    private CoursRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCoursTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CoursDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CoursDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCoursTest() throws Exception {
        // Mock data
        CoursDto requestDto = new CoursDto();
        Cours entity = new Cours();
        Cours saved = new Cours();
        CoursDto savedDto = new CoursDto();

        // Mock the converter to return the cours object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved cours DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CoursDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CoursDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved cours DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getImage(), responseBody.getImage());
        assertEquals(savedDto.getNombreSectionFinalise(), responseBody.getNombreSectionFinalise());
        assertEquals(savedDto.getNombreSectionEnCours(), responseBody.getNombreSectionEnCours());
        assertEquals(savedDto.getNombreLinkEnCours(), responseBody.getNombreLinkEnCours());
        assertEquals(savedDto.getNombreLinkFinalise(), responseBody.getNombreLinkFinalise());
        assertEquals(savedDto.getNumeroOrder(), responseBody.getNumeroOrder());
    }

}
