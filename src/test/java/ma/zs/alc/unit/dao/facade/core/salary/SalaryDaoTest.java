package ma.zs.alc.unit.dao.facade.core.salary;

import ma.zs.alc.bean.core.salary.Salary;
import ma.zs.alc.dao.facade.core.salary.SalaryDao;

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
public class SalaryDaoTest {

@Autowired
    private SalaryDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Salary entity = new Salary();
        entity.setCode(code);
        underTest.save(entity);
        Salary loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Salary entity = new Salary();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Salary loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Salary entity = new Salary();
        entity.setId(id);
        underTest.save(entity);
        Salary loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Salary entity = new Salary();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Salary loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Salary> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Salary> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Salary given = constructSample(1);
        Salary saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Salary constructSample(int i) {
		Salary given = new Salary();
        given.setCode("code-"+i);
        given.setProf(new Prof(1L));
        given.setMois(i);
        given.setAnnee(i);
        given.setNbrSessionMensuel(BigDecimal.TEN);
        given.setPayer(false);
        given.setTotalPayment(BigDecimal.TEN);
        given.setTotalBonusClassAverage(BigDecimal.TEN);
        given.setTotalBonusWorkload(BigDecimal.TEN);
        return given;
    }

}
