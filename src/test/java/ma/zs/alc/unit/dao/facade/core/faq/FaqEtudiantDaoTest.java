package ma.zs.alc.unit.dao.facade.core.faq;

import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.dao.facade.core.faq.FaqEtudiantDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.faq.FaqType ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.alc.Admin ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FaqEtudiantDaoTest {

@Autowired
    private FaqEtudiantDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FaqEtudiant entity = new FaqEtudiant();
        entity.setId(id);
        underTest.save(entity);
        FaqEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FaqEtudiant entity = new FaqEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FaqEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FaqEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FaqEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FaqEtudiant given = constructSample(1);
        FaqEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FaqEtudiant constructSample(int i) {
		FaqEtudiant given = new FaqEtudiant();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setEtudiant(new Etudiant(1L));
        given.setAdmin(new Admin(1L));
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
