package ma.zs.alc.unit.ws.facade.admin.common;

import ma.zs.alc.bean.core.common.News;
import ma.zs.alc.service.impl.admin.common.NewsAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.common.NewsRestAdmin;
import ma.zs.alc.ws.converter.common.NewsConverter;
import ma.zs.alc.ws.dto.common.NewsDto;
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
public class NewsRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private NewsAdminServiceImpl service;
    @Mock
    private NewsConverter converter;

    @InjectMocks
    private NewsRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllNewsTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<NewsDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<NewsDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveNewsTest() throws Exception {
        // Mock data
        NewsDto requestDto = new NewsDto();
        News entity = new News();
        News saved = new News();
        NewsDto savedDto = new NewsDto();

        // Mock the converter to return the news object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved news DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<NewsDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        NewsDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved news DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getImage(), responseBody.getImage());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getDateNews(), responseBody.getDateNews());
        assertEquals(savedDto.getDateDebut(), responseBody.getDateDebut());
        assertEquals(savedDto.getDateFin(), responseBody.getDateFin());
        assertEquals(savedDto.getNumeroOrdre(), responseBody.getNumeroOrdre());
        assertEquals(savedDto.getDestinataire(), responseBody.getDestinataire());
    }

}
