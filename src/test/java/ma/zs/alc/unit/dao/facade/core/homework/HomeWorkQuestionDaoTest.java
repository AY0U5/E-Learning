package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion;
import ma.zs.alc.dao.facade.core.homework.HomeWorkQuestionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.bean.core.homework.HomeWork ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HomeWorkQuestionDaoTest {

@Autowired
    private HomeWorkQuestionDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        HomeWorkQuestion entity = new HomeWorkQuestion();
        entity.setRef(ref);
        underTest.save(entity);
        HomeWorkQuestion loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        HomeWorkQuestion entity = new HomeWorkQuestion();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        HomeWorkQuestion loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        HomeWorkQuestion entity = new HomeWorkQuestion();
        entity.setId(id);
        underTest.save(entity);
        HomeWorkQuestion loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        HomeWorkQuestion entity = new HomeWorkQuestion();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        HomeWorkQuestion loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<HomeWorkQuestion> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<HomeWorkQuestion> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        HomeWorkQuestion given = constructSample(1);
        HomeWorkQuestion saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private HomeWorkQuestion constructSample(int i) {
		HomeWorkQuestion given = new HomeWorkQuestion();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setNumero(i);
        given.setPointReponseJuste(BigDecimal.TEN);
        given.setPointReponsefausse(BigDecimal.TEN);
        given.setTypeDeQuestion(new TypeDeQuestion(1L));
        given.setHomeWork(new HomeWork(1L));
        return given;
    }

}
