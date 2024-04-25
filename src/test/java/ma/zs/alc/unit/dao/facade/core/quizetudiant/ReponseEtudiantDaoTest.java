package ma.zs.alc.unit.dao.facade.core.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.ReponseEtudiant;
import ma.zs.alc.dao.facade.core.quizetudiant.ReponseEtudiantDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant ;
import ma.zs.alc.bean.core.quiz.Question ;
import ma.zs.alc.bean.core.quiz.Reponse ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReponseEtudiantDaoTest {

@Autowired
    private ReponseEtudiantDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        ReponseEtudiant entity = new ReponseEtudiant();
        entity.setRef(ref);
        underTest.save(entity);
        ReponseEtudiant loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        ReponseEtudiant entity = new ReponseEtudiant();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        ReponseEtudiant loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        ReponseEtudiant entity = new ReponseEtudiant();
        entity.setId(id);
        underTest.save(entity);
        ReponseEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ReponseEtudiant entity = new ReponseEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ReponseEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ReponseEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ReponseEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ReponseEtudiant given = constructSample(1);
        ReponseEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ReponseEtudiant constructSample(int i) {
		ReponseEtudiant given = new ReponseEtudiant();
        given.setRef("ref-"+i);
        given.setReponse(new Reponse(1L));
        given.setAnswer("answer-"+i);
        given.setQuizEtudiant(new QuizEtudiant(1L));
        given.setNote(BigDecimal.TEN);
        given.setQuestion(new Question(1L));
        return given;
    }

}
