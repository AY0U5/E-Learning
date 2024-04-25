package ma.zs.alc.unit.dao.facade.core.course;

import ma.zs.alc.bean.core.course.Section;
import ma.zs.alc.dao.facade.core.course.SectionDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.courseref.CategorieSection ;
import ma.zs.alc.bean.core.course.Cours ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SectionDaoTest {

@Autowired
    private SectionDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        Section entity = new Section();
        entity.setCode(code);
        underTest.save(entity);
        Section loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        Section entity = new Section();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        Section loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        Section entity = new Section();
        entity.setId(id);
        underTest.save(entity);
        Section loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Section entity = new Section();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Section loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Section> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Section> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Section given = constructSample(1);
        Section saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Section constructSample(int i) {
		Section given = new Section();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        given.setUrlImage("urlImage-"+i);
        given.setUrlImage2("urlImage2-"+i);
        given.setUrlImage3("urlImage3-"+i);
        given.setUrlVideo("urlVideo-"+i);
        given.setContenu("contenu-"+i);
        given.setQuestions("questions-"+i);
        given.setIndicationProf("indicationProf-"+i);
        given.setNumeroOrder(i);
        given.setCategorieSection(new CategorieSection(1L));
        given.setCours(new Cours(1L));
        given.setUrl(i);
        given.setContent(i);
        return given;
    }

}
