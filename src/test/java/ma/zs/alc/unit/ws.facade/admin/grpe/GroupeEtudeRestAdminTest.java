package ma.zs.alc.unit.ws.facade.admin.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.service.impl.admin.grpe.GroupeEtudeAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.grpe.GroupeEtudeRestAdmin;
import ma.zs.alc.ws.converter.grpe.GroupeEtudeConverter;
import ma.zs.alc.ws.dto.grpe.GroupeEtudeDto;
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
public class GroupeEtudeRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private GroupeEtudeAdminServiceImpl service;
    @Mock
    private GroupeEtudeConverter converter;

    @InjectMocks
    private GroupeEtudeRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllGroupeEtudeTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<GroupeEtudeDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<GroupeEtudeDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveGroupeEtudeTest() throws Exception {
        // Mock data
        GroupeEtudeDto requestDto = new GroupeEtudeDto();
        GroupeEtude entity = new GroupeEtude();
        GroupeEtude saved = new GroupeEtude();
        GroupeEtudeDto savedDto = new GroupeEtudeDto();

        // Mock the converter to return the groupeEtude object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved groupeEtude DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<GroupeEtudeDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        GroupeEtudeDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved groupeEtude DTO
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getNombreEtudiant(), responseBody.getNombreEtudiant());
    }

}
