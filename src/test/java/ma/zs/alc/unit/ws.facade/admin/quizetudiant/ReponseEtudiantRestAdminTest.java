package ma.zs.alc.unit.ws.facade.admin.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.service.impl.admin.quizetudiant.ReponseEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quizetudiant.ReponseEtudiantRestAdmin;
import ma.zs.alc.ws.converter.quizetudiant.ReponseEtudiantConverter;
import ma.zs.alc.ws.dto.quizetudiant.ReponseEtudiantDto;
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
public class ReponseEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ReponseEtudiantAdminServiceImpl service;
    @Mock
    private ReponseEtudiantConverter converter;

    @InjectMocks
    private ReponseEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllReponseEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ReponseEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ReponseEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveReponseEtudiantTest() throws Exception {
        // Mock data
        ReponseEtudiantDto requestDto = new ReponseEtudiantDto();
        ReponseEtudiant entity = new ReponseEtudiant();
        ReponseEtudiant saved = new ReponseEtudiant();
        ReponseEtudiantDto savedDto = new ReponseEtudiantDto();

        // Mock the converter to return the reponseEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved reponseEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ReponseEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ReponseEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved reponseEtudiant DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getAnswer(), responseBody.getAnswer());
        assertEquals(savedDto.getNote(), responseBody.getNote());
    }

}
