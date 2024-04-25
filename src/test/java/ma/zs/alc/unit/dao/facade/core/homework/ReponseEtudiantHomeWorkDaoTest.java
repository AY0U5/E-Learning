package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.ReponseEtudiantHomeWork;
import ma.zs.alc.dao.facade.core.homework.ReponseEtudiantHomeWorkDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.homework.HoweWorkQSTReponse ;
import ma.zs.alc.bean.core.homework.HomeWorkEtudiant ;
import ma.zs.alc.bean.core.homework.HomeWorkQuestion ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ReponseEtudiantHomeWorkDaoTest {

@Autowired
    private ReponseEtudiantHomeWorkDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ReponseEtudiantHomeWork entity = new ReponseEtudiantHomeWork();
        entity.setId(id);
        underTest.save(entity);
        ReponseEtudiantHomeWork loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ReponseEtudiantHomeWork entity = new ReponseEtudiantHomeWork();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ReponseEtudiantHomeWork loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ReponseEtudiantHomeWork> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ReponseEtudiantHomeWork> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ReponseEtudiantHomeWork given = constructSample(1);
        ReponseEtudiantHomeWork saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ReponseEtudiantHomeWork constructSample(int i) {
		ReponseEtudiantHomeWork given = new ReponseEtudiantHomeWork();
        given.setHoweWorkQSTReponse(new HoweWorkQSTReponse(1L));
        given.setAnswer("answer-"+i);
        given.setHomeWorkEtudiant(new HomeWorkEtudiant(1L));
        given.setHomeWorkQuestion(new HomeWorkQuestion(1L));
        given.setProfNote("profNote-"+i);
        given.setNote(BigDecimal.TEN);
        return given;
    }

}
