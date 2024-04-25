package ma.zs.alc.unit.dao.facade.core.classroom;

import ma.zs.alc.bean.core.classroom.ClassRoom;
import ma.zs.alc.dao.facade.core.classroom.ClassRoomDao;

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
public class ClassRoomDaoTest {

@Autowired
    private ClassRoomDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ClassRoom entity = new ClassRoom();
        entity.setId(id);
        underTest.save(entity);
        ClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ClassRoom entity = new ClassRoom();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ClassRoom> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ClassRoom> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ClassRoom given = constructSample(1);
        ClassRoom saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ClassRoom constructSample(int i) {
		ClassRoom given = new ClassRoom();
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setProf(new Prof(1L));
        return given;
    }

}
