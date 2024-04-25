package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtude;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudeDao;

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
public class GroupeEtudeDaoTest {

@Autowired
    private GroupeEtudeDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEtude entity = new GroupeEtude();
        entity.setId(id);
        underTest.save(entity);
        GroupeEtude loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEtude entity = new GroupeEtude();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEtude loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEtude> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEtude> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEtude given = constructSample(1);
        GroupeEtude saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEtude constructSample(int i) {
		GroupeEtude given = new GroupeEtude();
        given.setLibelle("libelle-"+i);
        given.setDescription("description-"+i);
        given.setNombreEtudiant(i*1L);
        return given;
    }

}
