package ma.zs.alc.unit.service.impl.admin.recomrecla;

import ma.zs.alc.bean.core.recomrecla.ReclamationProf;
import ma.zs.alc.dao.facade.core.recomrecla.ReclamationProfDao;
import ma.zs.alc.service.impl.admin.recomrecla.ReclamationProfAdminServiceImpl;

import ma.zs.alc.bean.core.recomrecla.TypeReclamationProf ;
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
class ReclamationProfAdminServiceImplTest {

    @Mock
    private ReclamationProfDao repository;
    private AutoCloseable autoCloseable;
    private ReclamationProfAdminServiceImpl underTest;



    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        underTest = new ReclamationProfAdminServiceImpl(repository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    void canGetAllReclamationProf() {
         //when
        underTest.findAll();
        verify(repository).findAll();
    }

    @Test
    void itShouldSaveReclamationProf() {
        // Given
        ReclamationProf toSave = constructSample(1);
        when(repository.save(toSave)).thenReturn(toSave);

        // When
        underTest.create(toSave);

        // Then
        verify(repository).save(toSave);
    }

    @Test
    void itShouldDeleteReclamationProf() {
        // Given
        Long idToDelete = 1L;
        when(repository.existsById(idToDelete)).thenReturn(true);

        // When
        underTest.deleteById(idToDelete);

        // Then
        verify(repository).deleteById(idToDelete);
    }
    @Test
    void itShouldGetReclamationProfById() {
        // Given
        Long idToRetrieve = 1L; // Example ReclamationProf ID to retrieve
        ReclamationProf expected = new ReclamationProf(); // You need to replace ReclamationProf with your actual class
        expected.setId(idToRetrieve);
        when(repository.findById(idToRetrieve)).thenReturn(java.util.Optional.of(expected));

        // When
        ReclamationProf result = underTest.findById(idToRetrieve);

        // Then
        assertEquals(expected, result);
    }
	
	private ReclamationProf constructSample(int i) {
		ReclamationProf given = new ReclamationProf();
        given.setReference("reference-"+i);
        given.setDateReclamation(LocalDateTime.now());
        given.setMessage("message-"+i);
        given.setTraite(false);
        given.setDateTraitement(LocalDateTime.now());
        given.setDateReponse(LocalDateTime.now());
        given.setPostView(false);
        given.setCommentaireTraiteur("commentaireTraiteur-"+i);
        given.setObjetReclamationProf("objetReclamationProf-"+i);
        given.setAdmin(new Admin(1L));
        given.setProf(new Prof(1L));
        given.setTypeReclamationProf(new TypeReclamationProf(1L));
        return given;
    }

}
