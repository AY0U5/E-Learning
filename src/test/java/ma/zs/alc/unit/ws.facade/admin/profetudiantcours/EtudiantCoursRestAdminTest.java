package ma.zs.alc.unit.ws.facade.admin.profetudiantcours;

import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.service.impl.admin.profetudiantcours.EtudiantCoursAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.profetudiantcours.EtudiantCoursRestAdmin;
import ma.zs.alc.ws.converter.profetudiantcours.EtudiantCoursConverter;
import ma.zs.alc.ws.dto.profetudiantcours.EtudiantCoursDto;
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
public class EtudiantCoursRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EtudiantCoursAdminServiceImpl service;
    @Mock
    private EtudiantCoursConverter converter;

    @InjectMocks
    private EtudiantCoursRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEtudiantCoursTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EtudiantCoursDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EtudiantCoursDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEtudiantCoursTest() throws Exception {
        // Mock data
        EtudiantCoursDto requestDto = new EtudiantCoursDto();
        EtudiantCours entity = new EtudiantCours();
        EtudiantCours saved = new EtudiantCours();
        EtudiantCoursDto savedDto = new EtudiantCoursDto();

        // Mock the converter to return the etudiantCours object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved etudiantCours DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EtudiantCoursDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EtudiantCoursDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved etudiantCours DTO
        assertEquals(savedDto.getPayer(), responseBody.getPayer());
        assertEquals(savedDto.getDateFin(), responseBody.getDateFin());
    }

}
