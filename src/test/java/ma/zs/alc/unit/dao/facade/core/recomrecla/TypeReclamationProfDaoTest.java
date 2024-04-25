package ma.zs.alc.unit.dao.facade.core.recomrecla;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf;
import ma.zs.alc.dao.facade.core.recomrecla.TypeReclamationProfDao;

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
public class TypeReclamationProfDaoTest {

@Autowired
    private TypeReclamationProfDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeReclamationProf entity = new TypeReclamationProf();
        entity.setCode(code);
        underTest.save(entity);
        TypeReclamationProf loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeReclamationProf entity = new TypeReclamationProf();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeReclamationProf loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeReclamationProf entity = new TypeReclamationProf();
        entity.setId(id);
        underTest.save(entity);
        TypeReclamationProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeReclamationProf entity = new TypeReclamationProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeReclamationProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeReclamationProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeReclamationProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeReclamationProf given = constructSample(1);
        TypeReclamationProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeReclamationProf constructSample(int i) {
		TypeReclamationProf given = new TypeReclamationProf();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
