package ma.zs.alc.unit.ws.facade.admin.quiz;

import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.service.impl.admin.quiz.QuizAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quiz.QuizRestAdmin;
import ma.zs.alc.ws.converter.quiz.QuizConverter;
import ma.zs.alc.ws.dto.quiz.QuizDto;
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
public class QuizRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private QuizAdminServiceImpl service;
    @Mock
    private QuizConverter converter;

    @InjectMocks
    private QuizRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllQuizTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<QuizDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<QuizDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveQuizTest() throws Exception {
        // Mock data
        QuizDto requestDto = new QuizDto();
        Quiz entity = new Quiz();
        Quiz saved = new Quiz();
        QuizDto savedDto = new QuizDto();

        // Mock the converter to return the quiz object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved quiz DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<QuizDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        QuizDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved quiz DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLib(), responseBody.getLib());
        assertEquals(savedDto.getDateDebut(), responseBody.getDateDebut());
        assertEquals(savedDto.getDateFin(), responseBody.getDateFin());
        assertEquals(savedDto.getNumero(), responseBody.getNumero());
        assertEquals(savedDto.getSeuilReussite(), responseBody.getSeuilReussite());
    }

}
