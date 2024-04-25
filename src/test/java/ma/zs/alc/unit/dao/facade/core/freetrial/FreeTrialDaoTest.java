package ma.zs.alc.unit.dao.facade.core.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrial;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialDao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.IntStream;
import java.time.LocalDateTime;

import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate ;
import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherWhatsTemplate ;
import ma.zs.alc.bean.core.freetrial.StatutFreeTrial ;
import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration ;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate ;
import ma.zs.alc.bean.core.prof.Prof ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate ;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class FreeTrialDaoTest {

@Autowired
    private FreeTrialDao underTest;

    @Test
    void shouldFindByReference(){
        String reference = "reference-1";
        FreeTrial entity = new FreeTrial();
        entity.setReference(reference);
        underTest.save(entity);
        FreeTrial loaded = underTest.findByReference(reference);
        assertThat(loaded.getReference()).isEqualTo(reference);
    }

    @Test
    void shouldDeleteByReference() {
        String reference = "reference-1";
        FreeTrial entity = new FreeTrial();
        entity.setReference(reference);
        underTest.save(entity);

        int result = underTest.deleteByReference(reference);

        FreeTrial loaded = underTest.findByReference(reference);
        assertThat(loaded).isNull();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldFindById(){
        Long id = 1L;
        FreeTrial entity = new FreeTrial();
        entity.setId(id);
        underTest.save(entity);
        FreeTrial loaded = underTest.findById(id).get();
        assertThat(loaded.getId()).isEqualTo(id);
    }

    @Test
    void shoulDeleteById() {
        Long id = 1L;
        FreeTrial entity = new FreeTrial();
        entity.setId(id);
        underTest.save(entity);

        underTest.deleteById(id);

        FreeTrial loaded = underTest.findById(id).get();
        assertThat(loaded).isNull();
    }


    @Test
    void shouldFindAll() {
        // Given
        List<FreeTrial> items = IntStream.rangeClosed(1, 10).mapToObj(i->constructSample(i)).collect(Collectors.toList());

        // Init
        items.forEach(underTest::save);

        // When
        List<FreeTrial> loadedItems = underTest.findAll();

        // Then
        assertThat(loadedItems).isNotNull();
        assertThat(loadedItems.size()).isEqualTo(10);
    }
    @Test
    void shouldSave(){
        FreeTrial given = constructSample(1);
        FreeTrial saved = underTest.save(given);
        assertThat(saved.getId()).isNotNull();
    }

    private FreeTrial constructSample(int i) {
		FreeTrial given = new FreeTrial();
        given.setReference("reference-"+i);
        given.setProf(new Prof(1L));
        given.setNiveauEtude(new NiveauEtude(1L));
        given.setDateFreeTrial(LocalDateTime.now());
        given.setLink("link-"+i);
        given.setEmailTeacherSent(false);
        given.setEmailTeacherSendingDate(LocalDateTime.now());
        given.setWhatsTeacherSent(false);
        given.setWhatsTeacherSendingDate(LocalDateTime.now());
        given.setFreeTrialStudentWhatsTemplate(new FreeTrialStudentWhatsTemplate(1L));
        given.setFreeTrialStudentEmailTemplate(new FreeTrialStudentEmailTemplate(1L));
        given.setFreeTrialTeacherEmailTemplate(new FreeTrialTeacherEmailTemplate(1L));
        given.setFreeTrialTeacherWhatsTemplate(new FreeTrialTeacherWhatsTemplate(1L));
        given.setDateFreeTrialPremierRappel(LocalDateTime.now());
        given.setDateFreeTrialPremierDeuxiemeRappel(LocalDateTime.now());
        given.setNombreStudentTotal(i);
        given.setFreeTrialConfiguration(new FreeTrialConfiguration(1L));
        given.setNombreStudentAbonne(i);
        given.setNombreStudentPresent(i);
        given.setStatutFreeTrial(new StatutFreeTrial(1L));
        return given;
    }

}
