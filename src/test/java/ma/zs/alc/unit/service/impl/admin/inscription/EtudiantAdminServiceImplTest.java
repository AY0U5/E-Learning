package ma.zs.alc.unit.service.impl.admin.inscription;

import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.dao.facade.core.inscription.EtudiantDao;
import ma.zs.alc.service.impl.admin.inscription.EtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.inscriptionref.Langue ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail ;
import ma.zs.alc.bean.core.pack.PackStudent ;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;
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
class EtudiantAdminServiceImplTest {

    @Mock
    private EtudiantDao repository;
    private AutoCloseable autoCloseable;
    private EtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new EtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveEtudiant() {
        // Given
        Etudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example Etudiant ID to retrieve
        Etudiant expected = new Etudiant(); // You need to replace Etudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Etudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Etudiant constructSample(int i) {
		Etudiant given = new Etudiant();
        given.setRef("ref-"+i);
        given.setTeacherLocality(new TeacherLocality(1L));
        given.setGroupOption("groupOption-"+i);
        given.setEtatEtudiantSchedule(new EtatEtudiantSchedule(1L));
        given.setParcours(new Parcours(1L));
        List<QuizEtudiant> quizEtudiants = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                QuizEtudiant element = new QuizEtudiant();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                element.setQuiz(new Quiz(Long.valueOf(3)));
                                                element.setNote(new BigDecimal(5*10));
                                                element.setResultat("resultat"+id);
                                                element.setQuestionCurrent(7L);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setQuizEtudiants(quizEtudiants);
        given.setGroupeEtude(new GroupeEtude(1L));
        List<GroupeEtudiantDetail> groupeEtudiantDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                GroupeEtudiantDetail element = new GroupeEtudiantDetail();
                                                element.setId((long)id);
                                                element.setGroupeEtudiant(new GroupeEtudiant(Long.valueOf(1)));
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setGroupeEtudiantDetails(groupeEtudiantDetails);
        given.setPackStudent(new PackStudent(1L));
        given.setStatutSocial(new StatutSocial(1L));
        given.setInteretEtudiant(new InteretEtudiant(1L));
        given.setNiveauEtude(new NiveauEtude(1L));
        given.setSkill(new Skill(1L));
        given.setFonction(new Fonction(1L));
        given.setLangue(new Langue(1L));
        given.setCredentialsNonExpired(false);
        given.setEnabled(false);
        given.setAccountNonExpired(false);
        given.setAccountNonLocked(false);
        given.setPasswordChanged(false);
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
