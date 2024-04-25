package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.Langue;
import ma.zs.alc.dao.facade.core.inscriptionref.LangueDao;

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
public class LangueDaoTest {

@Autowired
    private LangueDao underTest;

    @Test
    void shouldFindByLibelle(){
        String libelle = "libelle-1";
        Langue entity = new Langue();
        entity.setLibelle(libelle);
        underTest.save(entity);
        Langue loaded = underTest.findByLibelle(libelle);
        assertThat(loaded.getLibelle()).isEqualTo(libelle);
    }

    @Test
    void shouldDeleteByLibelle() {
        String libelle = "libelle-1";
        Langue entity = new Langue();
        entity.setLibelle(libelle);
        underTest.save(entity);

        int result = underTest.deleteByLibelle(libelle);

        Langue loaded = underTest.findByLibelle(libelle);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Langue entity = new Langue();
        entity.setId(id);
        underTest.save(entity);
        Langue loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Langue entity = new Langue();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Langue loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Langue> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Langue> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Langue given = constructSample(1);
        Langue saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Langue constructSample(int i) {
		Langue given = new Langue();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
