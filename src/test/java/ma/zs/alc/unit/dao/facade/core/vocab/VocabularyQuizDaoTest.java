package ma.zs.alc.unit.dao.facade.core.vocab;

import ma.zs.alc.bean.core.vocab.VocabularyQuiz;
import ma.zs.alc.dao.facade.core.vocab.VocabularyQuizDao;

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
public class VocabularyQuizDaoTest {

@Autowired
    private VocabularyQuizDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        VocabularyQuiz entity = new VocabularyQuiz();
        entity.setId(id);
        underTest.save(entity);
        VocabularyQuiz loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        VocabularyQuiz entity = new VocabularyQuiz();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        VocabularyQuiz loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<VocabularyQuiz> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<VocabularyQuiz> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        VocabularyQuiz given = constructSample(1);
        VocabularyQuiz saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private VocabularyQuiz constructSample(int i) {
		VocabularyQuiz given = new VocabularyQuiz();
        given.setLibelle("libelle-"+i);
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setSection(new Section(1L));
        return given;
    }

}
