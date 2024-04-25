package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import ma.zs.alc.dao.facade.core.prof.ClassAverageBonusProfDao;
import ma.zs.alc.service.impl.admin.prof.ClassAverageBonusProfAdminServiceImpl;

import ma.zs.alc.bean.core.salary.Salary ;
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
class ClassAverageBonusProfAdminServiceImplTest {

    @Mock
    private ClassAverageBonusProfDao repository;
    private AutoCloseable autoCloseable;
    private ClassAverageBonusProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClassAverageBonusProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllClassAverageBonusProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveClassAverageBonusProf() {
        // Given
        ClassAverageBonusProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteClassAverageBonusProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetClassAverageBonusProfById() {
        // Given
        Long idToRetrieve = 1L; // Example ClassAverageBonusProf ID to retrieve
        ClassAverageBonusProf expected = new ClassAverageBonusProf(); // You need to replace ClassAverageBonusProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ClassAverageBonusProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ClassAverageBonusProf constructSample(int i) {
		ClassAverageBonusProf given = new ClassAverageBonusProf();
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setSalary(new Salary(1L));
        return given;
    }

}
