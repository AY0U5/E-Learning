package ma.zs.alc.unit.dao.facade.core.common;

import ma.zs.alc.bean.core.common.News;
import ma.zs.alc.dao.facade.core.common.NewsDao;

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
public class NewsDaoTest {

@Autowired
    private NewsDao underTest;

    @Test
    void shouldFindByRef(){
        String ref = "ref-1";
        News entity = new News();
        entity.setRef(ref);
        underTest.save(entity);
        News loaded = underTest.findByRef(ref);
        assertThat(loaded.getRef()).isEqualTo(ref);
    }

    @Test
    void shouldDeleteByRef() {
        String ref = "ref-1";
        News entity = new News();
        entity.setRef(ref);
        underTest.save(entity);

        int result = underTest.deleteByRef(ref);

        News loaded = underTest.findByRef(ref);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        News entity = new News();
        entity.setId(id);
        underTest.save(entity);
        News loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        News entity = new News();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        News loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<News> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<News> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        News given = constructSample(1);
        News saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private News constructSample(int i) {
		News given = new News();
        given.setRef("ref-"+i);
        given.setLibelle("libelle-"+i);
        given.setImage("image-"+i);
        given.setDescription("description-"+i);
        given.setDateNews(LocalDateTime.now());
        given.setDateDebut(LocalDateTime.now());
        given.setDateFin(LocalDateTime.now());
        given.setNumeroOrdre(i);
        given.setDestinataire("destinataire-"+i);
        return given;
    }

}
