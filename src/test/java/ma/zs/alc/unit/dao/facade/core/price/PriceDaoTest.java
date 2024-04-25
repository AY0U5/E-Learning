package ma.zs.alc.unit.dao.facade.core.price;

import ma.zs.alc.bean.core.price.Price;
import ma.zs.alc.dao.facade.core.price.PriceDao;

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
public class PriceDaoTest {

@Autowired
    private PriceDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Price entity = new Price();
        entity.setId(id);
        underTest.save(entity);
        Price loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Price entity = new Price();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Price loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Price> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Price> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Price given = constructSample(1);
        Price saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Price constructSample(int i) {
		Price given = new Price();
        given.setPrice(BigDecimal.TEN);
        given.setOldPrice(BigDecimal.TEN);
        given.setLib("lib-"+i);
        given.setNreCourse(BigDecimal.TEN);
        given.setNreHours(BigDecimal.TEN);
        given.setNreMonth(BigDecimal.TEN);
        given.setForGroup(false);
        return given;
    }

}
