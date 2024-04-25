package ma.zs.alc.unit.ws.facade.admin.homework;

import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.service.impl.admin.homework.TypeHomeWorkAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.homework.TypeHomeWorkRestAdmin;
import ma.zs.alc.ws.converter.homework.TypeHomeWorkConverter;
import ma.zs.alc.ws.dto.homework.TypeHomeWorkDto;
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
public class TypeHomeWorkRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TypeHomeWorkAdminServiceImpl service;
    @Mock
    private TypeHomeWorkConverter converter;

    @InjectMocks
    private TypeHomeWorkRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTypeHomeWorkTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TypeHomeWorkDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TypeHomeWorkDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTypeHomeWorkTest() throws Exception {
        // Mock data
        TypeHomeWorkDto requestDto = new TypeHomeWorkDto();
        TypeHomeWork entity = new TypeHomeWork();
        TypeHomeWork saved = new TypeHomeWork();
        TypeHomeWorkDto savedDto = new TypeHomeWorkDto();

        // Mock the converter to return the typeHomeWork object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved typeHomeWork DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TypeHomeWorkDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TypeHomeWorkDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved typeHomeWork DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLib(), responseBody.getLib());
    }

}
