package ma.zs.alc.unit.service.impl.admin.vocab;

import ma.zs.alc.bean.core.vocab.Vocabulary;
import ma.zs.alc.dao.facade.core.vocab.VocabularyDao;
import ma.zs.alc.service.impl.admin.vocab.VocabularyAdminServiceImpl;

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
class VocabularyAdminServiceImplTest {

    @Mock
    private VocabularyDao repository;
    private AutoCloseable autoCloseable;
    private VocabularyAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new VocabularyAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllVocabulary() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveVocabulary() {
        // Given
        Vocabulary toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteVocabulary() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetVocabularyById() {
        // Given
        Long idToRetrieve = 1L; // Example Vocabulary ID to retrieve
        Vocabulary expected = new Vocabulary(); // You need to replace Vocabulary with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Vocabulary result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Vocabulary constructSample(int i) {
		Vocabulary given = new Vocabulary();
        given.setRef("ref-"+i);
        given.setNumero(i*1L);
        given.setWord("word-"+i);
        given.setLibelle("libelle-"+i);
        given.setResult("result-"+i);
        given.setExplication("explication-"+i);
        given.setExemple("exemple-"+i);
        given.setImage("image-"+i);
        given.setSection(new Section(1L));
        given.setVocabularyQuiz(new VocabularyQuiz(1L));
        return given;
    }

}
