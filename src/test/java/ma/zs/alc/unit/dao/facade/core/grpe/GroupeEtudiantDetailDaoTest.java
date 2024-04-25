package ma.zs.alc.unit.dao.facade.core.grpe;

import ma.zs.alc.bean.core.grpe.GroupeEtudiantDetail;
import ma.zs.alc.dao.facade.core.grpe.GroupeEtudiantDetailDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class GroupeEtudiantDetailDaoTest {

@Autowired
    private GroupeEtudiantDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        GroupeEtudiantDetail entity = new GroupeEtudiantDetail();
        entity.setId(id);
        underTest.save(entity);
        GroupeEtudiantDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        GroupeEtudiantDetail entity = new GroupeEtudiantDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        GroupeEtudiantDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<GroupeEtudiantDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<GroupeEtudiantDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        GroupeEtudiantDetail given = constructSample(1);
        GroupeEtudiantDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private GroupeEtudiantDetail constructSample(int i) {
		GroupeEtudiantDetail given = new GroupeEtudiantDetail();
        given.setGroupeEtudiant(new GroupeEtudiant(1L));
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
