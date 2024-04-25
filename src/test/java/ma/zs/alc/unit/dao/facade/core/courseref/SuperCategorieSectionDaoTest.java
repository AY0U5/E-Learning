package ma.zs.alc.unit.dao.facade.core.courseref;

import ma.zs.alc.bean.core.courseref.SuperCategorieSection;
import ma.zs.alc.dao.facade.core.courseref.SuperCategorieSectionDao;

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
public class SuperCategorieSectionDaoTest {

@Autowired
    private SuperCategorieSectionDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        SuperCategorieSection entity = new SuperCategorieSection();
        entity.setCode(code);
        underTest.save(entity);
        SuperCategorieSection loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        SuperCategorieSection entity = new SuperCategorieSection();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        SuperCategorieSection loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        SuperCategorieSection entity = new SuperCategorieSection();
        entity.setId(id);
        underTest.save(entity);
        SuperCategorieSection loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        SuperCategorieSection entity = new SuperCategorieSection();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        SuperCategorieSection loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<SuperCategorieSection> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<SuperCategorieSection> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        SuperCategorieSection given = constructSample(1);
        SuperCategorieSection saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private SuperCategorieSection constructSample(int i) {
		SuperCategorieSection given = new SuperCategorieSection();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
