package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.Skill;
import ma.zs.alc.dao.facade.core.inscriptionref.SkillDao;

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
public class SkillDaoTest {

@Autowired
    private SkillDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Skill entity = new Skill();
        entity.setCode(code);
        underTest.save(entity);
        Skill loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Skill entity = new Skill();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Skill loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Skill entity = new Skill();
        entity.setId(id);
        underTest.save(entity);
        Skill loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Skill entity = new Skill();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Skill loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Skill> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Skill> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Skill given = constructSample(1);
        Skill saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Skill constructSample(int i) {
		Skill given = new Skill();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
