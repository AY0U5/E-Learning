package ma.zs.alc.unit.ws.facade.admin.common;

import ma.zs.alc.bean.core.common.ClassAverageBonus;
import ma.zs.alc.service.impl.admin.common.ClassAverageBonusAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.common.ClassAverageBonusRestAdmin;
import ma.zs.alc.ws.converter.common.ClassAverageBonusConverter;
import ma.zs.alc.ws.dto.common.ClassAverageBonusDto;
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
public class ClassAverageBonusRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ClassAverageBonusAdminServiceImpl service;
    @Mock
    private ClassAverageBonusConverter converter;

    @InjectMocks
    private ClassAverageBonusRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllClassAverageBonusTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ClassAverageBonusDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ClassAverageBonusDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveClassAverageBonusTest() throws Exception {
        // Mock data
        ClassAverageBonusDto requestDto = new ClassAverageBonusDto();
        ClassAverageBonus entity = new ClassAverageBonus();
        ClassAverageBonus saved = new ClassAverageBonus();
        ClassAverageBonusDto savedDto = new ClassAverageBonusDto();

        // Mock the converter to return the classAverageBonus object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved classAverageBonus DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ClassAverageBonusDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ClassAverageBonusDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved classAverageBonus DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getNombreSession(), responseBody.getNombreSession());
        assertEquals(savedDto.getPrix(), responseBody.getPrix());
    }

}
