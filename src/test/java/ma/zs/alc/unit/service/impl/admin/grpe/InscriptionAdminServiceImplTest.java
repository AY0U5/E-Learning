package ma.zs.alc.unit.service.impl.admin.grpe;

import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.dao.facade.core.grpe.InscriptionDao;
import ma.zs.alc.service.impl.admin.grpe.InscriptionAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.inscriptionref.EtatInscription ;
import ma.zs.alc.bean.core.grpe.GroupeType ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.bean.core.pack.PackStudent ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
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
class InscriptionAdminServiceImplTest {

    @Mock
    private InscriptionDao repository;
    private AutoCloseable autoCloseable;
    private InscriptionAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new InscriptionAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllInscription() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveInscription() {
        // Given
        Inscription toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteInscription() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetInscriptionById() {
        // Given
        Long idToRetrieve = 1L; // Example Inscription ID to retrieve
        Inscription expected = new Inscription(); // You need to replace Inscription with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Inscription result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Inscription constructSample(int i) {
		Inscription given = new Inscription();
        given.setNumeroInscription(i);
        given.setEtudiant(new Etudiant(1L));
        given.setEtatInscription(new EtatInscription(1L));
        given.setParcours(new Parcours(1L));
        given.setGroupeEtude(new GroupeEtude(1L));
        given.setGroupeType(new GroupeType(1L));
        given.setStatutSocial(new StatutSocial(1L));
        given.setInteretEtudiant(new InteretEtudiant(1L));
        given.setNiveauEtude(new NiveauEtude(1L));
        given.setFonction(new Fonction(1L));
        given.setQuiz(new Quiz(1L));
        given.setNoteQuizNiveau(BigDecimal.TEN);
        given.setQuizFinished(false);
        given.setDateRegistration("dateRegistration-"+i);
        given.setDatedebutinscription(LocalDateTime.now());
        given.setDatefininscription(LocalDateTime.now());
        given.setPackStudent(new PackStudent(1L));
        given.setSkill(new Skill(1L));
        given.setSkype("skype-"+i);
        return given;
    }

}
