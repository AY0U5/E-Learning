package ma.zs.alc.unit.dao.facade.core.paiement;

import ma.zs.alc.bean.core.paiement.Paiement;
import ma.zs.alc.dao.facade.core.paiement.PaiementDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.grpe.GroupeEtudiant ;
import ma.zs.alc.bean.core.prof.Prof ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PaiementDaoTest {

@Autowired
    private PaiementDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        Paiement entity = new Paiement();
        entity.setId(id);
        underTest.save(entity);
        Paiement loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        Paiement entity = new Paiement();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        Paiement loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<Paiement> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<Paiement> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        Paiement given = constructSample(1);
        Paiement saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private Paiement constructSample(int i) {
		Paiement given = new Paiement();
        given.setProf(new Prof(1L));
        given.setDatePaiement(LocalDateTime.now());
        given.setGroupeEtudiant(new GroupeEtudiant(1L));
        return given;
    }

}
