package ma.zs.alc.unit.dao.facade.core.quiz;

import ma.zs.alc.bean.core.quiz.Quiz;
import ma.zs.alc.dao.facade.core.quiz.QuizDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.course.Section ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuizDaoTest {

@Autowired
    private QuizDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Quiz entity = new Quiz();
        entity.setRef(ref);
        underTest.save(entity);
        Quiz loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Quiz entity = new Quiz();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Quiz loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Quiz entity = new Quiz();
        entity.setId(id);
        underTest.save(entity);
        Quiz loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Quiz entity = new Quiz();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Quiz loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Quiz> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Quiz> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Quiz given = constructSample(1);
        Quiz saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Quiz constructSample(int i) {
		Quiz given = new Quiz();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setSection(new Section(1L));
        given.setNumero(i*1L);
        given.setSeuilReussite(i*1L);
        return given;
    }

}
