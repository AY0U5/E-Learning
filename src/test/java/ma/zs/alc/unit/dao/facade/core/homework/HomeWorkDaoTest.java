package ma.zs.alc.unit.dao.facade.core.homework;

import ma.zs.alc.bean.core.homework.HomeWork;
import ma.zs.alc.dao.facade.core.homework.HomeWorkDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.homework.TypeHomeWork ;
import ma.zs.alc.bean.core.course.Cours ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class HomeWorkDaoTest {

@Autowired
    private HomeWorkDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        HomeWork entity = new HomeWork();
        entity.setId(id);
        underTest.save(entity);
        HomeWork loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        HomeWork entity = new HomeWork();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        HomeWork loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<HomeWork> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<HomeWork> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        HomeWork given = constructSample(1);
        HomeWork saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private HomeWork constructSample(int i) {
		HomeWork given = new HomeWork();
        given.setLibelle("libelle-"+i);
        given.setUrlImage("urlImage-"+i);
        given.setUrlVideo("urlVideo-"+i);
        given.setCours(new Cours(1L));
        given.setTypeHomeWork(new TypeHomeWork(1L));
        return given;
    }

}
