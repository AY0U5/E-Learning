package ma.zs.alc.unit.dao.facade.core.inscriptionref;

import ma.zs.alc.bean.core.inscriptionref.ConfirmationToken;
import ma.zs.alc.dao.facade.core.inscriptionref.ConfirmationTokenDao;

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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ConfirmationTokenDaoTest {

@Autowired
    private ConfirmationTokenDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        ConfirmationToken entity = new ConfirmationToken();
        entity.setId(id);
        underTest.save(entity);
        ConfirmationToken loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        ConfirmationToken entity = new ConfirmationToken();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        ConfirmationToken loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<ConfirmationToken> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<ConfirmationToken> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        ConfirmationToken given = constructSample(1);
        ConfirmationToken saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private ConfirmationToken constructSample(int i) {
		ConfirmationToken given = new ConfirmationToken();
        given.setToken("token-"+i);
        given.setExpiresAt(LocalDateTime.now());
        given.setCreatedAt(LocalDateTime.now());
        given.setConfirmedAt(LocalDateTime.now());
        given.setEtudiant(new Etudiant(1L));
        return given;
    }

}
