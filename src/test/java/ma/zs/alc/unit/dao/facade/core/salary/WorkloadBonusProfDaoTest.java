package ma.zs.alc.unit.dao.facade.core.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonusProf;
import ma.zs.alc.dao.facade.core.salary.WorkloadBonusProfDao;

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
import ma.zs.alc.bean.core.salary.WorkloadBonus ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class WorkloadBonusProfDaoTest {

@Autowired
    private WorkloadBonusProfDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        WorkloadBonusProf entity = new WorkloadBonusProf();
        entity.setId(id);
        underTest.save(entity);
        WorkloadBonusProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        WorkloadBonusProf entity = new WorkloadBonusProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        WorkloadBonusProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<WorkloadBonusProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<WorkloadBonusProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        WorkloadBonusProf given = constructSample(1);
        WorkloadBonusProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private WorkloadBonusProf constructSample(int i) {
		WorkloadBonusProf given = new WorkloadBonusProf();
        given.setWorkloadBonus(new WorkloadBonus(1L));
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setSalary(new Salary(1L));
        return given;
    }

}
