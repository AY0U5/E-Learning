package ma.zs.alc.unit.service.impl.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import ma.zs.alc.dao.facade.core.recomrecla.TypeReclamationEtudiantDao;
import ma.zs.alc.service.impl.admin.recomrecla.TypeReclamationEtudiantAdminServiceImpl;

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
class TypeReclamationEtudiantAdminServiceImplTest {

    @Mock
    private TypeReclamationEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private TypeReclamationEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeReclamationEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeReclamationEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeReclamationEtudiant() {
        // Given
        TypeReclamationEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeReclamationEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeReclamationEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeReclamationEtudiant ID to retrieve
        TypeReclamationEtudiant expected = new TypeReclamationEtudiant(); // You need to replace TypeReclamationEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeReclamationEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeReclamationEtudiant constructSample(int i) {
		TypeReclamationEtudiant given = new TypeReclamationEtudiant();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
