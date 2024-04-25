package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialformule;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialformuleDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialformuleAdminServiceImpl;

import ma.zs.alc.bean.core.grpe.Inscription ;
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
class FreeTrialformuleAdminServiceImplTest {

    @Mock
    private FreeTrialformuleDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialformuleAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialformuleAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialformule() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialformule() {
        // Given
        FreeTrialformule toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialformule() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialformuleById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialformule ID to retrieve
        FreeTrialformule expected = new FreeTrialformule(); // You need to replace FreeTrialformule with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialformule result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FreeTrialformule constructSample(int i) {
		FreeTrialformule given = new FreeTrialformule();
        given.setCode("code-"+i);
        given.setInscription(new Inscription(1L));
        given.setDayspeerweek("dayspeerweek-"+i);
        given.setTimeperday("timeperday-"+i);
        given.setTeacherGenderoption("teacherGenderoption-"+i);
        given.setTeacherAgeRange("teacherAgeRange-"+i);
        given.setTeacherPersonnality("teacherPersonnality-"+i);
        given.setStatus(false);
        given.setDateConfirmation(LocalDateTime.now());
        return given;
    }

}
