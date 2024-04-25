package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.dao.facade.core.homework.ReponseEtudiantHomeWorkDao;
import ma.zs.alc.service.impl.admin.homework.ReponseEtudiantHomeWorkAdminServiceImpl;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse ;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant ;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;
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
class ReponseEtudiantHomeWorkAdminServiceImplTest {

    @Mock
    private ReponseEtudiantHomeWorkDao repository;
    private AutoCloseable autoCloseable;
    private ReponseEtudiantHomeWorkAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReponseEtudiantHomeWorkAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReponseEtudiantHomeWork() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReponseEtudiantHomeWork() {
        // Given
        ReponseEtudiantHomeWork toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReponseEtudiantHomeWork() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReponseEtudiantHomeWorkById() {
        // Given
        Long idToRetrieve = 1L; // Example ReponseEtudiantHomeWork ID to retrieve
        ReponseEtudiantHomeWork expected = new ReponseEtudiantHomeWork(); // You need to replace ReponseEtudiantHomeWork with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ReponseEtudiantHomeWork result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ReponseEtudiantHomeWork constructSample(int i) {
		ReponseEtudiantHomeWork given = new ReponseEtudiantHomeWork();
        given.setHoweWorkQSTReponse(new HoweWorkQSTReponse(1L));
        given.setAnswer("answer-"+i);
        given.setHomeWorkEtudiant(new HomeWorkEtudiant(1L));
        given.setHomeWorkQuestion(new HomeWorkQuestion(1L));
        given.setProfNote("profNote-"+i);
        given.setNote(BigDecimal.TEN);
        return given;
    }

}
