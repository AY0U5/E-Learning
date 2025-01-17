package ma.zs.alc.unit.service.impl.admin.quiz;

import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.dao.facade.core.quiz.ReponseDao;
import ma.zs.alc.service.impl.admin.quiz.ReponseAdminServiceImpl;

import ma.zs.alc.bean.core.quiz.Question ;
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
class ReponseAdminServiceImplTest {

    @Mock
    private ReponseDao repository;
    private AutoCloseable autoCloseable;
    private ReponseAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReponseAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReponse() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReponse() {
        // Given
        Reponse toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReponse() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReponseById() {
        // Given
        Long idToRetrieve = 1L; // Example Reponse ID to retrieve
        Reponse expected = new Reponse(); // You need to replace Reponse with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Reponse result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Reponse constructSample(int i) {
		Reponse given = new Reponse();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setEtatReponse("etatReponse-"+i);
        given.setNumero(i*1L);
        given.setQuestion(new Question(1L));
        return given;
    }

}
