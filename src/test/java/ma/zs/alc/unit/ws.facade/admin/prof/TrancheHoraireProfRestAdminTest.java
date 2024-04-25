package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.service.impl.admin.prof.TrancheHoraireProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.TrancheHoraireProfRestAdmin;
import ma.zs.alc.ws.converter.prof.TrancheHoraireProfConverter;
import ma.zs.alc.ws.dto.prof.TrancheHoraireProfDto;
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
public class TrancheHoraireProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private TrancheHoraireProfAdminServiceImpl service;
    @Mock
    private TrancheHoraireProfConverter converter;

    @InjectMocks
    private TrancheHoraireProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllTrancheHoraireProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<TrancheHoraireProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<TrancheHoraireProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveTrancheHoraireProfTest() throws Exception {
        // Mock data
        TrancheHoraireProfDto requestDto = new TrancheHoraireProfDto();
        TrancheHoraireProf entity = new TrancheHoraireProf();
        TrancheHoraireProf saved = new TrancheHoraireProf();
        TrancheHoraireProfDto savedDto = new TrancheHoraireProfDto();

        // Mock the converter to return the trancheHoraireProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved trancheHoraireProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<TrancheHoraireProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        TrancheHoraireProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved trancheHoraireProf DTO
        assertEquals(savedDto.getStartHour(), responseBody.getStartHour());
        assertEquals(savedDto.getEndHour(), responseBody.getEndHour());
        assertEquals(savedDto.getDay(), responseBody.getDay());
        assertEquals(savedDto.getGroupIndex(), responseBody.getGroupIndex());
        assertEquals(savedDto.getProfsId(), responseBody.getProfsId());
    }

}
