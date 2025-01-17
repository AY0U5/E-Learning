package ma.zs.alc.unit.ws.facade.admin.alc;

import ma.zs.alc.bean.core.alc.Admin;
import ma.zs.alc.service.impl.admin.alc.AdminAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.alc.AdminRestAdmin;
import ma.zs.alc.ws.converter.alc.AdminConverter;
import ma.zs.alc.ws.dto.alc.AdminDto;
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
public class AdminRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private AdminAdminServiceImpl service;
    @Mock
    private AdminConverter converter;

    @InjectMocks
    private AdminRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllAdminTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<AdminDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<AdminDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveAdminTest() throws Exception {
        // Mock data
        AdminDto requestDto = new AdminDto();
        Admin entity = new Admin();
        Admin saved = new Admin();
        AdminDto savedDto = new AdminDto();

        // Mock the converter to return the admin object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved admin DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<AdminDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        AdminDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved admin DTO
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getCredentialsNonExpired(), responseBody.getCredentialsNonExpired());
        assertEquals(savedDto.getEnabled(), responseBody.getEnabled());
        assertEquals(savedDto.getAccountNonExpired(), responseBody.getAccountNonExpired());
        assertEquals(savedDto.getAccountNonLocked(), responseBody.getAccountNonLocked());
        assertEquals(savedDto.getPasswordChanged(), responseBody.getPasswordChanged());
        assertEquals(savedDto.getUsername(), responseBody.getUsername());
        assertEquals(savedDto.getPassword(), responseBody.getPassword());
    }

}
