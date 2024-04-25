package ma.zs.alc.unit.service.impl.admin.price;

import ma.zs.alc.bean.core.price.Price;
import ma.zs.alc.dao.facade.core.price.PriceDao;
import ma.zs.alc.service.impl.admin.price.PriceAdminServiceImpl;

import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class PriceAdminServiceImplTest {

    @Mock
    private PriceDao repository;
    private AutoCloseable autoCloseable;
    private PriceAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new PriceAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllPrice() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSavePrice() {
        // Given
        Price toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeletePrice() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetPriceById() {
        // Given
        Long idToRetrieve = 1L; // Example Price ID to retrieve
        Price expected = new Price(); // You need to replace Price with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Price result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Price constructSample(int i) {
		Price given = new Price();
        given.setPrice(BigDecimal.TEN);
        given.setOldPrice(BigDecimal.TEN);
        given.setLib("lib-"+i);
        given.setNreCourse(BigDecimal.TEN);
        given.setNreHours(BigDecimal.TEN);
        given.setNreMonth(BigDecimal.TEN);
        given.setForGroup(false);
        return given;
    }

}
