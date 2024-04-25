package ma.zs.alc.unit.dao.facade.core.vocab;

import ma.zs.alc.bean.core.vocab.Vocabulary;
import ma.zs.alc.dao.facade.core.vocab.VocabularyDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.vocab.VocabularyQuiz ;
import ma.zs.alc.bean.core.course.Section ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class VocabularyDaoTest {

@Autowired
    private VocabularyDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Vocabulary entity = new Vocabulary();
        entity.setId(id);
        underTest.save(entity);
        Vocabulary loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Vocabulary entity = new Vocabulary();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Vocabulary loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Vocabulary> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Vocabulary> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Vocabulary given = constructSample(1);
        Vocabulary saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Vocabulary constructSample(int i) {
		Vocabulary given = new Vocabulary();
        given.setRef("ref-"+i);
        given.setNumero(i*1L);
        given.setWord("word-"+i);
        given.setLibelle("libelle-"+i);
        given.setResult("result-"+i);
        given.setExplication("explication-"+i);
        given.setExemple("exemple-"+i);
        given.setImage("image-"+i);
        given.setSection(new Section(1L));
        given.setVocabularyQuiz(new VocabularyQuiz(1L));
        return given;
    }

}
