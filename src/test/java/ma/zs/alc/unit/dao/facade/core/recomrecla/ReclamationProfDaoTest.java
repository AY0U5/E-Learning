package ma.zs.alc.unit.dao.facade.core.recomrecla;

import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf ;
import ma.zs.alc.bean.core.alc.Admin ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReclamationProfDaoTest {

@Autowired
    private ReclamationProfDao underTest;

    @Test
    void shouldFindByReference(){
        String reference = "reference-1";
        ReclamationProf entity = new ReclamationProf();
        entity.setReference(reference);
        underTest.save(entity);
        ReclamationProf loaded = underTest.findByReference(reference);
        assertThat(loaded.getReference()).isEqualTo(reference);
    }

    @Test
    void shouldDeleteByReference() {
        String reference = "reference-1";
        ReclamationProf entity = new ReclamationProf();
        entity.setReference(reference);
        underTest.save(entity);

        int result = underTest.deleteByReference(reference);

        ReclamationProf loaded = underTest.findByReference(reference);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ReclamationProf entity = new ReclamationProf();
        entity.setId(id);
        underTest.save(entity);
        ReclamationProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ReclamationProf entity = new ReclamationProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ReclamationProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ReclamationProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ReclamationProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ReclamationProf given = constructSample(1);
        ReclamationProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ReclamationProf constructSample(int i) {
		ReclamationProf given = new ReclamationProf();
        given.setReference("reference-"+i);
        given.setDateReclamation(LocalDateTime.now());
        given.setMessage("message-"+i);
        given.setTraite(false);
        given.setDateTraitement(LocalDateTime.now());
        given.setDateReponse(LocalDateTime.now());
        given.setPostView(false);
        given.setCommentaireTraiteur("commentaireTraiteur-"+i);
        given.setObjetReclamationProf("objetReclamationProf-"+i);
        given.setAdmin(new Admin(1L));
        given.setProf(new Prof(1L));
        given.setTypeReclamationProf(new TypeReclamationProf(1L));
        return given;
    }

}
