package ma.zs.alc.unit.dao.facade.core.quiz;

import ma.zs.alc.bean.core.quiz.QuizClassRoom;
import ma.zs.alc.dao.facade.core.quiz.QuizClassRoomDao;

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
import ma.zs.alc.bean.core.classroom.ClassRoom ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class QuizClassRoomDaoTest {

@Autowired
    private QuizClassRoomDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        QuizClassRoom entity = new QuizClassRoom();
        entity.setId(id);
        underTest.save(entity);
        QuizClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        QuizClassRoom entity = new QuizClassRoom();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        QuizClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<QuizClassRoom> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<QuizClassRoom> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        QuizClassRoom given = constructSample(1);
        QuizClassRoom saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private QuizClassRoom constructSample(int i) {
		QuizClassRoom given = new QuizClassRoom();
        given.setClassRoom(new ClassRoom(1L));
        given.setQuiz(new Quiz(1L));
        return given;
    }

}
