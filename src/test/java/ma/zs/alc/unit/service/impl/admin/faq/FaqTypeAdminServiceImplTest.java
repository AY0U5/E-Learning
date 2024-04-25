package ma.zs.alc.unit.service.impl.admin.faq;

import ma.zs.alc.bean.core.faq.FaqType;
import ma.zs.alc.dao.facade.core.faq.FaqTypeDao;
import ma.zs.alc.service.impl.admin.faq.FaqTypeAdminServiceImpl;

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
class FaqTypeAdminServiceImplTest {

    @Mock
    private FaqTypeDao repository;
    private AutoCloseable autoCloseable;
    private FaqTypeAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FaqTypeAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFaqType() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFaqType() {
        // Given
        FaqType toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFaqType() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFaqTypeById() {
        // Given
        Long idToRetrieve = 1L; // Example FaqType ID to retrieve
        FaqType expected = new FaqType(); // You need to replace FaqType with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FaqType result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FaqType constructSample(int i) {
		FaqType given = new FaqType();
        given.setDestinataire("destinataire-"+i);
        given.setLibelle("libelle-"+i);
        return given;
    }

}
