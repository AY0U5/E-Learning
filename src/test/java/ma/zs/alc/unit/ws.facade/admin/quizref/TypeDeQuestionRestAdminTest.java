package ma.zs.alc.unit.ws.facade.admin.quizref;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.service.impl.admin.quizref.TypeDeQuestionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quizref.TypeDeQuestionRestAdmin;
import ma.zs.alc.ws.converter.quizref.TypeDeQuestionConverter;
import ma.zs.alc.ws.dto.quizref.TypeDeQuestionDto;
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
public class TypeDeQuestionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TypeDeQuestionAdminServiceImpl service;
    @Mock
    private TypeDeQuestionConverter converter;

    @InjectMocks
    private TypeDeQuestionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypeDeQuestionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypeDeQuestionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypeDeQuestionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypeDeQuestionTest() throws Exception {
        // Mock data
        TypeDeQuestionDto requestDto = new TypeDeQuestionDto();
        TypeDeQuestion entity = new TypeDeQuestion();
        TypeDeQuestion saved = new TypeDeQuestion();
        TypeDeQuestionDto savedDto = new TypeDeQuestionDto();

        // Mock the converter to return the typeDeQuestion object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typeDeQuestion DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypeDeQuestionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypeDeQuestionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typeDeQuestion DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLib(), responseBody.getLib());
    }

}
