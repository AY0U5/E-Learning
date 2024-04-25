package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialConfigurationDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialConfigurationAdminServiceImpl;

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
class FreeTrialConfigurationAdminServiceImplTest {

    @Mock
    private FreeTrialConfigurationDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialConfigurationAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialConfigurationAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialConfiguration() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialConfiguration() {
        // Given
        FreeTrialConfiguration toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialConfiguration() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialConfigurationById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialConfiguration ID to retrieve
        FreeTrialConfiguration expected = new FreeTrialConfiguration(); // You need to replace FreeTrialConfiguration with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialConfiguration result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FreeTrialConfiguration constructSample(int i) {
		FreeTrialConfiguration given = new FreeTrialConfiguration();
        given.setDateApplicationDebut(LocalDateTime.now());
        given.setDateApplicationFin(LocalDateTime.now());
        given.setNombreStudentMax(i);
        given.setNombreStudentMin(i);
        return given;
    }

}
