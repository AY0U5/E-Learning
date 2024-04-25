package ma.zs.alc.unit.service.impl.admin.faq;

import ma.zs.alc.bean.core.faq.FaqEtudiant;
import ma.zs.alc.dao.facade.core.faq.FaqEtudiantDao;
import ma.zs.alc.service.impl.admin.faq.FaqEtudiantAdminServiceImpl;

import ma.zs.alc.bean.core.faq.FaqType ;
import ma.zs.alc.bean.core.inscription.Etudiant ;
import ma.zs.alc.bean.core.alc.Admin ;
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
class FaqEtudiantAdminServiceImplTest {

    @Mock
    private FaqEtudiantDao repository;
    private AutoCloseable autoCloseable;
    private FaqEtudiantAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new FaqEtudiantAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllFaqEtudiant() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveFaqEtudiant() {
        // Given
        FaqEtudiant toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteFaqEtudiant() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetFaqEtudiantById() {
        // Given
        Long idToRetrieve = 1L; // Example FaqEtudiant ID to retrieve
        FaqEtudiant expected = new FaqEtudiant(); // You need to replace FaqEtudiant with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        FaqEtudiant result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private FaqEtudiant constructSample(int i) {
		FaqEtudiant given = new FaqEtudiant();
        given.setDescription("description-"+i);
        given.setLibelle("libelle-"+i);
        given.setEtudiant(new Etudiant(1L));
        given.setAdmin(new Admin(1L));
        given.setFaqType(new FaqType(1L));
        return given;
    }

}
