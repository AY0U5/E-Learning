package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.TypeTeacher;
import ma.zs.alc.dao.facade.core.prof.TypeTeacherDao;

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
public class TypeTeacherDaoTest {

@Autowired
    private TypeTeacherDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeTeacher entity = new TypeTeacher();
        entity.setCode(code);
        underTest.save(entity);
        TypeTeacher loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeTeacher entity = new TypeTeacher();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeTeacher loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeTeacher entity = new TypeTeacher();
        entity.setId(id);
        underTest.save(entity);
        TypeTeacher loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeTeacher entity = new TypeTeacher();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeTeacher loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeTeacher> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeTeacher> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeTeacher given = constructSample(1);
        TypeTeacher saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeTeacher constructSample(int i) {
		TypeTeacher given = new TypeTeacher();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
