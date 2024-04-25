package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import ma.zs.alc.service.impl.admin.prof.ClassAverageBonusProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.ClassAverageBonusProfRestAdmin;
import ma.zs.alc.ws.converter.prof.ClassAverageBonusProfConverter;
import ma.zs.alc.ws.dto.prof.ClassAverageBonusProfDto;
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
public class ClassAverageBonusProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ClassAverageBonusProfAdminServiceImpl service;
    @Mock
    private ClassAverageBonusProfConverter converter;

    @InjectMocks
    private ClassAverageBonusProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllClassAverageBonusProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ClassAverageBonusProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ClassAverageBonusProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveClassAverageBonusProfTest() throws Exception {
        // Mock data
        ClassAverageBonusProfDto requestDto = new ClassAverageBonusProfDto();
        ClassAverageBonusProf entity = new ClassAverageBonusProf();
        ClassAverageBonusProf saved = new ClassAverageBonusProf();
        ClassAverageBonusProfDto savedDto = new ClassAverageBonusProfDto();

        // Mock the converter to return the classAverageBonusProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved classAverageBonusProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ClassAverageBonusProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ClassAverageBonusProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved classAverageBonusProf DTO
        assertEquals(savedDto.getMois(), responseBody.getMois());
        assertEquals(savedDto.getAnnee(), responseBody.getAnnee());
    }

}
