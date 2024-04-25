package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.Prof;
import ma.zs.alc.dao.facade.core.prof.ProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.prof.TypeTeacher ;
import ma.zs.alc.bean.core.prof.CategorieProf ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProfDaoTest {

@Autowired
    private ProfDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        Prof entity = new Prof();
        entity.setRef(ref);
        underTest.save(entity);
        Prof loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        Prof entity = new Prof();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        Prof loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Prof entity = new Prof();
        entity.setId(id);
        underTest.save(entity);
        Prof loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Prof entity = new Prof();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Prof loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Prof> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Prof> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Prof given = constructSample(1);
        Prof saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Prof constructSample(int i) {
		Prof given = new Prof();
        given.setRef("ref-"+i);
        given.setAbout("about-"+i);
        given.setParcours(new Parcours(1L));
        given.setCategorieProf(new CategorieProf(1L));
        given.setTypeTeacher(new TypeTeacher(1L));
        given.setCredentialsNonExpired(false);
        given.setEnabled(false);
        given.setAccountNonExpired(false);
        given.setAccountNonLocked(false);
        given.setPasswordChanged(false);
        given.setUsername("username-"+i);
        given.setPassword("password-"+i);
        return given;
    }

}
