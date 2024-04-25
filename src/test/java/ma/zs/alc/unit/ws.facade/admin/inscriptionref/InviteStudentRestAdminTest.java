package ma.zs.alc.unit.ws.facade.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.InviteStudent;
import ma.zs.alc.service.impl.admin.inscriptionref.InviteStudentAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.inscriptionref.InviteStudentRestAdmin;
import ma.zs.alc.ws.converter.inscriptionref.InviteStudentConverter;
import ma.zs.alc.ws.dto.inscriptionref.InviteStudentDto;
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
public class InviteStudentRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private InviteStudentAdminServiceImpl service;
    @Mock
    private InviteStudentConverter converter;

    @InjectMocks
    private InviteStudentRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllInviteStudentTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<InviteStudentDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<InviteStudentDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveInviteStudentTest() throws Exception {
        // Mock data
        InviteStudentDto requestDto = new InviteStudentDto();
        InviteStudent entity = new InviteStudent();
        InviteStudent saved = new InviteStudent();
        InviteStudentDto savedDto = new InviteStudentDto();

        // Mock the converter to return the inviteStudent object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved inviteStudent DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<InviteStudentDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        InviteStudentDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved inviteStudent DTO
        assertEquals(savedDto.getCode(), responseBody.getCode());
        assertEquals(savedDto.getIsAccepted(), responseBody.getIsAccepted());
        assertEquals(savedDto.getIsPaidPack(), responseBody.getIsPaidPack());
        assertEquals(savedDto.getEmailInvited(), responseBody.getEmailInvited());
        assertEquals(savedDto.getDateSentInvitation(), responseBody.getDateSentInvitation());
        assertEquals(savedDto.getDateAcceptInvitation(), responseBody.getDateAcceptInvitation());
        assertEquals(savedDto.getDatePayPack(), responseBody.getDatePayPack());
    }

}
