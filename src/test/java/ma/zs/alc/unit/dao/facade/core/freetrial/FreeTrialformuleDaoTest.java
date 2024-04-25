package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialformuleDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.grpe.Inscription ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FreeTrialformuleDaoTest {

@Autowired
    private FreeTrialformuleDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        FreeTrialformule entity = new FreeTrialformule();
        entity.setCode(code);
        underTest.save(entity);
        FreeTrialformule loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        FreeTrialformule entity = new FreeTrialformule();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        FreeTrialformule loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrialformule entity = new FreeTrialformule();
        entity.setId(id);
        underTest.save(entity);
        FreeTrialformule loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrialformule entity = new FreeTrialformule();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrialformule loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrialformule> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrialformule> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrialformule given = constructSample(1);
        FreeTrialformule saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrialformule constructSample(int i) {
		FreeTrialformule given = new FreeTrialformule();
        given.setCode("code-"+i);
        given.setInscription(new Inscription(1L));
        given.setDayspeerweek("dayspeerweek-"+i);
        given.setTimeperday("timeperday-"+i);
        given.setTeacherGenderoption("teacherGenderoption-"+i);
        given.setTeacherAgeRange("teacherAgeRange-"+i);
        given.setTeacherPersonnality("teacherPersonnality-"+i);
        given.setStatus(false);
        given.setDateConfirmation(LocalDateTime.now());
        return given;
    }

}
