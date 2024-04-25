package ma.zs.alc.unit.service.impl.admin.course;

import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.dao.facade.core.course.ParcoursDao;
import ma.zs.alc.service.impl.admin.course.ParcoursAdminServiceImpl;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.bean.core.inscriptionref.Langue ;
import ma.zs.alc.bean.core.courseref.EtatCours ;
import ma.zs.alc.bean.core.courseref.Centre ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
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
class ParcoursAdminServiceImplTest {

    @Mock
    private ParcoursDao repository;
    private AutoCloseable autoCloseable;
    private ParcoursAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ParcoursAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllParcours() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveParcours() {
        // Given
        Parcours toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteParcours() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetParcoursById() {
        // Given
        Long idToRetrieve = 1L; // Example Parcours ID to retrieve
        Parcours expected = new Parcours(); // You need to replace Parcours with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Parcours result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Parcours constructSample(int i) {
		Parcours given = new Parcours();
        given.setDatePublication(LocalDateTime.now());
        given.setDateCreation(LocalDateTime.now());
        given.setDescription("description-"+i);
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setNumeroOrder(i);
        given.setNombreCours(i);
        given.setCentre(new Centre(1L));
        List<Cours> courss = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Cours element = new Cours();
                                                element.setId((long)id);
                                                element.setCode("code"+id);
                                                element.setLibelle("libelle"+id);
                                                element.setDescription("description"+id);
                                                element.setImage("image"+id);
                                                element.setEtatCours(new EtatCours(Long.valueOf(5)));
                                                element.setParcours(new Parcours(Long.valueOf(6)));
                                                element.setNombreSectionFinalise(7);
                                                element.setNombreSectionEnCours(8);
                                                element.setNombreLinkEnCours(9);
                                                element.setNombreLinkFinalise(10);
                                                element.setNumeroOrder(11);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setCourss(courss);
        List<Etudiant> etudiants = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                Etudiant element = new Etudiant();
                                                element.setId((long)id);
                                                element.setRef("ref"+id);
                                                element.setTeacherLocality(new TeacherLocality(Long.valueOf(2)));
                                                element.setGroupOption("groupOption"+id);
                                                element.setEtatEtudiantSchedule(new EtatEtudiantSchedule(Long.valueOf(4)));
                                                element.setParcours(new Parcours(Long.valueOf(5)));
                                                element.setGroupeEtude(new GroupeEtude(Long.valueOf(7)));
                                                element.setPackStudent(new PackStudent(Long.valueOf(9)));
                                                element.setStatutSocial(new StatutSocial(Long.valueOf(10)));
                                                element.setInteretEtudiant(new InteretEtudiant(Long.valueOf(11)));
                                                element.setNiveauEtude(new NiveauEtude(Long.valueOf(12)));
                                                element.setSkill(new Skill(Long.valueOf(13)));
                                                element.setFonction(new Fonction(Long.valueOf(14)));
                                                element.setLangue(new Langue(Long.valueOf(15)));
                                                element.setCredentialsNonExpired(true);
                                                element.setEnabled(true);
                                                element.setAccountNonExpired(true);
                                                element.setAccountNonLocked(true);
                                                element.setPasswordChanged(true);
                                                element.setUsername("username"+id);
                                                element.setPassword("password"+id);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setEtudiants(etudiants);
        return given;
    }

}
