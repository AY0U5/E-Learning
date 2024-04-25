package ma.zs.alc.unit.dao.facade.core.recomrecla;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant;
import ma.zs.alc.dao.facade.core.recomrecla.TypeReclamationEtudiantDao;

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
public class TypeReclamationEtudiantDaoTest {

@Autowired
    private TypeReclamationEtudiantDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        TypeReclamationEtudiant entity = new TypeReclamationEtudiant();
        entity.setCode(code);
        underTest.save(entity);
        TypeReclamationEtudiant loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        TypeReclamationEtudiant entity = new TypeReclamationEtudiant();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        TypeReclamationEtudiant loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        TypeReclamationEtudiant entity = new TypeReclamationEtudiant();
        entity.setId(id);
        underTest.save(entity);
        TypeReclamationEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        TypeReclamationEtudiant entity = new TypeReclamationEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        TypeReclamationEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<TypeReclamationEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<TypeReclamationEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        TypeReclamationEtudiant given = constructSample(1);
        TypeReclamationEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private TypeReclamationEtudiant constructSample(int i) {
		TypeReclamationEtudiant given = new TypeReclamationEtudiant();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
