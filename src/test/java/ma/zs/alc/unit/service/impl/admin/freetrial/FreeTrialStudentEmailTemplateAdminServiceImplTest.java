package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialStudentEmailTemplate;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialStudentEmailTemplateDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialStudentEmailTemplateAdminServiceImpl;

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
class FreeTrialStudentEmailTemplateAdminServiceImplTest {

    @Mock
    private FreeTrialStudentEmailTemplateDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialStudentEmailTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialStudentEmailTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialStudentEmailTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialStudentEmailTemplate() {
        // Given
        FreeTrialStudentEmailTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialStudentEmailTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialStudentEmailTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialStudentEmailTemplate ID to retrieve
        FreeTrialStudentEmailTemplate expected = new FreeTrialStudentEmailTemplate(); // You need to replace FreeTrialStudentEmailTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialStudentEmailTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FreeTrialStudentEmailTemplate constructSample(int i) {
		FreeTrialStudentEmailTemplate given = new FreeTrialStudentEmailTemplate();
        given.setObject("object-"+i);
        given.setCorps("corps-"+i);
        given.setSource("source-"+i);
        return given;
    }

}
