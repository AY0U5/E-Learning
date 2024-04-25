package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.dao.facade.core.homework.HomeWorkQuestionDao;
import ma.zs.alc.service.impl.admin.homework.HomeWorkQuestionAdminServiceImpl;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse ;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;
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
class HomeWorkQuestionAdminServiceImplTest {

    @Mock
    private HomeWorkQuestionDao repository;
    private AutoCloseable autoCloseable;
    private HomeWorkQuestionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new HomeWorkQuestionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllHomeWorkQuestion() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveHomeWorkQuestion() {
        // Given
        HomeWorkQuestion toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteHomeWorkQuestion() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetHomeWorkQuestionById() {
        // Given
        Long idToRetrieve = 1L; // Example HomeWorkQuestion ID to retrieve
        HomeWorkQuestion expected = new HomeWorkQuestion(); // You need to replace HomeWorkQuestion with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        HomeWorkQuestion result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private HomeWorkQuestion constructSample(int i) {
		HomeWorkQuestion given = new HomeWorkQuestion();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setNumero(i);
        given.setPointReponseJuste(BigDecimal.TEN);
        given.setPointReponsefausse(BigDecimal.TEN);
        given.setTypeDeQuestion(new TypeDeQuestion(1L));
        List<HoweWorkQSTReponse> howeWorkQSTReponses = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                HoweWorkQSTReponse element = new HoweWorkQSTReponse();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setLib("lib"+id);
                                                element.setEtatReponse("etatReponse"+id);
                                                element.setNumero(4);
                                                element.setHomeWorkQuestion(new HomeWorkQuestion(Long.valueOf(5)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setHoweWorkQSTReponses(howeWorkQSTReponses);
        given.setHomeWork(new HomeWork(1L));
        return given;
    }

}
