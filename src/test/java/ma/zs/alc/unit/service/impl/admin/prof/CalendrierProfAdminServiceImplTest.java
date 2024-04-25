package ma.zs.alc.unit.service.impl.admin.prof;

import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.dao.facade.core.prof.CalendrierProfDao;
import ma.zs.alc.service.impl.admin.prof.CalendrierProfAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
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
class CalendrierProfAdminServiceImplTest {

    @Mock
    private CalendrierProfDao repository;
    private AutoCloseable autoCloseable;
    private CalendrierProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new CalendrierProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllCalendrierProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveCalendrierProf() {
        // Given
        CalendrierProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteCalendrierProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetCalendrierProfById() {
        // Given
        Long idToRetrieve = 1L; // Example CalendrierProf ID to retrieve
        CalendrierProf expected = new CalendrierProf(); // You need to replace CalendrierProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        CalendrierProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private CalendrierProf constructSample(int i) {
		CalendrierProf given = new CalendrierProf();
        given.setRef("ref-"+i);
        given.setStartTime("startTime-"+i);
        given.setEndTime("endTime-"+i);
        given.setStartRecur(LocalDateTime.now());
        given.setEndRecur(LocalDateTime.now());
        given.setProf(new Prof(1L));
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
