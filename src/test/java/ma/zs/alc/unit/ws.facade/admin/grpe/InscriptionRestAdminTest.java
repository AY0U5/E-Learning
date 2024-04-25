package ma.zs.alc.unit.ws.facade.admin.grpe;

import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.service.impl.admin.grpe.InscriptionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.grpe.InscriptionRestAdmin;
import ma.zs.alc.ws.converter.grpe.InscriptionConverter;
import ma.zs.alc.ws.dto.grpe.InscriptionDto;
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
public class InscriptionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private InscriptionAdminServiceImpl service;
    @Mock
    private InscriptionConverter converter;

    @InjectMocks
    private InscriptionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllInscriptionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<InscriptionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<InscriptionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveInscriptionTest() throws Exception {
        // Mock data
        InscriptionDto requestDto = new InscriptionDto();
        Inscription entity = new Inscription();
        Inscription saved = new Inscription();
        InscriptionDto savedDto = new InscriptionDto();

        // Mock the converter to return the inscription object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved inscription DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<InscriptionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        InscriptionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved inscription DTO
        assertEquals(savedDto.getNumeroInscription(), responseBody.getNumeroInscription());
        assertEquals(savedDto.getNoteQuizNiveau(), responseBody.getNoteQuizNiveau());
        assertEquals(savedDto.getQuizFinished(), responseBody.getQuizFinished());
        assertEquals(savedDto.getDateRegistration(), responseBody.getDateRegistration());
        assertEquals(savedDto.getDatedebutinscription(), responseBody.getDatedebutinscription());
        assertEquals(savedDto.getDatefininscription(), responseBody.getDatefininscription());
        assertEquals(savedDto.getSkype(), responseBody.getSkype());
    }

}
