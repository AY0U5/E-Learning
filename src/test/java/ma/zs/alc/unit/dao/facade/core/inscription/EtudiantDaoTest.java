package ma.zs.alc.unit.dao.facade.core.inscription;

import ma.zs.alc.bean.core.inscription.Etudiant;
import ma.zs.alc.dao.facade.core.inscription.EtudiantDao;

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
import ma.zs.alc.bean.core.inscriptionref.Skill ;
import ma.zs.alc.bean.core.inscriptionref.EtatEtudiantSchedule ;
import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant ;
import ma.zs.alc.bean.core.inscriptionref.Fonction ;
import ma.zs.alc.bean.core.pack.PackStudent ;
import ma.zs.alc.bean.core.inscriptionref.StatutSocial ;
import ma.zs.alc.bean.core.inscriptionref.Langue ;
import ma.zs.alc.bean.core.inscriptionref.TeacherLocality ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EtudiantDaoTest {

@Autowired
    private EtudiantDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Etudiant entity = new Etudiant();
        entity.setRef(ref);
        underTest.save(entity);
        Etudiant loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Etudiant entity = new Etudiant();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Etudiant loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Etudiant entity = new Etudiant();
        entity.setId(id);
        underTest.save(entity);
        Etudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Etudiant entity = new Etudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Etudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Etudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Etudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Etudiant given = constructSample(1);
        Etudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Etudiant constructSample(int i) {
		Etudiant given = new Etudiant();
        given.setRef("ref-"+i);
        given.setTeacherLocality(new TeacherLocality(1L));
        given.setGroupOption("groupOption-"+i);
        given.setEtatEtudiantSchedule(new EtatEtudiantSchedule(1L));
        given.setParcours(new Parcours(1L));
        given.setGroupeEtude(new GroupeEtude(1L));
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
