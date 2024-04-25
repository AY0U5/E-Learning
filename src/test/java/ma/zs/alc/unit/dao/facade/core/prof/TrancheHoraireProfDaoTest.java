package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.TrancheHoraireProf;
import ma.zs.alc.dao.facade.core.prof.TrancheHoraireProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class TrancheHoraireProfDaoTest {

@Autowired
    private TrancheHoraireProfDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        TrancheHoraireProf entity = new TrancheHoraireProf();
        entity.setId(id);
        underTest.save(entity);
        TrancheHoraireProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TrancheHoraireProf entity = new TrancheHoraireProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TrancheHoraireProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TrancheHoraireProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TrancheHoraireProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TrancheHoraireProf given = constructSample(1);
        TrancheHoraireProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TrancheHoraireProf constructSample(int i) {
		TrancheHoraireProf given = new TrancheHoraireProf();
        given.setProf(new Prof(1L));
        given.setStartHour("startHour-"+i);
        given.setEndHour("endHour-"+i);
        given.setDay(i);
        given.setGroupIndex(i);
        given.setProfsId(i*1L);
        return given;
    }

}
