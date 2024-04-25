package ma.zs.alc.unit.service.impl.admin.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.dao.facade.core.quizetudiant.ReponseEtudiantDao;
import ma.zs.alc.service.impl.admin.quizetudiant.ReponseEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.bean.core.quiz.Question ;
import ma.zs.alc.bean.core.quiz.Reponse ;
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
class ReponseEtudiantAdminServiceImplTest {

    @Mock
    private ReponseEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private ReponseEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReponseEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReponseEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReponseEtudiant() {
        // Given
        ReponseEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReponseEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReponseEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example ReponseEtudiant ID to retrieve
        ReponseEtudiant expected = new ReponseEtudiant(); // You need to replace ReponseEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ReponseEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ReponseEtudiant constructSample(int i) {
		ReponseEtudiant given = new ReponseEtudiant();
        given.setRef("ref-"+i);
        given.setReponse(new Reponse(1L));
        given.setAnswer("answer-"+i);
        given.setQuizEtudiant(new QuizEtudiant(1L));
        given.setNote(BigDecimal.TEN);
        given.setQuestion(new Question(1L));
        return given;
    }

}
