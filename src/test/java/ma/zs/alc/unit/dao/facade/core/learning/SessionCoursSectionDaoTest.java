package ma.zs.alc.unit.dao.facade.core.learning;

import ma.zs.alc.bean.core.learning.SessionCoursSection;
import ma.zs.alc.dao.facade.core.learning.SessionCoursSectionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.learning.SessionCours ;
import ma.zs.alc.bean.core.course.Section ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SessionCoursSectionDaoTest {

@Autowired
    private SessionCoursSectionDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        SessionCoursSection entity = new SessionCoursSection();
        entity.setId(id);
        underTest.save(entity);
        SessionCoursSection loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        SessionCoursSection entity = new SessionCoursSection();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        SessionCoursSection loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<SessionCoursSection> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<SessionCoursSection> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        SessionCoursSection given = constructSample(1);
        SessionCoursSection saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private SessionCoursSection constructSample(int i) {
		SessionCoursSection given = new SessionCoursSection();
        given.setSessionCours(new SessionCours(1L));
        given.setSection(new Section(1L));
        return given;
    }

}
