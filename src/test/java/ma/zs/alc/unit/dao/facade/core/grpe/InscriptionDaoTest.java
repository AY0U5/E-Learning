package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.Inscription;
import ma.zs.alc.dao.facade.core.grpe.InscriptionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class InscriptionDaoTest {

@Autowired
    private InscriptionDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Inscription entity = new Inscription();
        entity.setId(id);
        underTest.save(entity);
        Inscription loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Inscription entity = new Inscription();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Inscription loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Inscription> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Inscription> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Inscription given = constructSample(1);
        Inscription saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
