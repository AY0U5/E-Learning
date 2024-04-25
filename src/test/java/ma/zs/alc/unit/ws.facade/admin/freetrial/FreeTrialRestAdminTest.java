package ma.zs.alc.unit.ws.facade.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrial;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.freetrial.FreeTrialRestAdmin;
import ma.zs.alc.ws.converter.freetrial.FreeTrialConverter;
import ma.zs.alc.ws.dto.freetrial.FreeTrialDto;
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
public class FreeTrialRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private FreeTrialAdminServiceImpl service;
    @Mock
    private FreeTrialConverter converter;

    @InjectMocks
    private FreeTrialRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllFreeTrialTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<FreeTrialDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<FreeTrialDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveFreeTrialTest() throws Exception {
        // Mock data
        FreeTrialDto requestDto = new FreeTrialDto();
        FreeTrial entity = new FreeTrial();
        FreeTrial saved = new FreeTrial();
        FreeTrialDto savedDto = new FreeTrialDto();

        // Mock the converter to return the freeTrial object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved freeTrial DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<FreeTrialDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        FreeTrialDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved freeTrial DTO
        assertEquals(savedDto.getReference(), responseBody.getReference());
        assertEquals(savedDto.getDateFreeTrial(), responseBody.getDateFreeTrial());
        assertEquals(savedDto.getLink(), responseBody.getLink());
        assertEquals(savedDto.getEmailTeacherSent(), responseBody.getEmailTeacherSent());
        assertEquals(savedDto.getEmailTeacherSendingDate(), responseBody.getEmailTeacherSendingDate());
        assertEquals(savedDto.getWhatsTeacherSent(), responseBody.getWhatsTeacherSent());
        assertEquals(savedDto.getWhatsTeacherSendingDate(), responseBody.getWhatsTeacherSendingDate());
        assertEquals(savedDto.getDateFreeTrialPremierRappel(), responseBody.getDateFreeTrialPremierRappel());
        assertEquals(savedDto.getDateFreeTrialPremierDeuxiemeRappel(), responseBody.getDateFreeTrialPremierDeuxiemeRappel());
        assertEquals(savedDto.getNombreStudentTotal(), responseBody.getNombreStudentTotal());
        assertEquals(savedDto.getNombreStudentAbonne(), responseBody.getNombreStudentAbonne());
        assertEquals(savedDto.getNombreStudentPresent(), responseBody.getNombreStudentPresent());
    }

}
