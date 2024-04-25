package ma.zs.alc.unit.ws.facade.admin.inscription;

import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.service.impl.admin.inscription.DictionaryAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscription.DictionaryRestAdmin;
import ma.zs.alc.ws.converter.inscription.DictionaryConverter;
import ma.zs.alc.ws.dto.inscription.DictionaryDto;
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
public class DictionaryRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private DictionaryAdminServiceImpl service;
    @Mock
    private DictionaryConverter converter;

    @InjectMocks
    private DictionaryRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllDictionaryTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<DictionaryDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<DictionaryDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveDictionaryTest() throws Exception {
        // Mock data
        DictionaryDto requestDto = new DictionaryDto();
        Dictionary entity = new Dictionary();
        Dictionary saved = new Dictionary();
        DictionaryDto savedDto = new DictionaryDto();

        // Mock the converter to return the dictionary object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved dictionary DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<DictionaryDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        DictionaryDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved dictionary DTO
        assertEquals(savedDto.getWord(), responseBody.getWord());
        assertEquals(savedDto.getDefinition(), responseBody.getDefinition());
    }

}
