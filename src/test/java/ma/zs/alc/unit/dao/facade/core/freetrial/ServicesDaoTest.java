package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.Services;
import ma.zs.alc.dao.facade.core.freetrial.ServicesDao;

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
public class ServicesDaoTest {

@Autowired
    private ServicesDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Services entity = new Services();
        entity.setCode(code);
        underTest.save(entity);
        Services loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Services entity = new Services();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Services loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Services entity = new Services();
        entity.setId(id);
        underTest.save(entity);
        Services loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Services entity = new Services();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Services loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Services> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Services> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Services given = constructSample(1);
        Services saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Services constructSample(int i) {
		Services given = new Services();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        return given;
    }

}
