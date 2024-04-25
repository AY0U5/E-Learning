package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantReview;
import ma.zs.alc.dao.facade.core.inscriptionref.EtudiantReviewDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.course.Cours ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EtudiantReviewDaoTest {

@Autowired
    private EtudiantReviewDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EtudiantReview entity = new EtudiantReview();
        entity.setId(id);
        underTest.save(entity);
        EtudiantReview loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtudiantReview entity = new EtudiantReview();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtudiantReview loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtudiantReview> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtudiantReview> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtudiantReview given = constructSample(1);
        EtudiantReview saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtudiantReview constructSample(int i) {
		EtudiantReview given = new EtudiantReview();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setReview(i);
        given.setComment("comment-"+i);
        given.setDateReview(LocalDateTime.now());
        return given;
    }

}
