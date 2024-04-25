package ma.zs.alc.unit.ws.facade.admin.homework;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.service.impl.admin.homework.HoweWorkQSTReponseAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.homework.HoweWorkQSTReponseRestAdmin;
import ma.zs.alc.ws.converter.homework.HoweWorkQSTReponseConverter;
import ma.zs.alc.ws.dto.homework.HoweWorkQSTReponseDto;
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
public class HoweWorkQSTReponseRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private HoweWorkQSTReponseAdminServiceImpl service;
    @Mock
    private HoweWorkQSTReponseConverter converter;

    @InjectMocks
    private HoweWorkQSTReponseRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllHoweWorkQSTReponseTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<HoweWorkQSTReponseDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<HoweWorkQSTReponseDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveHoweWorkQSTReponseTest() throws Exception {
        // Mock data
        HoweWorkQSTReponseDto requestDto = new HoweWorkQSTReponseDto();
        HoweWorkQSTReponse entity = new HoweWorkQSTReponse();
        HoweWorkQSTReponse saved = new HoweWorkQSTReponse();
        HoweWorkQSTReponseDto savedDto = new HoweWorkQSTReponseDto();

        // Mock the converter to return the howeWorkQSTReponse object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved howeWorkQSTReponse DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<HoweWorkQSTReponseDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        HoweWorkQSTReponseDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved howeWorkQSTReponse DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getLib(), responseBody.getLib());
        assertEquals(savedDto.getEtatReponse(), responseBody.getEtatReponse());
        assertEquals(savedDto.getNumero(), responseBody.getNumero());
    }

}
