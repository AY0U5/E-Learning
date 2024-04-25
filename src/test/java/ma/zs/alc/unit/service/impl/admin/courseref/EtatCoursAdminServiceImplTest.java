package ma.zs.alc.unit.service.impl.admin.courseref;

import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.facade.core.courseref.EtatCoursDao;
import ma.zs.alc.service.impl.admin.courseref.EtatCoursAdminServiceImpl;

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
class EtatCoursAdminServiceImplTest {

    @Mock
    private EtatCoursDao repository;
    private AutoCloseable autoCloseable;
    private EtatCoursAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtatCoursAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtatCours() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtatCours() {
        // Given
        EtatCours toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtatCours() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtatCoursById() {
        // Given
        Long idToRetrieve = 1L; // Example EtatCours ID to retrieve
        EtatCours expected = new EtatCours(); // You need to replace EtatCours with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtatCours result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtatCours constructSample(int i) {
		EtatCours given = new EtatCours();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
