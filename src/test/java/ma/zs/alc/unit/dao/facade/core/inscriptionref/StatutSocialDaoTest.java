package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.StatutSocial;
import ma.zs.alc.dao.facade.core.inscriptionref.StatutSocialDao;

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
public class StatutSocialDaoTest {

@Autowired
    private StatutSocialDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        StatutSocial entity = new StatutSocial();
        entity.setCode(code);
        underTest.save(entity);
        StatutSocial loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        StatutSocial entity = new StatutSocial();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        StatutSocial loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        StatutSocial entity = new StatutSocial();
        entity.setId(id);
        underTest.save(entity);
        StatutSocial loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        StatutSocial entity = new StatutSocial();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        StatutSocial loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<StatutSocial> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<StatutSocial> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        StatutSocial given = constructSample(1);
        StatutSocial saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private StatutSocial constructSample(int i) {
		StatutSocial given = new StatutSocial();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
