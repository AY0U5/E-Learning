package ma.zs.alc.unit.dao.facade.core.courseref;

import ma.zs.alc.bean.core.courseref.Centre;
import ma.zs.alc.dao.facade.core.courseref.CentreDao;

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
public class CentreDaoTest {

@Autowired
    private CentreDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Centre entity = new Centre();
        entity.setRef(ref);
        underTest.save(entity);
        Centre loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Centre entity = new Centre();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Centre loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Centre entity = new Centre();
        entity.setId(id);
        underTest.save(entity);
        Centre loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Centre entity = new Centre();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Centre loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Centre> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Centre> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Centre given = constructSample(1);
        Centre saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Centre constructSample(int i) {
		Centre given = new Centre();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setLog("log-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
