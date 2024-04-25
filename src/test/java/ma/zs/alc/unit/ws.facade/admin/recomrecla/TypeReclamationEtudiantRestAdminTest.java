package ma.zs.alc.unit.ws.facade.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import ma.zs.alc.service.impl.admin.recomrecla.TypeReclamationEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.recomrecla.TypeReclamationEtudiantRestAdmin;
import ma.zs.alc.ws.converter.recomrecla.TypeReclamationEtudiantConverter;
import ma.zs.alc.ws.dto.recomrecla.TypeReclamationEtudiantDto;
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
public class TypeReclamationEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TypeReclamationEtudiantAdminServiceImpl service;
    @Mock
    private TypeReclamationEtudiantConverter converter;

    @InjectMocks
    private TypeReclamationEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypeReclamationEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypeReclamationEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypeReclamationEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypeReclamationEtudiantTest() throws Exception {
        // Mock data
        TypeReclamationEtudiantDto requestDto = new TypeReclamationEtudiantDto();
        TypeReclamationEtudiant entity = new TypeReclamationEtudiant();
        TypeReclamationEtudiant saved = new TypeReclamationEtudiant();
        TypeReclamationEtudiantDto savedDto = new TypeReclamationEtudiantDto();

        // Mock the converter to return the typeReclamationEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typeReclamationEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypeReclamationEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypeReclamationEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typeReclamationEtudiant DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
