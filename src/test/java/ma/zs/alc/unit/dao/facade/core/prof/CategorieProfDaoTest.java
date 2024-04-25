package ma.zs.alc.unit.dao.facade.core.prof;

import ma.zs.alc.bean.core.prof.CategorieProf;
import ma.zs.alc.dao.facade.core.prof.CategorieProfDao;

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
public class CategorieProfDaoTest {

@Autowired
    private CategorieProfDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategorieProf entity = new CategorieProf();
        entity.setCode(code);
        underTest.save(entity);
        CategorieProf loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategorieProf entity = new CategorieProf();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategorieProf loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategorieProf entity = new CategorieProf();
        entity.setId(id);
        underTest.save(entity);
        CategorieProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategorieProf entity = new CategorieProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategorieProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategorieProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategorieProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategorieProf given = constructSample(1);
        CategorieProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategorieProf constructSample(int i) {
		CategorieProf given = new CategorieProf();
        given.setCode("code-"+i);
        given.setLevel("level-"+i);
        given.setLessonRate(BigDecimal.TEN);
        return given;
    }

}
