package ma.zs.alc.unit.dao.facade.core.profetudiantcours;

import ma.zs.alc.bean.core.profetudiantcours.EtudiantCours;
import ma.zs.alc.dao.facade.core.profetudiantcours.EtudiantCoursDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EtudiantCoursDaoTest {

@Autowired
    private EtudiantCoursDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EtudiantCours entity = new EtudiantCours();
        entity.setId(id);
        underTest.save(entity);
        EtudiantCours loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtudiantCours entity = new EtudiantCours();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtudiantCours loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtudiantCours> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtudiantCours> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtudiantCours given = constructSample(1);
        EtudiantCours saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtudiantCours constructSample(int i) {
		EtudiantCours given = new EtudiantCours();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setPayer(false);
        given.setDateFin(LocalDateTime.now());
        return given;
    }

}
