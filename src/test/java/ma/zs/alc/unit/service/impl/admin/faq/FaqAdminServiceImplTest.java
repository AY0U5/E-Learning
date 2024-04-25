package ma.zs.alc.unit.service.impl.admin.faq;

import ma.zs.alc.bean.core.faq.Faq;
import ma.zs.alc.dao.facade.core.faq.FaqDao;
import ma.zs.alc.service.impl.admin.faq.FaqAdminServiceImpl;

import ma.zs.alc.bean.core.faq.FaqType ;
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
class FaqAdminServiceImplTest {

    @Mock
    private FaqDao repository;
    private AutoCloseable autoCloseable;
    private FaqAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FaqAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFaq() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFaq() {
        // Given
        Faq toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFaq() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFaqById() {
        // Given
        Long idToRetrieve = 1L; // Example Faq ID to retrieve
        Faq expected = new Faq(); // You need to replace Faq with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        Faq result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private Faq constructSample(int i) {
		Faq given = new Faq();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
