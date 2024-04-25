package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.dao.facade.core.inscriptionref.NiveauEtudeDao;
import ma.zs.alc.service.impl.admin.inscriptionref.NiveauEtudeAdminServiceImpl;

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
class NiveauEtudeAdminServiceImplTest {

    @Mock
    private NiveauEtudeDao repository;
    private AutoCloseable autoCloseable;
    private NiveauEtudeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new NiveauEtudeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllNiveauEtude() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveNiveauEtude() {
        // Given
        NiveauEtude toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteNiveauEtude() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetNiveauEtudeById() {
        // Given
        Long idToRetrieve = 1L; // Example NiveauEtude ID to retrieve
        NiveauEtude expected = new NiveauEtude(); // You need to replace NiveauEtude with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        NiveauEtude result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private NiveauEtude constructSample(int i) {
		NiveauEtude given = new NiveauEtude();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
