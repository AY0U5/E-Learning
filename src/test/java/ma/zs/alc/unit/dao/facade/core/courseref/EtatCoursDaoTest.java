package ma.zs.alc.unit.dao.facade.core.courseref;

import ma.zs.alc.bean.core.courseref.EtatCours;
import ma.zs.alc.dao.facade.core.courseref.EtatCoursDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EtatCoursDaoTest {

@Autowired
    private EtatCoursDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        EtatCours entity = new EtatCours();
        entity.setCode(code);
        underTest.save(entity);
        EtatCours loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        EtatCours entity = new EtatCours();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        EtatCours loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        EtatCours entity = new EtatCours();
        entity.setId(id);
        underTest.save(entity);
        EtatCours loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtatCours entity = new EtatCours();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtatCours loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtatCours> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtatCours> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtatCours given = constructSample(1);
        EtatCours saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtatCours constructSample(int i) {
		EtatCours given = new EtatCours();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
