package ma.zs.alc.unit.service.impl.admin.inscription;

import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.dao.facade.core.inscription.DictionaryDao;
import ma.zs.alc.service.impl.admin.inscription.DictionaryAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
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
class DictionaryAdminServiceImplTest {

    @Mock
    private DictionaryDao repository;
    private AutoCloseable autoCloseable;
    private DictionaryAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new DictionaryAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllDictionary() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveDictionary() {
        // Given
        Dictionary toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteDictionary() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetDictionaryById() {
        // Given
        Long idToRetrieve = 1L; // Example Dictionary ID to retrieve
        Dictionary expected = new Dictionary(); // You need to replace Dictionary with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Dictionary result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Dictionary constructSample(int i) {
		Dictionary given = new Dictionary();
        given.setWord("word-"+i);
        given.setDefinition("definition-"+i);
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
