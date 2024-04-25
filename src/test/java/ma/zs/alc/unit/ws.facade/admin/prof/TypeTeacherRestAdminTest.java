package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.service.impl.admin.prof.TypeTeacherAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.TypeTeacherRestAdmin;
import ma.zs.alc.ws.converter.prof.TypeTeacherConverter;
import ma.zs.alc.ws.dto.prof.TypeTeacherDto;
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
public class TypeTeacherRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TypeTeacherAdminServiceImpl service;
    @Mock
    private TypeTeacherConverter converter;

    @InjectMocks
    private TypeTeacherRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypeTeacherTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypeTeacherDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypeTeacherDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypeTeacherTest() throws Exception {
        // Mock data
        TypeTeacherDto requestDto = new TypeTeacherDto();
        TypeTeacher entity = new TypeTeacher();
        TypeTeacher saved = new TypeTeacher();
        TypeTeacherDto savedDto = new TypeTeacherDto();

        // Mock the converter to return the typeTeacher object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typeTeacher DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypeTeacherDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypeTeacherDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typeTeacher DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getCode(), responseBody.getCode());
    }

}
