package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrial;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialAdminServiceImpl;

import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate ;
import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherWhatsTemplate ;
import ma.zs.alc.bean.core.freetrial.StatutFreeTrial ;
import ma.zs.alc.bean.core.freetrial.FreeTrialConfiguration ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate ;
import ma.zs.alc.bean.core.freetrial.FreeTrialDetail ;
import ma.zs.alc.bean.core.freetrial.FreeTrial ;
import ma.zs.alc.bean.core.prof.Prof ;
import ma.zs.alc.bean.core.inscriptionref.NiveauEtude ;
import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate ;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.time.LocalDateTime;



import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
class FreeTrialAdminServiceImplTest {

    @Mock
    private FreeTrialDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrial() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrial() {
        // Given
        FreeTrial toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrial() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrial ID to retrieve
        FreeTrial expected = new FreeTrial(); // You need to replace FreeTrial with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrial result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
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
        List<FreeTrialDetail> freeTrialDetails = IntStream.rangeClosed(1, 3)
                                             .mapToObj(id -> {
                                                FreeTrialDetail element = new FreeTrialDetail();
                                                element.setId((long)id);
                                                element.setFreeTrial(new FreeTrial(Long.valueOf(1)));
                                                element.setEtudiant(new Etudiant(Long.valueOf(2)));
                                                element.setPresence(true);
                                                element.setWhatsUpMessageSent(true);
                                                element.setDateEnvoiwhatsUpMessage(LocalDateTime.now());
                                                element.setEmailMessageSent(true);
                                                element.setDateEnvoiEmailMessage(LocalDateTime.now());
                                                element.setAbonne(true);
                                                return element;
                                             })
                                             .collect(Collectors.toList());
        given.setFreeTrialDetails(freeTrialDetails);
        return given;
    }

}
