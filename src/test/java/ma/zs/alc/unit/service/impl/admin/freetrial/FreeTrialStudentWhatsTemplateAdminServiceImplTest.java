package ma.zs.alc.unit.service.impl.admin.freetrial;

import ma.zs.alc.bean.core.freetrial.FreeTrialStudentWhatsTemplate;
import ma.zs.alc.dao.facade.core.freetrial.FreeTrialStudentWhatsTemplateDao;
import ma.zs.alc.service.impl.admin.freetrial.FreeTrialStudentWhatsTemplateAdminServiceImpl;

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
class FreeTrialStudentWhatsTemplateAdminServiceImplTest {

    @Mock
    private FreeTrialStudentWhatsTemplateDao repository;
    private AutoCloseable autoCloseable;
    private FreeTrialStudentWhatsTemplateAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FreeTrialStudentWhatsTemplateAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFreeTrialStudentWhatsTemplate() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFreeTrialStudentWhatsTemplate() {
        // Given
        FreeTrialStudentWhatsTemplate toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFreeTrialStudentWhatsTemplate() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFreeTrialStudentWhatsTemplateById() {
        // Given
        Long idToRetrieve = 1L; // Example FreeTrialStudentWhatsTemplate ID to retrieve
        FreeTrialStudentWhatsTemplate expected = new FreeTrialStudentWhatsTemplate(); // You need to replace FreeTrialStudentWhatsTemplate with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FreeTrialStudentWhatsTemplate result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FreeTrialStudentWhatsTemplate constructSample(int i) {
		FreeTrialStudentWhatsTemplate given = new FreeTrialStudentWhatsTemplate();
        given.setObject("object-"+i);
        given.setCorps("corps-"+i);
        given.setSource("source-"+i);
        return given;
    }

}
