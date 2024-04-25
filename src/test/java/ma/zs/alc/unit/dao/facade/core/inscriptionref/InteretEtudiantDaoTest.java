package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.InteretEtudiant;
import ma.zs.alc.dao.facade.core.inscriptionref.InteretEtudiantDao;

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
public class InteretEtudiantDaoTest {

@Autowired
    private InteretEtudiantDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        InteretEtudiant entity = new InteretEtudiant();
        entity.setCode(code);
        underTest.save(entity);
        InteretEtudiant loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        InteretEtudiant entity = new InteretEtudiant();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        InteretEtudiant loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        InteretEtudiant entity = new InteretEtudiant();
        entity.setId(id);
        underTest.save(entity);
        InteretEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        InteretEtudiant entity = new InteretEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        InteretEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<InteretEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<InteretEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        InteretEtudiant given = constructSample(1);
        InteretEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private InteretEtudiant constructSample(int i) {
		InteretEtudiant given = new InteretEtudiant();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
