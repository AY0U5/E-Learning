package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.EtudiantClassRoom;
import ma.zs.alc.dao.facade.core.inscriptionref.EtudiantClassRoomDao;

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
import ma.zs.alc.bean.core.classroom.ClassRoom ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EtudiantClassRoomDaoTest {

@Autowired
    private EtudiantClassRoomDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        EtudiantClassRoom entity = new EtudiantClassRoom();
        entity.setId(id);
        underTest.save(entity);
        EtudiantClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        EtudiantClassRoom entity = new EtudiantClassRoom();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        EtudiantClassRoom loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<EtudiantClassRoom> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<EtudiantClassRoom> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        EtudiantClassRoom given = constructSample(1);
        EtudiantClassRoom saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private EtudiantClassRoom constructSample(int i) {
		EtudiantClassRoom given = new EtudiantClassRoom();
        given.setClassRoom(new ClassRoom(1L));
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
