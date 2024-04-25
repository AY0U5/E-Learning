package ma.zs.alc.unit.dao.facade.core.course;

import ma.zs.alc.bean.core.course.Parcours;
import ma.zs.alc.dao.facade.core.course.ParcoursDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.courseref.Centre ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ParcoursDaoTest {

@Autowired
    private ParcoursDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Parcours entity = new Parcours();
        entity.setCode(code);
        underTest.save(entity);
        Parcours loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Parcours entity = new Parcours();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Parcours loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Parcours entity = new Parcours();
        entity.setId(id);
        underTest.save(entity);
        Parcours loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Parcours entity = new Parcours();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Parcours loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Parcours> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Parcours> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Parcours given = constructSample(1);
        Parcours saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
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
        return given;
    }

}
