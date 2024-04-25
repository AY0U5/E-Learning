package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.service.impl.admin.inscriptionref.TeacherLocalityAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.TeacherLocalityRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.TeacherLocalityConverter;
import ma.zs.alc.ws.dto.inscriptionref.TeacherLocalityDto;
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
public class TeacherLocalityRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TeacherLocalityAdminServiceImpl service;
    @Mock
    private TeacherLocalityConverter converter;

    @InjectMocks
    private TeacherLocalityRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTeacherLocalityTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TeacherLocalityDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TeacherLocalityDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTeacherLocalityTest() throws Exception {
        // Mock data
        TeacherLocalityDto requestDto = new TeacherLocalityDto();
        TeacherLocality entity = new TeacherLocality();
        TeacherLocality saved = new TeacherLocality();
        TeacherLocalityDto savedDto = new TeacherLocalityDto();

        // Mock the converter to return the teacherLocality object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved teacherLocality DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TeacherLocalityDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TeacherLocalityDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved teacherLocality DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
