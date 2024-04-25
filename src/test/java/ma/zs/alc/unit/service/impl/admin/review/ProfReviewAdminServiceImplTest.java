package ma.zs.alc.unit.service.impl.admin.review;

import ma.zs.alc.bean.core.review.ProfReview;
import ma.zs.alc.dao.facade.core.review.ProfReviewDao;
import ma.zs.alc.service.impl.admin.review.ProfReviewAdminServiceImpl;

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
class ProfReviewAdminServiceImplTest {

    @Mock
    private ProfReviewDao repository;
    private AutoCloseable autoCloseable;
    private ProfReviewAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ProfReviewAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllProfReview() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveProfReview() {
        // Given
        ProfReview toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteProfReview() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetProfReviewById() {
        // Given
        Long idToRetrieve = 1L; // Example ProfReview ID to retrieve
        ProfReview expected = new ProfReview(); // You need to replace ProfReview with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ProfReview result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ProfReview constructSample(int i) {
		ProfReview given = new ProfReview();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setReview(i);
        given.setComment("comment-"+i);
        given.setDateReview(LocalDateTime.now());
        return given;
    }

}
