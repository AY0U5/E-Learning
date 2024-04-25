package ma.zs.alc.unit.ws.facade.admin.courseref;

import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.service.impl.admin.courseref.CategorieSectionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.courseref.CategorieSectionRestAdmin;
import ma.zs.alc.ws.converter.courseref.CategorieSectionConverter;
import ma.zs.alc.ws.dto.courseref.CategorieSectionDto;
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
public class CategorieSectionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CategorieSectionAdminServiceImpl service;
    @Mock
    private CategorieSectionConverter converter;

    @InjectMocks
    private CategorieSectionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategorieSectionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategorieSectionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategorieSectionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategorieSectionTest() throws Exception {
        // Mock data
        CategorieSectionDto requestDto = new CategorieSectionDto();
        CategorieSection entity = new CategorieSection();
        CategorieSection saved = new CategorieSection();
        CategorieSectionDto savedDto = new CategorieSectionDto();

        // Mock the converter to return the categorieSection object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categorieSection DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategorieSectionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategorieSectionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categorieSection DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getNumeroOrder(), responseBody.getNumeroOrder());
    }

}
