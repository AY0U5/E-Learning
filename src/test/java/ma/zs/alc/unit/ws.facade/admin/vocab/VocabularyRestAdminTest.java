package ma.zs.alc.unit.ws.facade.admin.vocab;

import ma.zs.alc.bean.core.vocab.Vocabulary;
import ma.zs.alc.service.impl.admin.vocab.VocabularyAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.vocab.VocabularyRestAdmin;
import ma.zs.alc.ws.converter.vocab.VocabularyConverter;
import ma.zs.alc.ws.dto.vocab.VocabularyDto;
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
public class VocabularyRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private VocabularyAdminServiceImpl service;
    @Mock
    private VocabularyConverter converter;

    @InjectMocks
    private VocabularyRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllVocabularyTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<VocabularyDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<VocabularyDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveVocabularyTest() throws Exception {
        // Mock data
        VocabularyDto requestDto = new VocabularyDto();
        Vocabulary entity = new Vocabulary();
        Vocabulary saved = new Vocabulary();
        VocabularyDto savedDto = new VocabularyDto();

        // Mock the converter to return the vocabulary object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved vocabulary DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<VocabularyDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        VocabularyDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved vocabulary DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getNumero(), responseBody.getNumero());
        assertEquals(savedDto.getWord(), responseBody.getWord());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getResult(), responseBody.getResult());
        assertEquals(savedDto.getExplication(), responseBody.getExplication());
        assertEquals(savedDto.getExemple(), responseBody.getExemple());
        assertEquals(savedDto.getImage(), responseBody.getImage());
    }

}
