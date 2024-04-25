package ma.zs.alc.unit.ws.facade.admin.quiz;

import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.service.impl.admin.quiz.ReponseAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quiz.ReponseRestAdmin;
import ma.zs.alc.ws.converter.quiz.ReponseConverter;
import ma.zs.alc.ws.dto.quiz.ReponseDto;
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
public class ReponseRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ReponseAdminServiceImpl service;
    @Mock
    private ReponseConverter converter;

    @InjectMocks
    private ReponseRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllReponseTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ReponseDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ReponseDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveReponseTest() throws Exception {
        // Mock data
        ReponseDto requestDto = new ReponseDto();
        Reponse entity = new Reponse();
        Reponse saved = new Reponse();
        ReponseDto savedDto = new ReponseDto();

        // Mock the converter to return the reponse object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved reponse DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ReponseDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ReponseDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved reponse DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLib(), responseBody.getLib());
        assertEquals(savedDto.getEtatReponse(), responseBody.getEtatReponse());
        assertEquals(savedDto.getNumero(), responseBody.getNumero());
    }

}
