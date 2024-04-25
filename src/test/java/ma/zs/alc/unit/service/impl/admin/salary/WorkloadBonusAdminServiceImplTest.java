package ma.zs.alc.unit.service.impl.admin.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.dao.facade.core.salary.WorkloadBonusDao;
import ma.zs.alc.service.impl.admin.salary.WorkloadBonusAdminServiceImpl;

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
class WorkloadBonusAdminServiceImplTest {

    @Mock
    private WorkloadBonusDao repository;
    private AutoCloseable autoCloseable;
    private WorkloadBonusAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new WorkloadBonusAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllWorkloadBonus() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveWorkloadBonus() {
        // Given
        WorkloadBonus toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteWorkloadBonus() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetWorkloadBonusById() {
        // Given
        Long idToRetrieve = 1L; // Example WorkloadBonus ID to retrieve
        WorkloadBonus expected = new WorkloadBonus(); // You need to replace WorkloadBonus with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        WorkloadBonus result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private WorkloadBonus constructSample(int i) {
		WorkloadBonus given = new WorkloadBonus();
        given.setCode("code-"+i);
        given.setNombreSession(i);
        given.setPrix(BigDecimal.TEN);
        return given;
    }

}
