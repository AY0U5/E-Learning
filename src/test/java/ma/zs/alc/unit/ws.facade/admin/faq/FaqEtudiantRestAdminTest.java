package ma.zs.alc.unit.ws.facade.admin.faq;

import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.service.impl.admin.faq.FaqEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.faq.FaqEtudiantRestAdmin;
import ma.zs.alc.ws.converter.faq.FaqEtudiantConverter;
import ma.zs.alc.ws.dto.faq.FaqEtudiantDto;
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
public class FaqEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private FaqEtudiantAdminServiceImpl service;
    @Mock
    private FaqEtudiantConverter converter;

    @InjectMocks
    private FaqEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllFaqEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<FaqEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<FaqEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveFaqEtudiantTest() throws Exception {
        // Mock data
        FaqEtudiantDto requestDto = new FaqEtudiantDto();
        FaqEtudiant entity = new FaqEtudiant();
        FaqEtudiant saved = new FaqEtudiant();
        FaqEtudiantDto savedDto = new FaqEtudiantDto();

        // Mock the converter to return the faqEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved faqEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<FaqEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        FaqEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved faqEtudiant DTO
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
