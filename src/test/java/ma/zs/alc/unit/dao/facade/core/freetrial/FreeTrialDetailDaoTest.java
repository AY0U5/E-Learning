package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialDetail;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialDetailDao;

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
import ma.zs.alc.bean.core.freetrial.FreeTrial ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FreeTrialDetailDaoTest {

@Autowired
    private FreeTrialDetailDao underTest;


    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrialDetail entity = new FreeTrialDetail();
        entity.setId(id);
        underTest.save(entity);
        FreeTrialDetail loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrialDetail entity = new FreeTrialDetail();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrialDetail loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrialDetail> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrialDetail> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrialDetail given = constructSample(1);
        FreeTrialDetail saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrialDetail constructSample(int i) {
		FreeTrialDetail given = new FreeTrialDetail();
        given.setFreeTrial(new FreeTrial(1L));
        given.setEtudiant(new Etudiant(1L));
        given.setPresence(false);
        given.setWhatsUpMessageSent(false);
        given.setDateEnvoiwhatsUpMessage(LocalDateTime.now());
        given.setEmailMessageSent(false);
        given.setDateEnvoiEmailMessage(LocalDateTime.now());
        given.setAbonne(false);
        return given;
    }

}
