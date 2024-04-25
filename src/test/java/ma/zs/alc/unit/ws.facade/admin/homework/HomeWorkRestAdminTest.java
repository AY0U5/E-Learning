package ma.zs.alc.unit.ws.facade.admin.homework;

import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.service.impl.admin.homework.HomeWorkAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.homework.HomeWorkRestAdmin;
import ma.zs.alc.ws.converter.homework.HomeWorkConverter;
import ma.zs.alc.ws.dto.homework.HomeWorkDto;
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
public class HomeWorkRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private HomeWorkAdminServiceImpl service;
    @Mock
    private HomeWorkConverter converter;

    @InjectMocks
    private HomeWorkRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllHomeWorkTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<HomeWorkDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<HomeWorkDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveHomeWorkTest() throws Exception {
        // Mock data
        HomeWorkDto requestDto = new HomeWorkDto();
        HomeWork entity = new HomeWork();
        HomeWork saved = new HomeWork();
        HomeWorkDto savedDto = new HomeWorkDto();

        // Mock the converter to return the homeWork object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved homeWork DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<HomeWorkDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        HomeWorkDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved homeWork DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getUrlImage(), responseBody.getUrlImage());
        assertEquals(savedDto.getUrlVideo(), responseBody.getUrlVideo());
    }

}
