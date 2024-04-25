package ma.zs.alc.unit.ws.facade.admin.review;

import ma.zs.alc.bean.core.review.ProfReview;
import ma.zs.alc.service.impl.admin.review.ProfReviewAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.review.ProfReviewRestAdmin;
import ma.zs.alc.ws.converter.review.ProfReviewConverter;
import ma.zs.alc.ws.dto.review.ProfReviewDto;
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
public class ProfReviewRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ProfReviewAdminServiceImpl service;
    @Mock
    private ProfReviewConverter converter;

    @InjectMocks
    private ProfReviewRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllProfReviewTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ProfReviewDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ProfReviewDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveProfReviewTest() throws Exception {
        // Mock data
        ProfReviewDto requestDto = new ProfReviewDto();
        ProfReview entity = new ProfReview();
        ProfReview saved = new ProfReview();
        ProfReviewDto savedDto = new ProfReviewDto();

        // Mock the converter to return the profReview object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved profReview DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ProfReviewDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ProfReviewDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved profReview DTO
        assertEquals(savedDto.getReview(), responseBody.getReview());
        assertEquals(savedDto.getComment(), responseBody.getComment());
        assertEquals(savedDto.getDateReview(), responseBody.getDateReview());
    }

}
