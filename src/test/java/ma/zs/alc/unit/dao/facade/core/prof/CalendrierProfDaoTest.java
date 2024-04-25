package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.CalendrierProf;
import ma.zs.alc.dao.facade.core.prof.CalendrierProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CalendrierProfDaoTest {

@Autowired
    private CalendrierProfDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        CalendrierProf entity = new CalendrierProf();
        entity.setRef(ref);
        underTest.save(entity);
        CalendrierProf loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        CalendrierProf entity = new CalendrierProf();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        CalendrierProf loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CalendrierProf entity = new CalendrierProf();
        entity.setId(id);
        underTest.save(entity);
        CalendrierProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CalendrierProf entity = new CalendrierProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CalendrierProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CalendrierProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CalendrierProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CalendrierProf given = constructSample(1);
        CalendrierProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CalendrierProf constructSample(int i) {
		CalendrierProf given = new CalendrierProf();
        given.setRef("ref-"+i);
        given.setStartTime("startTime-"+i);
        given.setEndTime("endTime-"+i);
        given.setStartRecur(LocalDateTime.now());
        given.setEndRecur(LocalDateTime.now());
        given.setProf(new Prof(1L));
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
