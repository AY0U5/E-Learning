package ma.zs.alc.unit.service.impl.admin.salary;

import ma.zs.alc.bean.core.salary.Salary;
import ma.zs.alc.dao.facade.core.salary.SalaryDao;
import ma.zs.alc.service.impl.admin.salary.SalaryAdminServiceImpl;

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
class SalaryAdminServiceImplTest {

    @Mock
    private SalaryDao repository;
    private AutoCloseable autoCloseable;
    private SalaryAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SalaryAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSalary() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSalary() {
        // Given
        Salary toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSalary() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSalaryById() {
        // Given
        Long idToRetrieve = 1L; // Example Salary ID to retrieve
        Salary expected = new Salary(); // You need to replace Salary with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Salary result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Salary constructSample(int i) {
		Salary given = new Salary();
        given.setCode("code-"+i);
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setNbrSessionMensuel(BigDecimal.TEN);
        given.setPayer(false);
        given.setTotalPayment(BigDecimal.TEN);
        given.setTotalBonusClassAverage(BigDecimal.TEN);
        given.setTotalBonusWorkload(BigDecimal.TEN);
        return given;
    }

}
