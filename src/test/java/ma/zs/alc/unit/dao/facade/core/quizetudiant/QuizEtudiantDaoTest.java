package ma.zs.alc.unit.dao.facade.core.quizetudiant;

import ma.zs.alc.bean.core.quizetudiant.QuizEtudiant;
import ma.zs.alc.dao.facade.core.quizetudiant.QuizEtudiantDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.quiz.Quiz ;
import ma.zs.alc.bean.core.inscription.Etudiant ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuizEtudiantDaoTest {

@Autowired
    private QuizEtudiantDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        QuizEtudiant entity = new QuizEtudiant();
        entity.setRef(ref);
        underTest.save(entity);
        QuizEtudiant loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        QuizEtudiant entity = new QuizEtudiant();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        QuizEtudiant loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        QuizEtudiant entity = new QuizEtudiant();
        entity.setId(id);
        underTest.save(entity);
        QuizEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        QuizEtudiant entity = new QuizEtudiant();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        QuizEtudiant loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<QuizEtudiant> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<QuizEtudiant> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        QuizEtudiant given = constructSample(1);
        QuizEtudiant saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private QuizEtudiant constructSample(int i) {
		QuizEtudiant given = new QuizEtudiant();
        given.setRef("ref-"+i);
        given.setEtudiant(new Etudiant(1L));
        given.setQuiz(new Quiz(1L));
        given.setNote(BigDecimal.TEN);
        given.setResultat("resultat-"+i);
        given.setQuestionCurrent(i*1L);
        return given;
    }

}
