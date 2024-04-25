package ma.zs.alc.unit.ws.facade.admin.homework;

import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.service.impl.admin.homework.ReponseEtudiantHomeWorkAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.homework.ReponseEtudiantHomeWorkRestAdmin;
import ma.zs.alc.ws.converter.homework.ReponseEtudiantHomeWorkConverter;
import ma.zs.alc.ws.dto.homework.ReponseEtudiantHomeWorkDto;
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
public class ReponseEtudiantHomeWorkRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ReponseEtudiantHomeWorkAdminServiceImpl service;
    @Mock
    private ReponseEtudiantHomeWorkConverter converter;

    @InjectMocks
    private ReponseEtudiantHomeWorkRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllReponseEtudiantHomeWorkTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ReponseEtudiantHomeWorkDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ReponseEtudiantHomeWorkDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveReponseEtudiantHomeWorkTest() throws Exception {
        // Mock data
        ReponseEtudiantHomeWorkDto requestDto = new ReponseEtudiantHomeWorkDto();
        ReponseEtudiantHomeWork entity = new ReponseEtudiantHomeWork();
        ReponseEtudiantHomeWork saved = new ReponseEtudiantHomeWork();
        ReponseEtudiantHomeWorkDto savedDto = new ReponseEtudiantHomeWorkDto();

        // Mock the converter to return the reponseEtudiantHomeWork object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved reponseEtudiantHomeWork DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ReponseEtudiantHomeWorkDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ReponseEtudiantHomeWorkDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved reponseEtudiantHomeWork DTO
        assertEquals(savedDto.getAnswer(), responseBody.getAnswer());
        assertEquals(savedDto.getProfNote(), responseBody.getProfNote());
        assertEquals(savedDto.getNote(), responseBody.getNote());
    }

}
