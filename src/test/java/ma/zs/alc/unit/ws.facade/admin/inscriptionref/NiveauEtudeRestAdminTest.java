package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.service.impl.admin.inscriptionref.NiveauEtudeAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.NiveauEtudeRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.NiveauEtudeConverter;
import ma.zs.alc.ws.dto.inscriptionref.NiveauEtudeDto;
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
public class NiveauEtudeRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private NiveauEtudeAdminServiceImpl service;
    @Mock
    private NiveauEtudeConverter converter;

    @InjectMocks
    private NiveauEtudeRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllNiveauEtudeTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<NiveauEtudeDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<NiveauEtudeDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveNiveauEtudeTest() throws Exception {
        // Mock data
        NiveauEtudeDto requestDto = new NiveauEtudeDto();
        NiveauEtude entity = new NiveauEtude();
        NiveauEtude saved = new NiveauEtude();
        NiveauEtudeDto savedDto = new NiveauEtudeDto();

        // Mock the converter to return the niveauEtude object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved niveauEtude DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<NiveauEtudeDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        NiveauEtudeDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved niveauEtude DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
    }

}
