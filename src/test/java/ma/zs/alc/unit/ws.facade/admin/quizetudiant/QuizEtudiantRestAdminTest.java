package ma.zs.alc.unit.ws.facade.admin.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.service.impl.admin.quizetudiant.QuizEtudiantAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quizetudiant.QuizEtudiantRestAdmin;
import ma.zs.alc.ws.converter.quizetudiant.QuizEtudiantConverter;
import ma.zs.alc.ws.dto.quizetudiant.QuizEtudiantDto;
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
public class QuizEtudiantRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private QuizEtudiantAdminServiceImpl service;
    @Mock
    private QuizEtudiantConverter converter;

    @InjectMocks
    private QuizEtudiantRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllQuizEtudiantTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<QuizEtudiantDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<QuizEtudiantDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveQuizEtudiantTest() throws Exception {
        // Mock data
        QuizEtudiantDto requestDto = new QuizEtudiantDto();
        QuizEtudiant entity = new QuizEtudiant();
        QuizEtudiant saved = new QuizEtudiant();
        QuizEtudiantDto savedDto = new QuizEtudiantDto();

        // Mock the converter to return the quizEtudiant object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved quizEtudiant DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<QuizEtudiantDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        QuizEtudiantDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved quizEtudiant DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getNote(), responseBody.getNote());
        assertEquals(savedDto.getResultat(), responseBody.getResultat());
        assertEquals(savedDto.getQuestionCurrent(), responseBody.getQuestionCurrent());
    }

}
