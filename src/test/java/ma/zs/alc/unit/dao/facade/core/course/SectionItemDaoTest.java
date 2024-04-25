package ma.zs.alc.unit.dao.facade.core.course;

import ma.zs.alc.bean.core.course.SectionItem;
import ma.zs.alc.dao.facade.core.course.SectionItemDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.course.Section ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class SectionItemDaoTest {

@Autowired
    private SectionItemDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        SectionItem entity = new SectionItem();
        entity.setId(id);
        underTest.save(entity);
        SectionItem loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        SectionItem entity = new SectionItem();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        SectionItem loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<SectionItem> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<SectionItem> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        SectionItem given = constructSample(1);
        SectionItem saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private SectionItem constructSample(int i) {
		SectionItem given = new SectionItem();
        given.setImageUrl("imageUrl-"+i);
        given.setResponse("response-"+i);
        given.setTranscription("transcription-"+i);
        given.setTranslation("translation-"+i);
        given.setExplanation("explanation-"+i);
        given.setExample("example-"+i);
        given.setSynonyms("synonyms-"+i);
        given.setSection(new Section(1L));
        return given;
    }

}
