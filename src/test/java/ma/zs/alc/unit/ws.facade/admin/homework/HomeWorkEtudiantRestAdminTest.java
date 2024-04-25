package ma.zs.alc.unit.ws.facade.admin.homework;

import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.service.impl.admin.homework.HomeWorkEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.homework.HomeWorkEtudiantRestAdmin;
import ma.zs.alc.ws.converter.homework.HomeWorkEtudiantConverter;
import ma.zs.alc.ws.dto.homework.HomeWorkEtudiantDto;
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
public class HomeWorkEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private HomeWorkEtudiantAdminServiceImpl service;
    @Mock
    private HomeWorkEtudiantConverter converter;

    @InjectMocks
    private HomeWorkEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllHomeWorkEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<HomeWorkEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<HomeWorkEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveHomeWorkEtudiantTest() throws Exception {
        // Mock data
        HomeWorkEtudiantDto requestDto = new HomeWorkEtudiantDto();
        HomeWorkEtudiant entity = new HomeWorkEtudiant();
        HomeWorkEtudiant saved = new HomeWorkEtudiant();
        HomeWorkEtudiantDto savedDto = new HomeWorkEtudiantDto();

        // Mock the converter to return the homeWorkEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved homeWorkEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<HomeWorkEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        HomeWorkEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved homeWorkEtudiant DTO
        assertEquals(savedDto.getNote(), responseBody.getNote());
        assertEquals(savedDto.getResultat(), responseBody.getResultat());
        assertEquals(savedDto.getDateHomeWork(), responseBody.getDateHomeWork());
    }

}
