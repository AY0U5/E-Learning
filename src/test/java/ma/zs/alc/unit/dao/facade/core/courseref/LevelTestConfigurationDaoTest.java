package ma.zs.alc.unit.dao.facade.core.courseref;

import ma.zs.alc.bean.core.courseref.LevelTestConfiguration;
import ma.zs.alc.dao.facade.core.courseref.LevelTestConfigurationDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.course.Parcours ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class LevelTestConfigurationDaoTest {

@Autowired
    private LevelTestConfigurationDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        LevelTestConfiguration entity = new LevelTestConfiguration();
        entity.setId(id);
        underTest.save(entity);
        LevelTestConfiguration loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        LevelTestConfiguration entity = new LevelTestConfiguration();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        LevelTestConfiguration loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<LevelTestConfiguration> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<LevelTestConfiguration> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        LevelTestConfiguration given = constructSample(1);
        LevelTestConfiguration saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private LevelTestConfiguration constructSample(int i) {
		LevelTestConfiguration given = new LevelTestConfiguration();
        given.setNoteMin(BigDecimal.TEN);
        given.setNoteMax(BigDecimal.TEN);
        given.setParcours(new Parcours(1L));
        return given;
    }

}
