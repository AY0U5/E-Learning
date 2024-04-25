package ma.zs.alc.unit.dao.facade.core.inscription;

import ma.zs.alc.bean.core.inscription.Dictionary;
import ma.zs.alc.dao.facade.core.inscription.DictionaryDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class DictionaryDaoTest {

@Autowired
    private DictionaryDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Dictionary entity = new Dictionary();
        entity.setId(id);
        underTest.save(entity);
        Dictionary loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Dictionary entity = new Dictionary();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Dictionary loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Dictionary> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Dictionary> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Dictionary given = constructSample(1);
        Dictionary saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Dictionary constructSample(int i) {
		Dictionary given = new Dictionary();
        given.setWord("word-"+i);
        given.setDefinition("definition-"+i);
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
