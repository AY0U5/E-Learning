package ma.zs.alc.unit.ws.facade.admin.courseref;

import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.service.impl.admin.courseref.SuperCategorieSectionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.courseref.SuperCategorieSectionRestAdmin;
import ma.zs.alc.ws.converter.courseref.SuperCategorieSectionConverter;
import ma.zs.alc.ws.dto.courseref.SuperCategorieSectionDto;
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
public class SuperCategorieSectionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SuperCategorieSectionAdminServiceImpl service;
    @Mock
    private SuperCategorieSectionConverter converter;

    @InjectMocks
    private SuperCategorieSectionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSuperCategorieSectionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SuperCategorieSectionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SuperCategorieSectionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSuperCategorieSectionTest() throws Exception {
        // Mock data
        SuperCategorieSectionDto requestDto = new SuperCategorieSectionDto();
        SuperCategorieSection entity = new SuperCategorieSection();
        SuperCategorieSection saved = new SuperCategorieSection();
        SuperCategorieSectionDto savedDto = new SuperCategorieSectionDto();

        // Mock the converter to return the superCategorieSection object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved superCategorieSection DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SuperCategorieSectionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SuperCategorieSectionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved superCategorieSection DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
