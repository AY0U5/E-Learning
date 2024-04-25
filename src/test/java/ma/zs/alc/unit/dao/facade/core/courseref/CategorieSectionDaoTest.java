package ma.zs.alc.unit.dao.facade.core.courseref;

import ma.zs.alc.bean.core.courseref.CategorieSection;
import ma.zs.alc.dao.facade.core.courseref.CategorieSectionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.courseref.SuperCategorieSection ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CategorieSectionDaoTest {

@Autowired
    private CategorieSectionDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        CategorieSection entity = new CategorieSection();
        entity.setCode(code);
        underTest.save(entity);
        CategorieSection loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        CategorieSection entity = new CategorieSection();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        CategorieSection loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        CategorieSection entity = new CategorieSection();
        entity.setId(id);
        underTest.save(entity);
        CategorieSection loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        CategorieSection entity = new CategorieSection();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        CategorieSection loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<CategorieSection> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<CategorieSection> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        CategorieSection given = constructSample(1);
        CategorieSection saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private CategorieSection constructSample(int i) {
		CategorieSection given = new CategorieSection();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setNumeroOrder(i);
        given.setSuperCategorieSection(new SuperCategorieSection(1L));
        return given;
    }

}
