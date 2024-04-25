package ma.zs.alc.unit.ws.facade.admin.course;

import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.service.impl.admin.course.SectionAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.course.SectionRestAdmin;
import ma.zs.alc.ws.converter.course.SectionConverter;
import ma.zs.alc.ws.dto.course.SectionDto;
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
public class SectionRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SectionAdminServiceImpl service;
    @Mock
    private SectionConverter converter;

    @InjectMocks
    private SectionRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSectionTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SectionDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SectionDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSectionTest() throws Exception {
        // Mock data
        SectionDto requestDto = new SectionDto();
        Section entity = new Section();
        Section saved = new Section();
        SectionDto savedDto = new SectionDto();

        // Mock the converter to return the section object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved section DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SectionDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SectionDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved section DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getUrlImage(), responseBody.getUrlImage());
        assertEquals(savedDto.getUrlImage2(), responseBody.getUrlImage2());
        assertEquals(savedDto.getUrlImage3(), responseBody.getUrlImage3());
        assertEquals(savedDto.getUrlVideo(), responseBody.getUrlVideo());
        assertEquals(savedDto.getContenu(), responseBody.getContenu());
        assertEquals(savedDto.getQuestions(), responseBody.getQuestions());
        assertEquals(savedDto.getIndicationProf(), responseBody.getIndicationProf());
        assertEquals(savedDto.getNumeroOrder(), responseBody.getNumeroOrder());
        assertEquals(savedDto.getUrl(), responseBody.getUrl());
        assertEquals(savedDto.getContent(), responseBody.getContent());
    }

}
