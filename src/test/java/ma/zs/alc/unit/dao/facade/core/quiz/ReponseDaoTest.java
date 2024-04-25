package ma.zs.alc.unit.dao.facade.core.quiz;

import ma.zs.alc.bean.core.quiz.Reponse;
import ma.zs.alc.dao.facade.core.quiz.ReponseDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.quiz.Question ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReponseDaoTest {

@Autowired
    private ReponseDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Reponse entity = new Reponse();
        entity.setRef(ref);
        underTest.save(entity);
        Reponse loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Reponse entity = new Reponse();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Reponse loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Reponse entity = new Reponse();
        entity.setId(id);
        underTest.save(entity);
        Reponse loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Reponse entity = new Reponse();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Reponse loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Reponse> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Reponse> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Reponse given = constructSample(1);
        Reponse saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Reponse constructSample(int i) {
		Reponse given = new Reponse();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setEtatReponse("etatReponse-"+i);
        given.setNumero(i*1L);
        given.setQuestion(new Question(1L));
        return given;
    }

}
