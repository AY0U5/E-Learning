package ma.zs.alc.unit.dao.facade.core.faq;

import ma.zs.alc.bean.core.faq.Faq;
import ma.zs.alc.dao.facade.core.faq.FaqDao;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FaqDaoTest {

@Autowired
    private FaqDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Faq entity = new Faq();
        entity.setId(id);
        underTest.save(entity);
        Faq loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Faq entity = new Faq();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Faq loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Faq> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Faq> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Faq given = constructSample(1);
        Faq saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Faq constructSample(int i) {
		Faq given = new Faq();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
