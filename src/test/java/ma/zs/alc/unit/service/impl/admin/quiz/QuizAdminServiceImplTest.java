package ma.zs.alc.unit.service.impl.admin.quiz;

import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.dao.facade.core.quiz.QuizDao;
import ma.zs.alc.service.impl.admin.quiz.QuizAdminServiceImpl;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.quiz.Question ;
import ma.zs.alc.bean.core.course.Section ;
import ma.zs.alc.bean.core.homework.HomeWork ;
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
class QuizAdminServiceImplTest {

    @Mock
    private QuizDao repository;
    private AutoCloseable autoCloseable;
    private QuizAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new QuizAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllQuiz() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveQuiz() {
        // Given
        Quiz toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteQuiz() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetQuizById() {
        // Given
        Long idToRetrieve = 1L; // Example Quiz ID to retrieve
        Quiz expected = new Quiz(); // You need to replace Quiz with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Quiz result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Quiz constructSample(int i) {
		Quiz given = new Quiz();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        List<Question> questions = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Question element = new Question();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setUrlImg("urlImg"+id);
                                                element.setUrlVideo("urlVideo"+id);
                                                element.setNumero(5L);
                                                element.setPointReponseJuste(new BigDecimal(6*10));
                                                element.setPointReponsefausse(new BigDecimal(7*10));
                                                element.setTypeDeQuestion(new TypeDeQuestion(Long.valueOf(8)));
                                                element.setQuiz(new Quiz(Long.valueOf(10)));
                                                element.setHomeWork(new HomeWork(Long.valueOf(11)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setQuestions(questions);
        List<QuizEtudiant> quizEtudiants = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                QuizEtudiant element = new QuizEtudiant();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                element.setQuiz(new Quiz(Long.valueOf(3)));
                                                element.setNote(new BigDecimal(5*10));
                                                element.setResultat("resultat"+id);
                                                element.setQuestionCurrent(7L);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setQuizEtudiants(quizEtudiants);
        given.setSection(new Section(1L));
        given.setNumero(i*1L);
        given.setSeuilReussite(i*1L);
        return given;
    }

}
