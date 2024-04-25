package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import ma.zs.alc.dao.facade.core.freetrial.StatutFreeTrialDao;
import ma.zs.alc.service.impl.admin.freetrial.StatutFreeTrialAdminServiceImpl;

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
class StatutFreeTrialAdminServiceImplTest {

    @Mock
    private StatutFreeTrialDao repository;
    private AutoCloseable autoCloseable;
    private StatutFreeTrialAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new StatutFreeTrialAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllStatutFreeTrial() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveStatutFreeTrial() {
        // Given
        StatutFreeTrial toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteStatutFreeTrial() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetStatutFreeTrialById() {
        // Given
        Long idToRetrieve = 1L; // Example StatutFreeTrial ID to retrieve
        StatutFreeTrial expected = new StatutFreeTrial(); // You need to replace StatutFreeTrial with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        StatutFreeTrial result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private StatutFreeTrial constructSample(int i) {
		StatutFreeTrial given = new StatutFreeTrial();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        given.setStyle("style-"+i);
        return given;
    }

}
