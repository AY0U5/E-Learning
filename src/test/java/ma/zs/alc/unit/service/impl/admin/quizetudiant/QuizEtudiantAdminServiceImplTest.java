package ma.zs.alc.unit.service.impl.admin.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.dao.facade.core.quizetudiant.QuizEtudiantDao;
import ma.zs.alc.service.impl.admin.quizetudiant.QuizEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant ;
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
class QuizEtudiantAdminServiceImplTest {

    @Mock
    private QuizEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private QuizEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new QuizEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllQuizEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveQuizEtudiant() {
        // Given
        QuizEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteQuizEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetQuizEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example QuizEtudiant ID to retrieve
        QuizEtudiant expected = new QuizEtudiant(); // You need to replace QuizEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        QuizEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private QuizEtudiant constructSample(int i) {
		QuizEtudiant given = new QuizEtudiant();
        given.setRef("ref-"+i);
        given.setEtudiant(new Etudiant(1L));
        given.setQuiz(new Quiz(1L));
        List<ReponseEtudiant> reponseEtudiants = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                ReponseEtudiant element = new ReponseEtudiant();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setReponse(new Reponse(Long.valueOf(2)));
                                                element.setAnswer("answer"+id);
                                                element.setQuizEtudiant(new QuizEtudiant(Long.valueOf(4)));
                                                element.setNote(new BigDecimal(5*10));
                                                element.setQuestion(new Question(Long.valueOf(6)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setReponseEtudiants(reponseEtudiants);
        given.setNote(BigDecimal.TEN);
        given.setResultat("resultat-"+i);
        given.setQuestionCurrent(i*1L);
        return given;
    }

}
