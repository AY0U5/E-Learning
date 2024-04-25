package ma.zs.alc.unit.dao.facade.core.recomrecla;

import ma.zs.alc.bean.core.recomrecla.RecommendTeacher;
import ma.zs.alc.dao.facade.core.recomrecla.RecommendTeacherDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class RecommendTeacherDaoTest {

@Autowired
    private RecommendTeacherDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        RecommendTeacher entity = new RecommendTeacher();
        entity.setRef(ref);
        underTest.save(entity);
        RecommendTeacher loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        RecommendTeacher entity = new RecommendTeacher();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        RecommendTeacher loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        RecommendTeacher entity = new RecommendTeacher();
        entity.setId(id);
        underTest.save(entity);
        RecommendTeacher loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        RecommendTeacher entity = new RecommendTeacher();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        RecommendTeacher loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<RecommendTeacher> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<RecommendTeacher> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        RecommendTeacher given = constructSample(1);
        RecommendTeacher saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private RecommendTeacher constructSample(int i) {
		RecommendTeacher given = new RecommendTeacher();
        given.setRef("ref-"+i);
        given.setNombrevote(i);
        given.setNom("nom-"+i);
        given.setPrenom("prenom-"+i);
        given.setCommentaire("commentaire-"+i);
        given.setTelephone("telephone-"+i);
        given.setLogin("login-"+i);
        given.setDateRecommamdation(LocalDateTime.now());
        given.setProf(new Prof(1L));
        return given;
    }

}
