package ma.zs.alc.unit.service.impl.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.dao.facade.core.recomrecla.RecommendTeacherDao;
import ma.zs.alc.service.impl.admin.recomrecla.RecommendTeacherAdminServiceImpl;

import ma.zs.alc.bean.core.prof.Prof ;
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
class RecommendTeacherAdminServiceImplTest {

    @Mock
    private RecommendTeacherDao repository;
    private AutoCloseable autoCloseable;
    private RecommendTeacherAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new RecommendTeacherAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllRecommendTeacher() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveRecommendTeacher() {
        // Given
        RecommendTeacher toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteRecommendTeacher() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetRecommendTeacherById() {
        // Given
        Long idToRetrieve = 1L; // Example RecommendTeacher ID to retrieve
        RecommendTeacher expected = new RecommendTeacher(); // You need to replace RecommendTeacher with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        RecommendTeacher result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private RecommendTeacher constructSample(int i) {
		RecommendTeacher given = new RecommendTeacher();
        given.setRef("ref-"+i);
        given.setNombrevote(i);
        given.setNom("nom-"+i);
        given.setPrenom("prenom-"+i);
        given.setCommentaire("commentaire-"+i);
        given.setTelephone("telephone-"+i);
        given.setLogin("login-"+i);
        given.setDateRecommamdation(LocalDateTime.now());
        given.setProf(new Prof(1L));
        return given;
    }

}
