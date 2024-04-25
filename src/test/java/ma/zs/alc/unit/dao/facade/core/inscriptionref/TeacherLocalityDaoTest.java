package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.TeacherLocality;
import ma.zs.alc.dao.facade.core.inscriptionref.TeacherLocalityDao;

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
public class TeacherLocalityDaoTest {

@Autowired
    private TeacherLocalityDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TeacherLocality entity = new TeacherLocality();
        entity.setCode(code);
        underTest.save(entity);
        TeacherLocality loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TeacherLocality entity = new TeacherLocality();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TeacherLocality loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TeacherLocality entity = new TeacherLocality();
        entity.setId(id);
        underTest.save(entity);
        TeacherLocality loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TeacherLocality entity = new TeacherLocality();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TeacherLocality loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TeacherLocality> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TeacherLocality> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TeacherLocality given = constructSample(1);
        TeacherLocality saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TeacherLocality constructSample(int i) {
		TeacherLocality given = new TeacherLocality();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
