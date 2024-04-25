package ma.zs.alc.unit.dao.facade.core.quizref;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion;
import ma.zs.alc.dao.facade.core.quizref.TypeDeQuestionDao;

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
public class TypeDeQuestionDaoTest {

@Autowired
    private TypeDeQuestionDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        TypeDeQuestion entity = new TypeDeQuestion();
        entity.setRef(ref);
        underTest.save(entity);
        TypeDeQuestion loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        TypeDeQuestion entity = new TypeDeQuestion();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        TypeDeQuestion loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeDeQuestion entity = new TypeDeQuestion();
        entity.setId(id);
        underTest.save(entity);
        TypeDeQuestion loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeDeQuestion entity = new TypeDeQuestion();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeDeQuestion loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeDeQuestion> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeDeQuestion> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeDeQuestion given = constructSample(1);
        TypeDeQuestion saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeDeQuestion constructSample(int i) {
		TypeDeQuestion given = new TypeDeQuestion();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        return given;
    }

}
