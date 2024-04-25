package ma.zs.alc.unit.service.impl.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationEtudiantDao;
import ma.zs.alc.service.impl.admin.recomrecla.ReclamationEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant ;
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
class ReclamationEtudiantAdminServiceImplTest {

    @Mock
    private ReclamationEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private ReclamationEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReclamationEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReclamationEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReclamationEtudiant() {
        // Given
        ReclamationEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReclamationEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReclamationEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example ReclamationEtudiant ID to retrieve
        ReclamationEtudiant expected = new ReclamationEtudiant(); // You need to replace ReclamationEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ReclamationEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ReclamationEtudiant constructSample(int i) {
		ReclamationEtudiant given = new ReclamationEtudiant();
        given.setReference("reference-"+i);
        given.setDateReclamation(LocalDateTime.now());
        given.setMessage("message-"+i);
        given.setSetFrom("setFrom-"+i);
        given.setImg("img-"+i);
        given.setTraite(false);
        given.setDateTraitement(LocalDateTime.now());
        given.setDateReponse(LocalDateTime.now());
        given.setPostView(false);
        given.setObjetReclamationEtudiant("objetReclamationEtudiant-"+i);
        given.setCommentaireTraiteur("commentaireTraiteur-"+i);
        given.setUsername("username-"+i);
        given.setTypeReclamationEtudiant(new TypeReclamationEtudiant(1L));
        return given;
    }

}
