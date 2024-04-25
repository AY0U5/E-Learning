package ma.zs.alc.unit.ws.facade.admin.faq;

import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.service.impl.admin.faq.FaqProfAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.faq.FaqProfRestAdmin;
import ma.zs.alc.ws.converter.faq.FaqProfConverter;
import ma.zs.alc.ws.dto.faq.FaqProfDto;
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
public class FaqProfRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private FaqProfAdminServiceImpl service;
    @Mock
    private FaqProfConverter converter;

    @InjectMocks
    private FaqProfRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllFaqProfTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<FaqProfDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<FaqProfDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSaveFaqProfTest() throws Exception {
        // Mock data
        FaqProfDto requestDto = new FaqProfDto();
        FaqProf entity = new FaqProf();
        FaqProf saved = new FaqProf();
        FaqProfDto savedDto = new FaqProfDto();

        // Mock the converter to return the faqProf object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved faqProf DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<FaqProfDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        FaqProfDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved faqProf DTO
        assertEquals(savedDto.getDescription(), responseBody.getDescription());
        assertEquals(savedDto.getLibelle(), responseBody.getLibelle());
    }

}
