package ma.zs.alc.unit.service.impl.admin.common;

import ma.zs.alc.bean.core.common.ClassAverageBonus;
import ma.zs.alc.dao.facade.core.common.ClassAverageBonusDao;
import ma.zs.alc.service.impl.admin.common.ClassAverageBonusAdminServiceImpl;

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
class ClassAverageBonusAdminServiceImplTest {

    @Mock
    private ClassAverageBonusDao repository;
    private AutoCloseable autoCloseable;
    private ClassAverageBonusAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClassAverageBonusAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllClassAverageBonus() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveClassAverageBonus() {
        // Given
        ClassAverageBonus toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteClassAverageBonus() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetClassAverageBonusById() {
        // Given
        Long idToRetrieve = 1L; // Example ClassAverageBonus ID to retrieve
        ClassAverageBonus expected = new ClassAverageBonus(); // You need to replace ClassAverageBonus with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ClassAverageBonus result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ClassAverageBonus constructSample(int i) {
		ClassAverageBonus given = new ClassAverageBonus();
        given.setCode("code-"+i);
        given.setNombreSession(i);
        given.setPrix(BigDecimal.TEN);
        return given;
    }

}
