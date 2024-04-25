package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse;
import ma.zs.alc.dao.facade.core.homework.HoweWorkQSTReponseDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HoweWorkQSTReponseDaoTest {

@Autowired
    private HoweWorkQSTReponseDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        HoweWorkQSTReponse entity = new HoweWorkQSTReponse();
        entity.setRef(ref);
        underTest.save(entity);
        HoweWorkQSTReponse loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        HoweWorkQSTReponse entity = new HoweWorkQSTReponse();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        HoweWorkQSTReponse loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        HoweWorkQSTReponse entity = new HoweWorkQSTReponse();
        entity.setId(id);
        underTest.save(entity);
        HoweWorkQSTReponse loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        HoweWorkQSTReponse entity = new HoweWorkQSTReponse();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        HoweWorkQSTReponse loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<HoweWorkQSTReponse> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<HoweWorkQSTReponse> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        HoweWorkQSTReponse given = constructSample(1);
        HoweWorkQSTReponse saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private HoweWorkQSTReponse constructSample(int i) {
		HoweWorkQSTReponse given = new HoweWorkQSTReponse();
        given.setRef("ref-"+i);
        given.setLib("lib-"+i);
        given.setEtatReponse("etatReponse-"+i);
        given.setNumero(i);
        given.setHomeWorkQuestion(new HomeWorkQuestion(1L));
        return given;
    }

}
