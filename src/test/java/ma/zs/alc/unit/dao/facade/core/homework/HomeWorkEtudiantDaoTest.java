package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.HomeWorkEtudiant;
import ma.zs.alc.dao.facade.core.homework.HomeWorkEtudiantDao;

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
import ma.zs.alc.bean.core.homework.HomeWork ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HomeWorkEtudiantDaoTest {

@Autowired
    private HomeWorkEtudiantDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        HomeWorkEtudiant entity = new HomeWorkEtudiant();
        entity.setId(id);
        underTest.save(entity);
        HomeWorkEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        HomeWorkEtudiant entity = new HomeWorkEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        HomeWorkEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<HomeWorkEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<HomeWorkEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        HomeWorkEtudiant given = constructSample(1);
        HomeWorkEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private HomeWorkEtudiant constructSample(int i) {
		HomeWorkEtudiant given = new HomeWorkEtudiant();
        given.setEtudiant(new Etudiant(1L));
        given.setHomeWork(new HomeWork(1L));
        given.setNote(BigDecimal.TEN);
        given.setResultat("resultat-"+i);
        given.setDateHomeWork(LocalDateTime.now());
        return given;
    }

}
