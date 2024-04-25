package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.GroupeType;
import ma.zs.alc.dao.facade.core.grpe.GroupeTypeDao;

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
public class GroupeTypeDaoTest {

@Autowired
    private GroupeTypeDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        GroupeType entity = new GroupeType();
        entity.setCode(code);
        underTest.save(entity);
        GroupeType loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        GroupeType entity = new GroupeType();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        GroupeType loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeType entity = new GroupeType();
        entity.setId(id);
        underTest.save(entity);
        GroupeType loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeType entity = new GroupeType();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeType loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeType> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeType> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeType given = constructSample(1);
        GroupeType saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeType constructSample(int i) {
		GroupeType given = new GroupeType();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
