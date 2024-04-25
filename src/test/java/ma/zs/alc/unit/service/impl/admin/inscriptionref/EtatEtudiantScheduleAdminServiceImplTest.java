package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule;
import ma.zs.alc.dao.facade.core.inscriptionref.EtatEtudiantScheduleDao;
import ma.zs.alc.service.impl.admin.inscriptionref.EtatEtudiantScheduleAdminServiceImpl;

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
class EtatEtudiantScheduleAdminServiceImplTest {

    @Mock
    private EtatEtudiantScheduleDao repository;
    private AutoCloseable autoCloseable;
    private EtatEtudiantScheduleAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtatEtudiantScheduleAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtatEtudiantSchedule() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtatEtudiantSchedule() {
        // Given
        EtatEtudiantSchedule toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtatEtudiantSchedule() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtatEtudiantScheduleById() {
        // Given
        Long idToRetrieve = 1L; // Example EtatEtudiantSchedule ID to retrieve
        EtatEtudiantSchedule expected = new EtatEtudiantSchedule(); // You need to replace EtatEtudiantSchedule with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtatEtudiantSchedule result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtatEtudiantSchedule constructSample(int i) {
		EtatEtudiantSchedule given = new EtatEtudiantSchedule();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setCouleur("couleur-"+i);
        return given;
    }

}
