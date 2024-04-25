package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtat;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtatDao;

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
public class GroupeEtatDaoTest {

@Autowired
    private GroupeEtatDao underTest;

    @Test
    void shouldFindByCode(){
        String code = "code-1";
        GroupeEtat entity = new GroupeEtat();
        entity.setCode(code);
        underTest.save(entity);
        GroupeEtat loaded = underTest.findByCode(code);
        assertThat(loaded.getCode()).isEqualTo(code);
    }

    @Test
    void shouldDeleteByCode() {
        String code = "code-1";
        GroupeEtat entity = new GroupeEtat();
        entity.setCode(code);
        underTest.save(entity);

        int result = underTest.deleteByCode(code);

        GroupeEtat loaded = underTest.findByCode(code);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEtat entity = new GroupeEtat();
        entity.setId(id);
        underTest.save(entity);
        GroupeEtat loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEtat entity = new GroupeEtat();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEtat loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEtat> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEtat> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEtat given = constructSample(1);
        GroupeEtat saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEtat constructSample(int i) {
		GroupeEtat given = new GroupeEtat();
        given.setCode("code-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
