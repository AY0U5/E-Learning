package ma.zs.alc.unit.ws.facade.admin.prof;

import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.service.impl.admin.prof.ProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.prof.ProfRestAdmin;
import ma.zs.alc.ws.converter.prof.ProfConverter;
import ma.zs.alc.ws.dto.prof.ProfDto;
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
public class ProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private ProfAdminServiceImpl service;
    @Mock
    private ProfConverter converter;

    @InjectMocks
    private ProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<ProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<ProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveProfTest() throws Exception {
        // Mock data
        ProfDto requestDto = new ProfDto();
        Prof entity = new Prof();
        Prof saved = new Prof();
        ProfDto savedDto = new ProfDto();

        // Mock the converter to return the prof object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved prof DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<ProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        ProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved prof DTO
        assertEquals(savedDto.getRef(), responseBody.getRef());
        assertEquals(savedDto.getAbout(), responseBody.getAbout());
        assertEquals(savedDto.getCredentialsNonExpired(), responseBody.getCredentialsNonExpired());
        assertEquals(savedDto.getEnabled(), responseBody.getEnabled());
        assertEquals(savedDto.getAccountNonExpired(), responseBody.getAccountNonExpired());
        assertEquals(savedDto.getAccountNonLocked(), responseBody.getAccountNonLocked());
        assertEquals(savedDto.getPasswordChanged(), responseBody.getPasswordChanged());
        assertEquals(savedDto.getUsername(), responseBody.getUsername());
        assertEquals(savedDto.getPassword(), responseBody.getPassword());
    }

}
