package ma.zs.alc.unit.ws.facade.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.service.impl.admin.recomrecla.RecommendTeacherAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.recomrecla.RecommendTeacherRestAdmin;
import ma.zs.alc.ws.converter.recomrecla.RecommendTeacherConverter;
import ma.zs.alc.ws.dto.recomrecla.RecommendTeacherDto;
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
public class RecommendTeacherRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private RecommendTeacherAdminServiceImpl service;
    @Mock
    private RecommendTeacherConverter converter;

    @InjectMocks
    private RecommendTeacherRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllRecommendTeacherTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<RecommendTeacherDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<RecommendTeacherDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveRecommendTeacherTest() throws Exception {
        // Mock data
        RecommendTeacherDto requestDto = new RecommendTeacherDto();
        RecommendTeacher entity = new RecommendTeacher();
        RecommendTeacher saved = new RecommendTeacher();
        RecommendTeacherDto savedDto = new RecommendTeacherDto();

        // Mock the converter to return the recommendTeacher object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved recommendTeacher DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<RecommendTeacherDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        RecommendTeacherDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved recommendTeacher DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getNombrevote(), responseBody.getNombrevote());
        assertEquals(savedDto.getNom(), responseBody.getNom());
        assertEquals(savedDto.getPrenom(), responseBody.getPrenom());
        assertEquals(savedDto.getCommentaire(), responseBody.getCommentaire());
        assertEquals(savedDto.getTelephone(), responseBody.getTelephone());
        assertEquals(savedDto.getLogin(), responseBody.getLogin());
        assertEquals(savedDto.getDateRecommamdation(), responseBody.getDateRecommamdation());
    }

}
