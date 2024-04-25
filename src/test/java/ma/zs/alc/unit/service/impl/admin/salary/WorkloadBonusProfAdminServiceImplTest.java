package ma.zs.alc.unit.service.impl.admin.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.dao.facade.core.salary.WorkloadBonusProfDao;
import ma.zs.alc.service.impl.admin.salary.WorkloadBonusProfAdminServiceImpl;

import ma.zs.alc.bean.core.salary.Salary ;
import ma.zs.alc.bean.core.salary.WorkloadBonus ;
import ma.zs.alc.bean.core.prof.Prof ;
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
class WorkloadBonusProfAdminServiceImplTest {

    @Mock
    private WorkloadBonusProfDao repository;
    private AutoCloseable autoCloseable;
    private WorkloadBonusProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new WorkloadBonusProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllWorkloadBonusProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveWorkloadBonusProf() {
        // Given
        WorkloadBonusProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteWorkloadBonusProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetWorkloadBonusProfById() {
        // Given
        Long idToRetrieve = 1L; // Example WorkloadBonusProf ID to retrieve
        WorkloadBonusProf expected = new WorkloadBonusProf(); // You need to replace WorkloadBonusProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        WorkloadBonusProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private WorkloadBonusProf constructSample(int i) {
		WorkloadBonusProf given = new WorkloadBonusProf();
        given.setWorkloadBonus(new WorkloadBonus(1L));
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setSalary(new Salary(1L));
        return given;
    }

}
