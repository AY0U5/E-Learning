package ma.zs.alc.unit.dao.facade.core.pack;

import ma.zs.alc.bean.core.pack.PackStudent;
import ma.zs.alc.dao.facade.core.pack.PackStudentDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.course.Parcours ;
import ma.zs.alc.bean.core.price.Price ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PackStudentDaoTest {

@Autowired
    private PackStudentDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        PackStudent entity = new PackStudent();
        entity.setCode(code);
        underTest.save(entity);
        PackStudent loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        PackStudent entity = new PackStudent();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        PackStudent loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        PackStudent entity = new PackStudent();
        entity.setId(id);
        underTest.save(entity);
        PackStudent loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        PackStudent entity = new PackStudent();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        PackStudent loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<PackStudent> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<PackStudent> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        PackStudent given = constructSample(1);
        PackStudent saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private PackStudent constructSample(int i) {
		PackStudent given = new PackStudent();
        given.setNombreCours(i);
        given.setForGroupe(false);
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setPreRequisites("preRequisites-"+i);
        given.setWhyTakeThisCourse("whyTakeThisCourse-"+i);
        given.setExpectations("expectations-"+i);
        given.setParcours(new Parcours(1L));
        given.setImgUrl("imgUrl-"+i);
        given.setPrice(new Price(1L));
        given.setTotalStudents(i);
        given.setRating("rating-"+i);
        given.setOldPrice("oldPrice-"+i);
        return given;
    }

}
