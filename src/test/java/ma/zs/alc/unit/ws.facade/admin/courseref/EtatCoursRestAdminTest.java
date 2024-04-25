package ma.zs.alc.unit.ws.facade.admin.courseref;

import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.service.impl.admin.courseref.EtatCoursAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.courseref.EtatCoursRestAdmin;
import ma.zs.alc.ws.converter.courseref.EtatCoursConverter;
import ma.zs.alc.ws.dto.courseref.EtatCoursDto;
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
public class EtatCoursRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EtatCoursAdminServiceImpl service;
    @Mock
    private EtatCoursConverter converter;

    @InjectMocks
    private EtatCoursRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEtatCoursTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EtatCoursDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EtatCoursDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEtatCoursTest() throws Exception {
        // Mock data
        EtatCoursDto requestDto = new EtatCoursDto();
        EtatCours entity = new EtatCours();
        EtatCours saved = new EtatCours();
        EtatCoursDto savedDto = new EtatCoursDto();

        // Mock the converter to return the etatCours object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved etatCours DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EtatCoursDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EtatCoursDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved etatCours DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
