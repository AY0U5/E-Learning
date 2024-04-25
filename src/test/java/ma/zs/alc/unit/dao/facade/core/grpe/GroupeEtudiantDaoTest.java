package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudiantDao;

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
import ma.zs.alc.bean.core.grpe.GroupeEtat ;
import ma.zs.alc.bean.core.grpe.GroupeType ;
import ma.zs.alc.bean.core.grpe.GroupeEtude ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GroupeEtudiantDaoTest {

@Autowired
    private GroupeEtudiantDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEtudiant entity = new GroupeEtudiant();
        entity.setId(id);
        underTest.save(entity);
        GroupeEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEtudiant entity = new GroupeEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEtudiant given = constructSample(1);
        GroupeEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEtudiant constructSample(int i) {
		GroupeEtudiant given = new GroupeEtudiant();
        given.setLibelle("libelle-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setNombrePlace(i*1L);
        given.setNombrePlacevide(i*1L);
        given.setNombrePlaceNonVide(i*1L);
        given.setGroupeEtude(new GroupeEtude(1L));
        given.setGroupeType(new GroupeType(1L));
        given.setGroupeEtat(new GroupeEtat(1L));
        given.setParcours(new Parcours(1L));
        given.setProf(new Prof(1L));
        return given;
    }

}
