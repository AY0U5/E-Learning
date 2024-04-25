package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.StatutFreeTrial;
import ma.zs.alc.dao.facade.core.freetrial.StatutFreeTrialDao;

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
public class StatutFreeTrialDaoTest {

@Autowired
    private StatutFreeTrialDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        StatutFreeTrial entity = new StatutFreeTrial();
        entity.setCode(code);
        underTest.save(entity);
        StatutFreeTrial loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        StatutFreeTrial entity = new StatutFreeTrial();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        StatutFreeTrial loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        StatutFreeTrial entity = new StatutFreeTrial();
        entity.setId(id);
        underTest.save(entity);
        StatutFreeTrial loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        StatutFreeTrial entity = new StatutFreeTrial();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        StatutFreeTrial loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<StatutFreeTrial> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<StatutFreeTrial> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        StatutFreeTrial given = constructSample(1);
        StatutFreeTrial saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private StatutFreeTrial constructSample(int i) {
		StatutFreeTrial given = new StatutFreeTrial();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        given.setStyle("style-"+i);
        return given;
    }

}
