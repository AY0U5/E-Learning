package ma.zs.alc.unit.dao.facade.core.learning;

import ma.zs.alc.bean.core.learning.SessionCours;
import ma.zs.alc.dao.facade.core.learning.SessionCoursDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.salary.Salary ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SessionCoursDaoTest {

@Autowired
    private SessionCoursDao underTest;

    @Test
    void shouldFindByReference(){
        String reference = "reference-1";
        SessionCours entity = new SessionCours();
        entity.setReference(reference);
        underTest.save(entity);
        SessionCours loaded = underTest.findByReference(reference);
        assertThat(loaded.getReference()).isEqualTo(reference);
    }

    @Test
    void shouldDeleteByReference() {
        String reference = "reference-1";
        SessionCours entity = new SessionCours();
        entity.setReference(reference);
        underTest.save(entity);

        int result = underTest.deleteByReference(reference);

        SessionCours loaded = underTest.findByReference(reference);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        SessionCours entity = new SessionCours();
        entity.setId(id);
        underTest.save(entity);
        SessionCours loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        SessionCours entity = new SessionCours();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        SessionCours loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<SessionCours> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<SessionCours> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        SessionCours given = constructSample(1);
        SessionCours saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
        return given;
    }

}
