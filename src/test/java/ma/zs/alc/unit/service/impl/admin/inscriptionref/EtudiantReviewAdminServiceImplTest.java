package ma.zs.alc.unit.service.impl.admin.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.dao.facade.core.inscriptionref.EtudiantReviewDao;
import ma.zs.alc.service.impl.admin.inscriptionref.EtudiantReviewAdminServiceImpl;

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
class EtudiantReviewAdminServiceImplTest {

    @Mock
    private EtudiantReviewDao repository;
    private AutoCloseable autoCloseable;
    private EtudiantReviewAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtudiantReviewAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtudiantReview() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtudiantReview() {
        // Given
        EtudiantReview toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtudiantReview() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtudiantReviewById() {
        // Given
        Long idToRetrieve = 1L; // Example EtudiantReview ID to retrieve
        EtudiantReview expected = new EtudiantReview(); // You need to replace EtudiantReview with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        EtudiantReview result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private EtudiantReview constructSample(int i) {
		EtudiantReview given = new EtudiantReview();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setReview(i);
        given.setComment("comment-"+i);
        given.setDateReview(LocalDateTime.now());
        return given;
    }

}
