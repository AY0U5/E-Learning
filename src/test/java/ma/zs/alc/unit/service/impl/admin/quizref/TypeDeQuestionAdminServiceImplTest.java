package ma.zs.alc.unit.service.impl.admin.quizref;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.dao.facade.core.quizref.TypeDeQuestionDao;
import ma.zs.alc.service.impl.admin.quizref.TypeDeQuestionAdminServiceImpl;

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
class TypeDeQuestionAdminServiceImplTest {

    @Mock
    private TypeDeQuestionDao repository;
    private AutoCloseable autoCloseable;
    private TypeDeQuestionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new TypeDeQuestionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllTypeDeQuestion() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveTypeDeQuestion() {
        // Given
        TypeDeQuestion toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteTypeDeQuestion() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetTypeDeQuestionById() {
        // Given
        Long idToRetrieve = 1L; // Example TypeDeQuestion ID to retrieve
        TypeDeQuestion expected = new TypeDeQuestion(); // You need to replace TypeDeQuestion with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        TypeDeQuestion result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private TypeDeQuestion constructSample(int i) {
		TypeDeQuestion given = new TypeDeQuestion();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        return given;
    }

}
