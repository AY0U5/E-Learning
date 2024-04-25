package ma.zs.alc.unit.ws.facade.admin.pack;

import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.service.impl.admin.pack.PackStudentAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.pack.PackStudentRestAdmin;
import ma.zs.alc.ws.converter.pack.PackStudentConverter;
import ma.zs.alc.ws.dto.pack.PackStudentDto;
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
public class PackStudentRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private PackStudentAdminServiceImpl service;
    @Mock
    private PackStudentConverter converter;

    @InjectMocks
    private PackStudentRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPackStudentTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PackStudentDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PackStudentDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePackStudentTest() throws Exception {
        // Mock data
        PackStudentDto requestDto = new PackStudentDto();
        PackStudent entity = new PackStudent();
        PackStudent saved = new PackStudent();
        PackStudentDto savedDto = new PackStudentDto();

        // Mock the converter to return the packStudent object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved packStudent DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PackStudentDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PackStudentDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved packStudent DTO
        assertEquals(savedDto.getNombreCours(), responseBody.getNombreCours());
        assertEquals(savedDto.getForGroupe(), responseBody.getForGroupe());
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getPreRequisites(), responseBody.getPreRequisites());
        assertEquals(savedDto.getWhyTakeThisCourse(), responseBody.getWhyTakeThisCourse());
        assertEquals(savedDto.getExpectations(), responseBody.getExpectations());
        assertEquals(savedDto.getImgUrl(), responseBody.getImgUrl());
        assertEquals(savedDto.getTotalStudents(), responseBody.getTotalStudents());
        assertEquals(savedDto.getRating(), responseBody.getRating());
        assertEquals(savedDto.getOldPrice(), responseBody.getOldPrice());
    }

}
