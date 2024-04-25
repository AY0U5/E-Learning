package ma.zs.alc.unit.service.impl.admin.homework;

import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.dao.facade.core.homework.HomeWorkEtudiantDao;
import ma.zs.alc.service.impl.admin.homework.HomeWorkEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse ;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork ;
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
class HomeWorkEtudiantAdminServiceImplTest {

    @Mock
    private HomeWorkEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private HomeWorkEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new HomeWorkEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllHomeWorkEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveHomeWorkEtudiant() {
        // Given
        HomeWorkEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteHomeWorkEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetHomeWorkEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example HomeWorkEtudiant ID to retrieve
        HomeWorkEtudiant expected = new HomeWorkEtudiant(); // You need to replace HomeWorkEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        HomeWorkEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private HomeWorkEtudiant constructSample(int i) {
		HomeWorkEtudiant given = new HomeWorkEtudiant();
        given.setEtudiant(new Etudiant(1L));
        given.setHomeWork(new HomeWork(1L));
        List<ReponseEtudiantHomeWork> reponseEtudiantHomeWorks = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                ReponseEtudiantHomeWork element = new ReponseEtudiantHomeWork();
                                                element.setId((long)id);
                                                element.setHoweWorkQSTReponse(new HoweWorkQSTReponse(Long.valueOf(1)));
                                                element.setAnswer("answer"+id);
                                                element.setHomeWorkEtudiant(new HomeWorkEtudiant(Long.valueOf(3)));
                                                element.setHomeWorkQuestion(new HomeWorkQuestion(Long.valueOf(4)));
                                                element.setProfNote("profNote"+id);
                                                element.setNote(new BigDecimal(6*10));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setReponseEtudiantHomeWorks(reponseEtudiantHomeWorks);
        given.setNote(BigDecimal.TEN);
        given.setResultat("resultat-"+i);
        given.setDateHomeWork(LocalDateTime.now());
        return given;
    }

}
