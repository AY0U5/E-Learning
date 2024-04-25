package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.ConfirmationToken;
import ma.zs.alc.service.impl.admin.inscriptionref.ConfirmationTokenAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.ConfirmationTokenRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.ConfirmationTokenConverter;
import ma.zs.alc.ws.dto.inscriptionref.ConfirmationTokenDto;
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
public class ConfirmationTokenRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ConfirmationTokenAdminServiceImpl service;
    @Mock
    private ConfirmationTokenConverter converter;

    @InjectMocks
    private ConfirmationTokenRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllConfirmationTokenTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ConfirmationTokenDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ConfirmationTokenDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveConfirmationTokenTest() throws Exception {
        // Mock data
        ConfirmationTokenDto requestDto = new ConfirmationTokenDto();
        ConfirmationToken entity = new ConfirmationToken();
        ConfirmationToken saved = new ConfirmationToken();
        ConfirmationTokenDto savedDto = new ConfirmationTokenDto();

        // Mock the converter to return the confirmationToken object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved confirmationToken DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ConfirmationTokenDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ConfirmationTokenDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved confirmationToken DTO
        assertEquals(savedDto.getToken(), responseBody.getToken());
        assertEquals(savedDto.getExpiresAt(), responseBody.getExpiresAt());
        assertEquals(savedDto.getCreatedAt(), responseBody.getCreatedAt());
        assertEquals(savedDto.getConfirmedAt(), responseBody.getConfirmedAt());
    }

}
