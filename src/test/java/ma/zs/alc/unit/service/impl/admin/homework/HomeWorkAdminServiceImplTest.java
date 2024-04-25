package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.dao.facade.core.homework.HomeWorkDao;
import ma.zs.alc.service.impl.admin.homework.HomeWorkAdminServiceImpl;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;
import ma.zs.alc.bean.core.homework.TypeHomeWork ;
import ma.zs.alc.bean.core.course.Cours ;
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
class HomeWorkAdminServiceImplTest {

    @Mock
    private HomeWorkDao repository;
    private AutoCloseable autoCloseable;
    private HomeWorkAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new HomeWorkAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllHomeWork() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveHomeWork() {
        // Given
        HomeWork toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteHomeWork() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetHomeWorkById() {
        // Given
        Long idToRetrieve = 1L; // Example HomeWork ID to retrieve
        HomeWork expected = new HomeWork(); // You need to replace HomeWork with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        HomeWork result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private HomeWork constructSample(int i) {
		HomeWork given = new HomeWork();
        given.setLibelle("libelle-"+i);
        given.setUrlImage("urlImage-"+i);
        given.setUrlVideo("urlVideo-"+i);
        List<HomeWorkQuestion> homeWorkQuestions = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                HomeWorkQuestion element = new HomeWorkQuestion();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setNumero(3);
                                                element.setPointReponseJuste(new BigDecimal(4*10));
                                                element.setPointReponsefausse(new BigDecimal(5*10));
                                                element.setTypeDeQuestion(new TypeDeQuestion(Long.valueOf(6)));
                                                element.setHomeWork(new HomeWork(Long.valueOf(8)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setHomeWorkQuestions(homeWorkQuestions);
        List<HomeWorkEtudiant> homeWorkEtudiants = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                HomeWorkEtudiant element = new HomeWorkEtudiant();
                                                element.setId((long)id);
                                                element.setEtudiant(new Etudiant(Long.valueOf(1)));
                                                element.setHomeWork(new HomeWork(Long.valueOf(2)));
                                                element.setNote(new BigDecimal(4*10));
                                                element.setResultat("resultat"+id);
                                                element.setDateHomeWork(LocalDateTime.now());
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setHomeWorkEtudiants(homeWorkEtudiants);
        given.setCours(new Cours(1L));
        given.setTypeHomeWork(new TypeHomeWork(1L));
        return given;
    }

}
