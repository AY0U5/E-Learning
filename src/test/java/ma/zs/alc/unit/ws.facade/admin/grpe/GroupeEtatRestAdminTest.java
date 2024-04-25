package ma.zs.alc.unit.ws.facade.admin.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtat;
import ma.zs.alc.service.impl.admin.grpe.GroupeEtatAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.grpe.GroupeEtatRestAdmin;
import ma.zs.alc.ws.converter.grpe.GroupeEtatConverter;
import ma.zs.alc.ws.dto.grpe.GroupeEtatDto;
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
public class GroupeEtatRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private GroupeEtatAdminServiceImpl service;
    @Mock
    private GroupeEtatConverter converter;

    @InjectMocks
    private GroupeEtatRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllGroupeEtatTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<GroupeEtatDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<GroupeEtatDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveGroupeEtatTest() throws Exception {
        // Mock data
        GroupeEtatDto requestDto = new GroupeEtatDto();
        GroupeEtat entity = new GroupeEtat();
        GroupeEtat saved = new GroupeEtat();
        GroupeEtatDto savedDto = new GroupeEtatDto();

        // Mock the converter to return the groupeEtat object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved groupeEtat DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<GroupeEtatDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        GroupeEtatDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved groupeEtat DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
