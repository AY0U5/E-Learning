package ma.zs.alc.unit.dao.facade.core.review;

import ma.zs.alc.bean.core.review.ProfReview;
import ma.zs.alc.dao.facade.core.review.ProfReviewDao;

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
public class ProfReviewDaoTest {

@Autowired
    private ProfReviewDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ProfReview entity = new ProfReview();
        entity.setId(id);
        underTest.save(entity);
        ProfReview loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ProfReview entity = new ProfReview();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ProfReview loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ProfReview> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ProfReview> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ProfReview given = constructSample(1);
        ProfReview saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ProfReview constructSample(int i) {
		ProfReview given = new ProfReview();
        given.setEtudiant(new Etudiant(1L));
        given.setProf(new Prof(1L));
        given.setCours(new Cours(1L));
        given.setReview(i);
        given.setComment("comment-"+i);
        given.setDateReview(LocalDateTime.now());
        return given;
    }

}
