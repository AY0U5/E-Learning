package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialTeacherEmailTemplate;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialTeacherEmailTemplateDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialTeacherEmailTemplateAdminServiceImpl;

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
class FreeTrialTeacherEmailTemplateAdminServiceImplTest {

    @Mock
    private FreeTrialTeacherEmailTemplateDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialTeacherEmailTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialTeacherEmailTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialTeacherEmailTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialTeacherEmailTemplate() {
        // Given
        FreeTrialTeacherEmailTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialTeacherEmailTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialTeacherEmailTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialTeacherEmailTemplate ID to retrieve
        FreeTrialTeacherEmailTemplate expected = new FreeTrialTeacherEmailTemplate(); // You need to replace FreeTrialTeacherEmailTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialTeacherEmailTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FreeTrialTeacherEmailTemplate constructSample(int i) {
		FreeTrialTeacherEmailTemplate given = new FreeTrialTeacherEmailTemplate();
        given.setObject("object-"+i);
        given.setCorps("corps-"+i);
        given.setSource("source-"+i);
        return given;
    }

}
