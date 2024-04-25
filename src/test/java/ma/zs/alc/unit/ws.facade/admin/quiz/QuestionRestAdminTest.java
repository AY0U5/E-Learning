package ma.zs.alc.unit.ws.facade.admin.quiz;

import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.service.impl.admin.quiz.QuestionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quiz.QuestionRestAdmin;
import ma.zs.alc.ws.converter.quiz.QuestionConverter;
import ma.zs.alc.ws.dto.quiz.QuestionDto;
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
public class QuestionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private QuestionAdminServiceImpl service;
    @Mock
    private QuestionConverter converter;

    @InjectMocks
    private QuestionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllQuestionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<QuestionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<QuestionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveQuestionTest() throws Exception {
        // Mock data
        QuestionDto requestDto = new QuestionDto();
        Question entity = new Question();
        Question saved = new Question();
        QuestionDto savedDto = new QuestionDto();

        // Mock the converter to return the question object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved question DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<QuestionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        QuestionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved question DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getUrlImg(), responseBody.getUrlImg());
        assertEquals(savedDto.getUrlVideo(), responseBody.getUrlVideo());
        assertEquals(savedDto.getNumero(), responseBody.getNumero());
        assertEquals(savedDto.getPointReponseJuste(), responseBody.getPointReponseJuste());
        assertEquals(savedDto.getPointReponsefausse(), responseBody.getPointReponsefausse());
    }

}
