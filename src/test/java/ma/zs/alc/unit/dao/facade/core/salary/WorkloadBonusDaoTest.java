package ma.zs.alc.unit.dao.facade.core.salary;

import ma.zs.alc.bean.core.salary.WorkloadBonus;
import ma.zs.alc.dao.facade.core.salary.WorkloadBonusDao;

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
public class WorkloadBonusDaoTest {

@Autowired
    private WorkloadBonusDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        WorkloadBonus entity = new WorkloadBonus();
        entity.setCode(code);
        underTest.save(entity);
        WorkloadBonus loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        WorkloadBonus entity = new WorkloadBonus();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        WorkloadBonus loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        WorkloadBonus entity = new WorkloadBonus();
        entity.setId(id);
        underTest.save(entity);
        WorkloadBonus loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        WorkloadBonus entity = new WorkloadBonus();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        WorkloadBonus loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<WorkloadBonus> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<WorkloadBonus> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        WorkloadBonus given = constructSample(1);
        WorkloadBonus saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private WorkloadBonus constructSample(int i) {
		WorkloadBonus given = new WorkloadBonus();
        given.setCode("code-"+i);
        given.setNombreSession(i);
        given.setPrix(BigDecimal.TEN);
        return given;
    }

}
