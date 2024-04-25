package ma.zs.alc.unit.service.impl.admin.vocab;

import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.dao.facade.core.vocab.VocabularyQuizDao;
import ma.zs.alc.service.impl.admin.vocab.VocabularyQuizAdminServiceImpl;

import ma.zs.alc.bean.core.vocab.Vocabulary ;
import ma.zs.alc.bean.core.vocab.VocabularyQuiz ;
import ma.zs.alc.bean.core.course.Section ;
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
class VocabularyQuizAdminServiceImplTest {

    @Mock
    private VocabularyQuizDao repository;
    private AutoCloseable autoCloseable;
    private VocabularyQuizAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new VocabularyQuizAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllVocabularyQuiz() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveVocabularyQuiz() {
        // Given
        VocabularyQuiz toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteVocabularyQuiz() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetVocabularyQuizById() {
        // Given
        Long idToRetrieve = 1L; // Example VocabularyQuiz ID to retrieve
        VocabularyQuiz expected = new VocabularyQuiz(); // You need to replace VocabularyQuiz with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        VocabularyQuiz result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private VocabularyQuiz constructSample(int i) {
		VocabularyQuiz given = new VocabularyQuiz();
        given.setLibelle("libelle-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        List<Vocabulary> vocabularys = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Vocabulary element = new Vocabulary();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setNumero(2L);
                                                element.setWord("word"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setResult("result"+id);
                                                element.setExplication("explication"+id);
                                                element.setExemple("exemple"+id);
                                                element.setImage("image"+id);
                                                element.setSection(new Section(Long.valueOf(9)));
                                                element.setVocabularyQuiz(new VocabularyQuiz(Long.valueOf(10)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setVocabularys(vocabularys);
        given.setSection(new Section(1L));
        return given;
    }

}
