package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialStudentEmailTemplateDao;

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
public class FreeTrialStudentEmailTemplateDaoTest {

@Autowired
    private FreeTrialStudentEmailTemplateDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrialStudentEmailTemplate entity = new FreeTrialStudentEmailTemplate();
        entity.setId(id);
        underTest.save(entity);
        FreeTrialStudentEmailTemplate loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrialStudentEmailTemplate entity = new FreeTrialStudentEmailTemplate();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrialStudentEmailTemplate loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrialStudentEmailTemplate> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrialStudentEmailTemplate> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrialStudentEmailTemplate given = constructSample(1);
        FreeTrialStudentEmailTemplate saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrialStudentEmailTemplate constructSample(int i) {
		FreeTrialStudentEmailTemplate given = new FreeTrialStudentEmailTemplate();
        given.setObject("object-"+i);
        given.setCorps("corps-"+i);
        given.setSource("source-"+i);
        return given;
    }

}
