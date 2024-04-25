package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.TypeHomeWork;
import ma.zs.alc.dao.facade.core.homework.TypeHomeWorkDao;

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
public class TypeHomeWorkDaoTest {

@Autowired
    private TypeHomeWorkDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeHomeWork entity = new TypeHomeWork();
        entity.setCode(code);
        underTest.save(entity);
        TypeHomeWork loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeHomeWork entity = new TypeHomeWork();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeHomeWork loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeHomeWork entity = new TypeHomeWork();
        entity.setId(id);
        underTest.save(entity);
        TypeHomeWork loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeHomeWork entity = new TypeHomeWork();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeHomeWork loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeHomeWork> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeHomeWork> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeHomeWork given = constructSample(1);
        TypeHomeWork saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeHomeWork constructSample(int i) {
		TypeHomeWork given = new TypeHomeWork();
        given.setCode("code-"+i);
        given.setLib("lib-"+i);
        return given;
    }

}
