package ma.zs.alc.unit.ws.facade.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import ma.zs.alc.service.impl.admin.recomrecla.ReclamationEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.recomrecla.ReclamationEtudiantRestAdmin;
import ma.zs.alc.ws.converter.recomrecla.ReclamationEtudiantConverter;
import ma.zs.alc.ws.dto.recomrecla.ReclamationEtudiantDto;
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
public class ReclamationEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ReclamationEtudiantAdminServiceImpl service;
    @Mock
    private ReclamationEtudiantConverter converter;

    @InjectMocks
    private ReclamationEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllReclamationEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ReclamationEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ReclamationEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveReclamationEtudiantTest() throws Exception {
        // Mock data
        ReclamationEtudiantDto requestDto = new ReclamationEtudiantDto();
        ReclamationEtudiant entity = new ReclamationEtudiant();
        ReclamationEtudiant saved = new ReclamationEtudiant();
        ReclamationEtudiantDto savedDto = new ReclamationEtudiantDto();

        // Mock the converter to return the reclamationEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved reclamationEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ReclamationEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ReclamationEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved reclamationEtudiant DTO
        assertEquals(savedDto.getReference(), responseBody.getReference());
        assertEquals(savedDto.getDateReclamation(), responseBody.getDateReclamation());
        assertEquals(savedDto.getMessage(), responseBody.getMessage());
        assertEquals(savedDto.getSetFrom(), responseBody.getSetFrom());
        assertEquals(savedDto.getImg(), responseBody.getImg());
        assertEquals(savedDto.getTraite(), responseBody.getTraite());
        assertEquals(savedDto.getDateTraitement(), responseBody.getDateTraitement());
        assertEquals(savedDto.getDateReponse(), responseBody.getDateReponse());
        assertEquals(savedDto.getPostView(), responseBody.getPostView());
        assertEquals(savedDto.getObjetReclamationEtudiant(), responseBody.getObjetReclamationEtudiant());
        assertEquals(savedDto.getCommentaireTraiteur(), responseBody.getCommentaireTraiteur());
        assertEquals(savedDto.getUsername(), responseBody.getUsername());
    }

}
