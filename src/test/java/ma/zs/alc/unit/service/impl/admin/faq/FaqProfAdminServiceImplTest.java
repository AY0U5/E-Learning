package ma.zs.alc.unit.service.impl.admin.faq;

import ma.zs.alc.bean.core.faq.FaqProf;
import ma.zs.alc.dao.facade.core.faq.FaqProfDao;
import ma.zs.alc.service.impl.admin.faq.FaqProfAdminServiceImpl;

import ma.zs.alc.bean.core.faq.FaqType ;
import ma.zs.alc.bean.core.alc.Admin ;
import ma.zs.alc.bean.core.prof.Prof ;
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
class FaqProfAdminServiceImplTest {

    @Mock
    private FaqProfDao repository;
    private AutoCloseable autoCloseable;
    private FaqProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FaqProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFaqProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFaqProf() {
        // Given
        FaqProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFaqProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFaqProfById() {
        // Given
        Long idToRetrieve = 1L; // Example FaqProf ID to retrieve
        FaqProf expected = new FaqProf(); // You need to replace FaqProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FaqProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FaqProf constructSample(int i) {
		FaqProf given = new FaqProf();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setProf(new Prof(1L));
        given.setAdmin(new Admin(1L));
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
