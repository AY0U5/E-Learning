package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialConfigurationDao;

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
public class FreeTrialConfigurationDaoTest {

@Autowired
    private FreeTrialConfigurationDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrialConfiguration entity = new FreeTrialConfiguration();
        entity.setId(id);
        underTest.save(entity);
        FreeTrialConfiguration loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrialConfiguration entity = new FreeTrialConfiguration();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrialConfiguration loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrialConfiguration> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrialConfiguration> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrialConfiguration given = constructSample(1);
        FreeTrialConfiguration saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrialConfiguration constructSample(int i) {
		FreeTrialConfiguration given = new FreeTrialConfiguration();
        given.setDateApplicationDebut(LocalDateTime.now());
        given.setDateApplicationFin(LocalDateTime.now());
        given.setNombreStudentMax(i);
        given.setNombreStudentMin(i);
        return given;
    }

}
