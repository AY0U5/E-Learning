package ma.zs.alc.unit.dao.facade.core.course;

import ma.zs.alc.bean.core.course.Cours;
import ma.zs.alc.dao.facade.core.course.CoursDao;

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
import ma.zs.alc.bean.core.courseref.EtatCours ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CoursDaoTest {

@Autowired
    private CoursDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Cours entity = new Cours();
        entity.setCode(code);
        underTest.save(entity);
        Cours loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Cours entity = new Cours();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Cours loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Cours entity = new Cours();
        entity.setId(id);
        underTest.save(entity);
        Cours loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Cours entity = new Cours();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Cours loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Cours> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Cours> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Cours given = constructSample(1);
        Cours saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Cours constructSample(int i) {
		Cours given = new Cours();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setImage("image-"+i);
        given.setEtatCours(new EtatCours(1L));
        given.setParcours(new Parcours(1L));
        given.setNombreSectionFinalise(i);
        given.setNombreSectionEnCours(i);
        given.setNombreLinkEnCours(i);
        given.setNombreLinkFinalise(i);
        given.setNumeroOrder(i);
        return given;
    }

}
