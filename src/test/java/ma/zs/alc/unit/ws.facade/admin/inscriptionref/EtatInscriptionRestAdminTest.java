package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtatInscription;
import ma.zs.alc.service.impl.admin.inscriptionref.EtatInscriptionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.EtatInscriptionRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.EtatInscriptionConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtatInscriptionDto;
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
public class EtatInscriptionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EtatInscriptionAdminServiceImpl service;
    @Mock
    private EtatInscriptionConverter converter;

    @InjectMocks
    private EtatInscriptionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEtatInscriptionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EtatInscriptionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EtatInscriptionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEtatInscriptionTest() throws Exception {
        // Mock data
        EtatInscriptionDto requestDto = new EtatInscriptionDto();
        EtatInscription entity = new EtatInscription();
        EtatInscription saved = new EtatInscription();
        EtatInscriptionDto savedDto = new EtatInscriptionDto();

        // Mock the converter to return the etatInscription object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved etatInscription DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EtatInscriptionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EtatInscriptionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved etatInscription DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
