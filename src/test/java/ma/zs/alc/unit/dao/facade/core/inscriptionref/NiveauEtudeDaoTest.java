package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.NiveauEtude;
import ma.zs.alc.dao.facade.core.inscriptionref.NiveauEtudeDao;

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
public class NiveauEtudeDaoTest {

@Autowired
    private NiveauEtudeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        NiveauEtude entity = new NiveauEtude();
        entity.setCode(code);
        underTest.save(entity);
        NiveauEtude loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        NiveauEtude entity = new NiveauEtude();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        NiveauEtude loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        NiveauEtude entity = new NiveauEtude();
        entity.setId(id);
        underTest.save(entity);
        NiveauEtude loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        NiveauEtude entity = new NiveauEtude();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        NiveauEtude loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<NiveauEtude> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<NiveauEtude> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        NiveauEtude given = constructSample(1);
        NiveauEtude saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private NiveauEtude constructSample(int i) {
		NiveauEtude given = new NiveauEtude();
        given.setLibelle("libelle-"+i);
        given.setCode("code-"+i);
        return given;
    }

}
