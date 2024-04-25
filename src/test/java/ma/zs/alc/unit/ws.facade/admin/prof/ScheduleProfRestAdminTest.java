package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.ScheduleProf;
import ma.zs.alc.service.impl.admin.prof.ScheduleProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.ScheduleProfRestAdmin;
import ma.zs.alc.ws.converter.prof.ScheduleProfConverter;
import ma.zs.alc.ws.dto.prof.ScheduleProfDto;
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
public class ScheduleProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ScheduleProfAdminServiceImpl service;
    @Mock
    private ScheduleProfConverter converter;

    @InjectMocks
    private ScheduleProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllScheduleProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ScheduleProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ScheduleProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveScheduleProfTest() throws Exception {
        // Mock data
        ScheduleProfDto requestDto = new ScheduleProfDto();
        ScheduleProf entity = new ScheduleProf();
        ScheduleProf saved = new ScheduleProf();
        ScheduleProfDto savedDto = new ScheduleProfDto();

        // Mock the converter to return the scheduleProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved scheduleProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ScheduleProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ScheduleProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved scheduleProf DTO
        assertEquals(savedDto.getSubject(), responseBody.getSubject());
        assertEquals(savedDto.getStartTime(), responseBody.getStartTime());
        assertEquals(savedDto.getEndTime(), responseBody.getEndTime());
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getGrpName(), responseBody.getGrpName());
        assertEquals(savedDto.getProfName(), responseBody.getProfName());
        assertEquals(savedDto.getProfsId(), responseBody.getProfsId());
    }

}
