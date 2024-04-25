package ma.zs.alc.unit.ws.facade.admin.course;

import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.service.impl.admin.course.ParcoursAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.course.ParcoursRestAdmin;
import ma.zs.alc.ws.converter.course.ParcoursConverter;
import ma.zs.alc.ws.dto.course.ParcoursDto;
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
public class ParcoursRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ParcoursAdminServiceImpl service;
    @Mock
    private ParcoursConverter converter;

    @InjectMocks
    private ParcoursRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllParcoursTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ParcoursDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ParcoursDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveParcoursTest() throws Exception {
        // Mock data
        ParcoursDto requestDto = new ParcoursDto();
        Parcours entity = new Parcours();
        Parcours saved = new Parcours();
        ParcoursDto savedDto = new ParcoursDto();

        // Mock the converter to return the parcours object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved parcours DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ParcoursDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ParcoursDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved parcours DTO
        assertEquals(savedDto.getDatePublication(), responseBody.getDatePublication());
        assertEquals(savedDto.getDateCreation(), responseBody.getDateCreation());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getNumeroOrder(), responseBody.getNumeroOrder());
        assertEquals(savedDto.getNombreCours(), responseBody.getNombreCours());
    }

}
