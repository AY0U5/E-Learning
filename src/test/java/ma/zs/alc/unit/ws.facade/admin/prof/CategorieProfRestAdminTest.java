package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.service.impl.admin.prof.CategorieProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.CategorieProfRestAdmin;
import ma.zs.alc.ws.converter.prof.CategorieProfConverter;
import ma.zs.alc.ws.dto.prof.CategorieProfDto;
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
public class CategorieProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CategorieProfAdminServiceImpl service;
    @Mock
    private CategorieProfConverter converter;

    @InjectMocks
    private CategorieProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCategorieProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CategorieProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CategorieProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCategorieProfTest() throws Exception {
        // Mock data
        CategorieProfDto requestDto = new CategorieProfDto();
        CategorieProf entity = new CategorieProf();
        CategorieProf saved = new CategorieProf();
        CategorieProfDto savedDto = new CategorieProfDto();

        // Mock the converter to return the categorieProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved categorieProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CategorieProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CategorieProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved categorieProf DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLevel(), responseBody.getLevel());
        assertEquals(savedDto.getLessonRate(), responseBody.getLessonRate());
    }

}
