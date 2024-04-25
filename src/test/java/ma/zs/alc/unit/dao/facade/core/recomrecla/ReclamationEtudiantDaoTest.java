package ma.zs.alc.unit.dao.facade.core.recomrecla;

import ma.zs.alc.bean.core.recomrecla.ReclamationEtudiant;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationEtudiantDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationEtudiant ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReclamationEtudiantDaoTest {

@Autowired
    private ReclamationEtudiantDao underTest;

    @Test
    void shouldFindByReference(){
        String reference = "reference-1";
        ReclamationEtudiant entity = new ReclamationEtudiant();
        entity.setReference(reference);
        underTest.save(entity);
        ReclamationEtudiant loaded = underTest.findByReference(reference);
        assertThat(loaded.getReference()).isEqualTo(reference);
    }

    @Test
    void shouldDeleteByReference() {
        String reference = "reference-1";
        ReclamationEtudiant entity = new ReclamationEtudiant();
        entity.setReference(reference);
        underTest.save(entity);

        int result = underTest.deleteByReference(reference);

        ReclamationEtudiant loaded = underTest.findByReference(reference);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ReclamationEtudiant entity = new ReclamationEtudiant();
        entity.setId(id);
        underTest.save(entity);
        ReclamationEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ReclamationEtudiant entity = new ReclamationEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ReclamationEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ReclamationEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ReclamationEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ReclamationEtudiant given = constructSample(1);
        ReclamationEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ReclamationEtudiant constructSample(int i) {
		ReclamationEtudiant given = new ReclamationEtudiant();
        given.setReference("reference-"+i);
        given.setDateReclamation(LocalDateTime.now());
        given.setMessage("message-"+i);
        given.setSetFrom("setFrom-"+i);
        given.setImg("img-"+i);
        given.setTraite(false);
        given.setDateTraitement(LocalDateTime.now());
        given.setDateReponse(LocalDateTime.now());
        given.setPostView(false);
        given.setObjetReclamationEtudiant("objetReclamationEtudiant-"+i);
        given.setCommentaireTraiteur("commentaireTraiteur-"+i);
        given.setUsername("username-"+i);
        given.setTypeReclamationEtudiant(new TypeReclamationEtudiant(1L));
        return given;
    }

}
