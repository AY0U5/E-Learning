package ma.zs.alc.unit.dao.facade.core.faq;

import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.dao.facade.core.faq.FaqTypeDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FaqTypeDaoTest {

@Autowired
    private FaqTypeDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FaqType entity = new FaqType();
        entity.setId(id);
        underTest.save(entity);
        FaqType loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FaqType entity = new FaqType();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FaqType loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FaqType> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FaqType> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FaqType given = constructSample(1);
        FaqType saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FaqType constructSample(int i) {
		FaqType given = new FaqType();
        given.setDestinataire("destinataire-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
