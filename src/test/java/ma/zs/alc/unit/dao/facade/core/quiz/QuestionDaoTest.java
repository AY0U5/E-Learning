package ma.zs.alc.unit.dao.facade.core.quiz;

import ma.zs.alc.bean.core.quiz.Question;
import ma.zs.alc.dao.facade.core.quiz.QuestionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.quizref.TypeDeQuestion ;
import ma.zs.alc.bean.core.homework.HomeWork ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuestionDaoTest {

@Autowired
    private QuestionDao underTest;

    @Test
    void shouldFindByLibelle(){
        String libelle = "libelle-1";
        Question entity = new Question();
        entity.setLibelle(libelle);
        underTest.save(entity);
        Question loaded = underTest.findByLibelle(libelle);
        assertThat(loaded.getLibelle()).isEqualTo(libelle);
    }

    @Test
    void shouldDeleteByLibelle() {
        String libelle = "libelle-1";
        Question entity = new Question();
        entity.setLibelle(libelle);
        underTest.save(entity);

        int result = underTest.deleteByLibelle(libelle);

        Question loaded = underTest.findByLibelle(libelle);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Question entity = new Question();
        entity.setId(id);
        underTest.save(entity);
        Question loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Question entity = new Question();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Question loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Question> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Question> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Question given = constructSample(1);
        Question saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Question constructSample(int i) {
		Question given = new Question();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setUrlImg("urlImg-"+i);
        given.setUrlVideo("urlVideo-"+i);
        given.setNumero(i*1L);
        given.setPointReponseJuste(BigDecimal.TEN);
        given.setPointReponsefausse(BigDecimal.TEN);
        given.setTypeDeQuestion(new TypeDeQuestion(1L));
        given.setQuiz(new Quiz(1L));
        given.setHomeWork(new HomeWork(1L));
        return given;
    }

}
