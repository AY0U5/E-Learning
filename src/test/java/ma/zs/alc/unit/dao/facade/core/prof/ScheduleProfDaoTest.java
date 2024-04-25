package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.ScheduleProf;
import ma.zs.alc.dao.facade.core.prof.ScheduleProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ScheduleProfDaoTest {

@Autowired
    private ScheduleProfDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ScheduleProf entity = new ScheduleProf();
        entity.setId(id);
        underTest.save(entity);
        ScheduleProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ScheduleProf entity = new ScheduleProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ScheduleProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ScheduleProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ScheduleProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ScheduleProf given = constructSample(1);
        ScheduleProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ScheduleProf constructSample(int i) {
		ScheduleProf given = new ScheduleProf();
        given.setSubject("subject-"+i);
        given.setStartTime(LocalDateTime.now());
        given.setEndTime(LocalDateTime.now());
        given.setRef("ref-"+i);
        given.setGroupeEtudiant(new GroupeEtudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setGrpName("grpName-"+i);
        given.setProfName("profName-"+i);
        given.setProfsId(i*1L);
        return given;
    }

}
