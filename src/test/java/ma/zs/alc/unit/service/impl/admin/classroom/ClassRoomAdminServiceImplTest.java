package ma.zs.alc.unit.service.impl.admin.classroom;

import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.dao.facade.core.classroom.ClassRoomDao;
import ma.zs.alc.service.impl.admin.classroom.ClassRoomAdminServiceImpl;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.quiz.QuizClassRoom ;
import ma.zs.alc.bean.core.prof.Prof ;
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
class ClassRoomAdminServiceImplTest {

    @Mock
    private ClassRoomDao repository;
    private AutoCloseable autoCloseable;
    private ClassRoomAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ClassRoomAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllClassRoom() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveClassRoom() {
        // Given
        ClassRoom toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteClassRoom() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetClassRoomById() {
        // Given
        Long idToRetrieve = 1L; // Example ClassRoom ID to retrieve
        ClassRoom expected = new ClassRoom(); // You need to replace ClassRoom with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ClassRoom result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ClassRoom constructSample(int i) {
		ClassRoom given = new ClassRoom();
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setProf(new Prof(1L));
        List<EtudiantClassRoom> etudiantClassRooms = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                EtudiantClassRoom element = new EtudiantClassRoom();
                                                element.setId((long)id);
                                                element.setClassRoom(new ClassRoom(Long.valueOf(1)));
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEtudiantClassRooms(etudiantClassRooms);
        List<QuizClassRoom> quizClassRooms = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                QuizClassRoom element = new QuizClassRoom();
                                                element.setId((long)id);
                                                element.setClassRoom(new ClassRoom(Long.valueOf(1)));
                                                element.setQuiz(new Quiz(Long.valueOf(2)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setQuizClassRooms(quizClassRooms);
        return given;
    }

}
