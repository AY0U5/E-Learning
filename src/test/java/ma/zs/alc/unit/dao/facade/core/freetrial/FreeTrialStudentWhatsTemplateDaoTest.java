package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialStudentWhatsTemplateDao;

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
public class FreeTrialStudentWhatsTemplateDaoTest {

@Autowired
    private FreeTrialStudentWhatsTemplateDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrialStudentWhatsTemplate entity = new FreeTrialStudentWhatsTemplate();
        entity.setId(id);
        underTest.save(entity);
        FreeTrialStudentWhatsTemplate loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrialStudentWhatsTemplate entity = new FreeTrialStudentWhatsTemplate();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrialStudentWhatsTemplate loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrialStudentWhatsTemplate> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrialStudentWhatsTemplate> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrialStudentWhatsTemplate given = constructSample(1);
        FreeTrialStudentWhatsTemplate saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrialStudentWhatsTemplate constructSample(int i) {
		FreeTrialStudentWhatsTemplate given = new FreeTrialStudentWhatsTemplate();
        given.setObject("object-"+i);
        given.setCorps("corps-"+i);
        given.setSource("source-"+i);
        return given;
    }

}
