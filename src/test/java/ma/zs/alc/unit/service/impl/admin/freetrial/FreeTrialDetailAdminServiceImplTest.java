package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialDetail;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialDetailDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialDetailAdminServiceImpl;

import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.freetrial.FreeTrial ;
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
class FreeTrialDetailAdminServiceImplTest {

    @Mock
    private FreeTrialDetailDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialDetailAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialDetailAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialDetail() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialDetail() {
        // Given
        FreeTrialDetail toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialDetail() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialDetailById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialDetail ID to retrieve
        FreeTrialDetail expected = new FreeTrialDetail(); // You need to replace FreeTrialDetail with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialDetail result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
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
