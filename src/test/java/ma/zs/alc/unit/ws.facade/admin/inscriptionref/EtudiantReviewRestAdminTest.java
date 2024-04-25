package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.service.impl.admin.inscriptionref.EtudiantReviewAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.EtudiantReviewRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.EtudiantReviewConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantReviewDto;
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
public class EtudiantReviewRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EtudiantReviewAdminServiceImpl service;
    @Mock
    private EtudiantReviewConverter converter;

    @InjectMocks
    private EtudiantReviewRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEtudiantReviewTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EtudiantReviewDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EtudiantReviewDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEtudiantReviewTest() throws Exception {
        // Mock data
        EtudiantReviewDto requestDto = new EtudiantReviewDto();
        EtudiantReview entity = new EtudiantReview();
        EtudiantReview saved = new EtudiantReview();
        EtudiantReviewDto savedDto = new EtudiantReviewDto();

        // Mock the converter to return the etudiantReview object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved etudiantReview DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EtudiantReviewDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EtudiantReviewDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved etudiantReview DTO
        assertEquals(savedDto.getReview(), responseBody.getReview());
        assertEquals(savedDto.getComment(), responseBody.getComment());
        assertEquals(savedDto.getDateReview(), responseBody.getDateReview());
    }

}
