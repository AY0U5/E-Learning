package ma.zs.alc.unit.ws.facade.admin.quiz;

import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.service.impl.admin.quiz.QuizClassRoomAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.quiz.QuizClassRoomRestAdmin;
import ma.zs.alc.ws.converter.quiz.QuizClassRoomConverter;
import ma.zs.alc.ws.dto.quiz.QuizClassRoomDto;
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
public class QuizClassRoomRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private QuizClassRoomAdminServiceImpl service;
    @Mock
    private QuizClassRoomConverter converter;

    @InjectMocks
    private QuizClassRoomRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllQuizClassRoomTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<QuizClassRoomDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<QuizClassRoomDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveQuizClassRoomTest() throws Exception {
        // Mock data
        QuizClassRoomDto requestDto = new QuizClassRoomDto();
        QuizClassRoom entity = new QuizClassRoom();
        QuizClassRoom saved = new QuizClassRoom();
        QuizClassRoomDto savedDto = new QuizClassRoomDto();

        // Mock the converter to return the quizClassRoom object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved quizClassRoom DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<QuizClassRoomDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        QuizClassRoomDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved quizClassRoom DTO
    }

}
