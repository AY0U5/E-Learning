package ma.zs.alc.unit.service.impl.admin.profetudiantcours;

import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.dao.facade.core.profetudiantcours.EtudiantCoursDao;
import ma.zs.alc.service.impl.admin.profetudiantcours.EtudiantCoursAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.course.Cours ;
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
class EtudiantCoursAdminServiceImplTest {

    @Mock
    private EtudiantCoursDao repository;
    private AutoCloseable autoCloseable;
    private EtudiantCoursAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtudiantCoursAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtudiantCours() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtudiantCours() {
        // Given
        EtudiantCours toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtudiantCours() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtudiantCoursById() {
        // Given
        Long idToRetrieve = 1L; // Example EtudiantCours ID to retrieve
        EtudiantCours expected = new EtudiantCours(); // You need to replace EtudiantCours with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtudiantCours result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtudiantCours constructSample(int i) {
		EtudiantCours given = new EtudiantCours();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setPayer(false);
        given.setDateFin(LocalDateTime.now());
        return given;
    }

}
