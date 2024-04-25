package ma.zs.alc.unit.dao.facade.core.faq;

import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.dao.facade.core.faq.FaqProfDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.faq.FaqType ;
import ma.zs.alc.bean.core.alc.Admin ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FaqProfDaoTest {

@Autowired
    private FaqProfDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FaqProf entity = new FaqProf();
        entity.setId(id);
        underTest.save(entity);
        FaqProf loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FaqProf entity = new FaqProf();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FaqProf loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FaqProf> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FaqProf> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FaqProf given = constructSample(1);
        FaqProf saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FaqProf constructSample(int i) {
		FaqProf given = new FaqProf();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setProf(new Prof(1L));
        given.setAdmin(new Admin(1L));
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
