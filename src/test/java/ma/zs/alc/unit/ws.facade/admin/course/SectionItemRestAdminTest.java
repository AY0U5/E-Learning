package ma.zs.alc.unit.ws.facade.admin.course;

import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.service.impl.admin.course.SectionItemAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.course.SectionItemRestAdmin;
import ma.zs.alc.ws.converter.course.SectionItemConverter;
import ma.zs.alc.ws.dto.course.SectionItemDto;
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
public class SectionItemRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private SectionItemAdminServiceImpl service;
    @Mock
    private SectionItemConverter converter;

    @InjectMocks
    private SectionItemRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllSectionItemTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<SectionItemDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<SectionItemDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveSectionItemTest() throws Exception {
        // Mock data
        SectionItemDto requestDto = new SectionItemDto();
        SectionItem entity = new SectionItem();
        SectionItem saved = new SectionItem();
        SectionItemDto savedDto = new SectionItemDto();

        // Mock the converter to return the sectionItem object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved sectionItem DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<SectionItemDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        SectionItemDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved sectionItem DTO
        assertEquals(savedDto.getImageUrl(), responseBody.getImageUrl());
        assertEquals(savedDto.getResponse(), responseBody.getResponse());
        assertEquals(savedDto.getTranscription(), responseBody.getTranscription());
        assertEquals(savedDto.getTranslation(), responseBody.getTranslation());
        assertEquals(savedDto.getExplanation(), responseBody.getExplanation());
        assertEquals(savedDto.getExample(), responseBody.getExample());
        assertEquals(savedDto.getSynonyms(), responseBody.getSynonyms());
    }

}
