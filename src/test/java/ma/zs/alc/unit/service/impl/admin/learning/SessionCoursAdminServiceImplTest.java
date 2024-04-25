package ma.zs.alc.unit.service.impl.admin.learning;

import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.dao.facade.core.learning.SessionCoursDao;
import ma.zs.alc.service.impl.admin.learning.SessionCoursAdminServiceImpl;

import ma.zs.alc.bean.core.salary.Salary ;
import ma.zs.alc.bean.core.learning.SessionCours ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.learning.SessionCoursSection ;
import ma.zs.alc.bean.core.course.Section ;
import ma.zs.alc.bean.core.course.Cours ;
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
class SessionCoursAdminServiceImplTest {

    @Mock
    private SessionCoursDao repository;
    private AutoCloseable autoCloseable;
    private SessionCoursAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new SessionCoursAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllSessionCours() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveSessionCours() {
        // Given
        SessionCours toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteSessionCours() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetSessionCoursById() {
        // Given
        Long idToRetrieve = 1L; // Example SessionCours ID to retrieve
        SessionCours expected = new SessionCours(); // You need to replace SessionCours with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        SessionCours result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private SessionCours constructSample(int i) {
		SessionCours given = new SessionCours();
        given.setReference("reference-"+i);
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setGroupeEtudiant(new GroupeEtudiant(1L));
        given.setDuree(BigDecimal.TEN);
        given.setTotalheure(BigDecimal.TEN);
        given.setMois(BigDecimal.TEN);
        given.setAnnee(BigDecimal.TEN);
        given.setDateFin(LocalDateTime.now());
        given.setDateDebut(LocalDateTime.now());
        given.setPayer(false);
        given.setSalary(new Salary(1L));
        List<SessionCoursSection> sessionCoursSections = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                SessionCoursSection element = new SessionCoursSection();
                                                element.setId((long)id);
                                                element.setSessionCours(new SessionCours(Long.valueOf(1)));
                                                element.setSection(new Section(Long.valueOf(2)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setSessionCoursSections(sessionCoursSections);
        return given;
    }

}
