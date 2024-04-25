package ma.zs.alc.unit.ws.facade.admin.courseref;

import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.service.impl.admin.courseref.CentreAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.courseref.CentreRestAdmin;
import ma.zs.alc.ws.converter.courseref.CentreConverter;
import ma.zs.alc.ws.dto.courseref.CentreDto;
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
public class CentreRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private CentreAdminServiceImpl service;
    @Mock
    private CentreConverter converter;

    @InjectMocks
    private CentreRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllCentreTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<CentreDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<CentreDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveCentreTest() throws Exception {
        // Mock data
        CentreDto requestDto = new CentreDto();
        Centre entity = new Centre();
        Centre saved = new Centre();
        CentreDto savedDto = new CentreDto();

        // Mock the converter to return the centre object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved centre DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<CentreDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        CentreDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved centre DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getLog(), responseBody.getLog());
        assertEquals(savedDto.getPassword(), responseBody.getPassword());
    }

}
