package ma.zs.alc.unit.ws.facade.admin.price;

import ma.zs.alc.bean.core.price.Price;
import ma.zs.alc.service.impl.admin.price.PriceAdminServiceImpl;
import ma.zs.alc.ws.facade.admin.price.PriceRestAdmin;
import ma.zs.alc.ws.converter.price.PriceConverter;
import ma.zs.alc.ws.dto.price.PriceDto;
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
public class PriceRestAdminTest {

    private MockMvc mockMvc;

    @Mock
    private PriceAdminServiceImpl service;
    @Mock
    private PriceConverter converter;

    @InjectMocks
    private PriceRestAdmin controller;

    @Before("")
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }


    @Test
    public void itShouldFindAllPriceTest() throws Exception {
        // Mock the service to return an empty list
        when(service.findAll()).thenReturn(Collections.emptyList());
        when(converter.toDto(Collections.emptyList())).thenReturn(Collections.emptyList());

        // Call the controller method
        ResponseEntity<List<PriceDto>> result = controller.findAll();

        // Verify the result
        assertEquals(HttpStatus.NO_CONTENT, result.getStatusCode());

        // Response body should be empty list
        List<PriceDto> responseBody = result.getBody();
        assertNotNull(responseBody);
        assertEquals(0, responseBody.size());
    }

    @Test
    public void itShouldSavePriceTest() throws Exception {
        // Mock data
        PriceDto requestDto = new PriceDto();
        Price entity = new Price();
        Price saved = new Price();
        PriceDto savedDto = new PriceDto();

        // Mock the converter to return the price object when converting from DTO
        when(converter.toItem(requestDto)).thenReturn(entity);

        // Mock the service to return the saved client
        when(service.create(entity)).thenReturn(saved);

        // Mock the converter to return the saved price DTO
        when(converter.toDto(saved)).thenReturn(savedDto);

        // Call the controller method
        ResponseEntity<PriceDto> result = controller.save(requestDto);

        // Verify the result
        assertEquals(HttpStatus.CREATED, result.getStatusCode());

        // Verify the response body
        PriceDto responseBody = result.getBody();
        assertNotNull(responseBody);

        // Add assertions to compare the response body with the saved price DTO
        assertEquals(savedDto.getPrice(), responseBody.getPrice());
        assertEquals(savedDto.getOldPrice(), responseBody.getOldPrice());
        assertEquals(savedDto.getLib(), responseBody.getLib());
        assertEquals(savedDto.getNreCourse(), responseBody.getNreCourse());
        assertEquals(savedDto.getNreHours(), responseBody.getNreHours());
        assertEquals(savedDto.getNreMonth(), responseBody.getNreMonth());
        assertEquals(savedDto.getForGroup(), responseBody.getForGroup());
    }

}
