package ma.zs.alc.unit.dao.facade.core.common;

import ma.zs.alc.bean.core.common.ClassAverageBonus;
import ma.zs.alc.dao.facade.core.common.ClassAverageBonusDao;

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
public class ClassAverageBonusDaoTest {

@Autowired
    private ClassAverageBonusDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        ClassAverageBonus entity = new ClassAverageBonus();
        entity.setCode(code);
        underTest.save(entity);
        ClassAverageBonus loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        ClassAverageBonus entity = new ClassAverageBonus();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        ClassAverageBonus loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ClassAverageBonus entity = new ClassAverageBonus();
        entity.setId(id);
        underTest.save(entity);
        ClassAverageBonus loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ClassAverageBonus entity = new ClassAverageBonus();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ClassAverageBonus loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ClassAverageBonus> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ClassAverageBonus> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ClassAverageBonus given = constructSample(1);
        ClassAverageBonus saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ClassAverageBonus constructSample(int i) {
		ClassAverageBonus given = new ClassAverageBonus();
        given.setCode("code-"+i);
        given.setNombreSession(i);
        given.setPrix(BigDecimal.TEN);
        return given;
    }

}
