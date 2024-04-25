package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.ClassAverageBonusProf;
import ma.zs.alc.dao.facade.core.prof.ClassAverageBonusProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.salary.Salary ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClassAverageBonusProfDaoTest {

@Autowired
    private ClassAverageBonusProfDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ClassAverageBonusProf entity = new ClassAverageBonusProf();
        entity.setId(id);
        underTest.save(entity);
        ClassAverageBonusProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ClassAverageBonusProf entity = new ClassAverageBonusProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ClassAverageBonusProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ClassAverageBonusProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ClassAverageBonusProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ClassAverageBonusProf given = constructSample(1);
        ClassAverageBonusProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ClassAverageBonusProf constructSample(int i) {
		ClassAverageBonusProf given = new ClassAverageBonusProf();
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setSalary(new Salary(1L));
        return given;
    }

}
