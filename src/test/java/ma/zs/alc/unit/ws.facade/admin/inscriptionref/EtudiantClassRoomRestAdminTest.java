package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.service.impl.admin.inscriptionref.EtudiantClassRoomAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.EtudiantClassRoomRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.EtudiantClassRoomConverter;
import ma.zs.alc.ws.dto.inscriptionref.EtudiantClassRoomDto;
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
public class EtudiantClassRoomRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private EtudiantClassRoomAdminServiceImpl service;
    @Mock
    private EtudiantClassRoomConverter converter;

    @InjectMocks
    private EtudiantClassRoomRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllEtudiantClassRoomTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<EtudiantClassRoomDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<EtudiantClassRoomDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveEtudiantClassRoomTest() throws Exception {
        // Mock data
        EtudiantClassRoomDto requestDto = new EtudiantClassRoomDto();
        EtudiantClassRoom entity = new EtudiantClassRoom();
        EtudiantClassRoom saved = new EtudiantClassRoom();
        EtudiantClassRoomDto savedDto = new EtudiantClassRoomDto();

        // Mock the converter to return the etudiantClassRoom object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved etudiantClassRoom DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<EtudiantClassRoomDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        EtudiantClassRoomDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved etudiantClassRoom DTO
    }

}
