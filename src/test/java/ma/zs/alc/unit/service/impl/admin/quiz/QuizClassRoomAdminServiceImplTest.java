package ma.zs.alc.unit.service.impl.admin.quiz;

import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.dao.facade.core.quiz.QuizClassRoomDao;
import ma.zs.alc.service.impl.admin.quiz.QuizClassRoomAdminServiceImpl;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.classroom.ClassRoom ;
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
class QuizClassRoomAdminServiceImplTest {

    @Mock
    private QuizClassRoomDao repository;
    private AutoCloseable autoCloseable;
    private QuizClassRoomAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new QuizClassRoomAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllQuizClassRoom() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveQuizClassRoom() {
        // Given
        QuizClassRoom toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteQuizClassRoom() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetQuizClassRoomById() {
        // Given
        Long idToRetrieve = 1L; // Example QuizClassRoom ID to retrieve
        QuizClassRoom expected = new QuizClassRoom(); // You need to replace QuizClassRoom with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        QuizClassRoom result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private QuizClassRoom constructSample(int i) {
		QuizClassRoom given = new QuizClassRoom();
        given.setClassRoom(new ClassRoom(1L));
        given.setQuiz(new Quiz(1L));
        return given;
    }

}
